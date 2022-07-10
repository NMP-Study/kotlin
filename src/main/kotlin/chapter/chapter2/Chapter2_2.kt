package chapter2

/**
 * Chapter 2) 2.2.1 프로퍼티
 */
class Article(
    val title: String,
    var content: String
)


/**
 * Chapter 2) 2.2.2 커스텀 접근자
 */
class Person(val age: Int) {
    val isAdult: Boolean
        get() {
            return age > 19
        }
}
