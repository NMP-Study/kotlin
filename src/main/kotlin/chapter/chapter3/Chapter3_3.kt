package chapter3

fun main() {
    println("Kotlin".lastChar())
    methodOverrideExample()
    extensionFunctionsOverrideExample()
    extensionPropertiesExample()
}


/**
 * `String`의 확장 함수 정의
 * 확장이 될 대상 클래스를 "수신 객체 타입", 확장 함수가 호출되는 대상이 되는 객체를 "수신 객체"라고 한다.
 * 예제에서는 수신 객체 타입은 String, 수신 객체는 "Kotlin"
 */
fun String.lastChar(): Char = this[this.length - 1]


/**
 * 멤버 함수 오버라이드
 */
fun methodOverrideExample() {
    val view: View = Button()
    // "Button Clicked"
    view.click()
}

/**
 * 확장 함수는 오버라이드할 수 없다.
 */
fun extensionFunctionsOverrideExample() {
    fun View.showOff() = println("I'm a view!")
    fun Button.showOff() = println("I'm a button!")

    val view: View = Button()
    // "I'm a view!"
    view.showOff()
}

// 클래스 상속, 멤버 함수 오버라이드 예시
open class View {
    open fun click() = println("View Clicked")
}

class Button : View() {
    override fun click() = println("Button Clicked")
}


fun extensionPropertiesExample() {
    // n
    println("Kotlin".lastChar)

    val sb = StringBuilder("Kotlin?")
    sb.lastChar = '!'
    // Kotlin!
    println(sb)
}

// 확장 프로퍼티
val String.lastChar: Char
    get() = get(length - 1)


// 변경 가능한 확장 프로퍼티
var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char) {
        setCharAt(length - 1, value)
    }

