package chapter.chaptet7

import kotlin.reflect.KProperty

fun main() {
    // 7.5.1
    val foo = Foo(Bar(1))
    val oldValue = foo.p
    foo.p = Bar(2)
}

class Foo(p: Bar) {
    var p: Bar by Delegate()
}

class Bar(value: Int)

class Delegate {
    operator fun getValue(foo: Foo, property: KProperty<*>): Bar {
        println("Hi~ getValue")
        return Bar(1)
    }

    operator fun setValue(foo: Foo, property: KProperty<*>, bar: Bar) {
        println("Hi~ setValue")
    }
}



