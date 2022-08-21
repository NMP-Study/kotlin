package chapter.chaptet7

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

fun main() {
    val p = Person_2("Kimtaeng", 32, 2)
    p.addPropertyChangeListener(
        PropertyChangeListener { event ->
            println("Property ${event.propertyName} changed " + "from ${event.oldValue} to ${event.newValue}")
        }
    )

//    p.addPropertyChangeListener { event ->
//        println("Property ${event.propertyName} changed " + "from ${event.oldValue} to ${event.newValue}")
//    }

    p.age = 33
    // Property age changed from 32 to 33
    p.salary = 3
    // Property salary changed from 2 to 3
}

// -> 기본 구현(자바 빈즈)
open class PropertyChangeAware {
    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }
}

class Person_2(val name: String, age: Int, salary: Int) : PropertyChangeAware() {
    var age: Int = age
        set(newValue) {
            val oldValue = field
            field = newValue
            changeSupport.firePropertyChange("age", oldValue, newValue)
        }

    var salary: Int = salary
        set(newValue) {
            val oldValue = field
            field = newValue
            changeSupport.firePropertyChange("salary", oldValue, newValue)
        }
}
// <- 기본 구현(자바 빈즈)

// -> 공통 모듈화
class ObservableProperty(
    val propName: String, var propValue: Int, val changeSupport: PropertyChangeSupport
) {
    fun getValue(): Int = propValue
    fun setValue(newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(propName, oldValue, newValue)
    }
}

class Person_3(val name: String, age: Int, salary: Int) : PropertyChangeAware() {
    var _age = ObservableProperty("age", age, changeSupport)
    var age: Int
        get() = _age.getValue()
        set(value) {
            _age.setValue(value)
        }

    val _salary = ObservableProperty("salary", salary, changeSupport)
    var salary: Int
        get() = _salary.getValue()
        set(value) {
            _salary.setValue(value)
        }
}
// <- 공통 모듈화

// -> 위임 프로퍼티 사용
class DelegateObservableProperty(var propValue: Int, val changeSupport: PropertyChangeSupport) {
    operator fun getValue(p: Person_4, prop: KProperty<*>): Int = propValue
    operator fun setValue(p: Person_4, prop: KProperty<*>, newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }
}

class Person_4(val name: String, age: Int, salary: Int) : PropertyChangeAware() {
    var age: Int by DelegateObservableProperty(age, changeSupport)
    var salary: Int by DelegateObservableProperty(salary, changeSupport)
}
// <- 위임 프로퍼티 사용

// -> Delegates.observable
class Person_5(val name: String, age: Int, salary: Int) : PropertyChangeAware() {
    private val observer = { prop: KProperty<*>, oldValue: Int, newValue: Int ->
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }

    var age: Int by Delegates.observable(age, observer)
    var salary: Int by Delegates.observable(salary, observer)
}
// <- Delegates.observable