package chapter3

/**
 * Chapter 3) 3.1 코틀린에서 컬렉션 만들기
 */
fun main() {
    // 집합을 만드는 방법
    val set = hashSetOf(1, 7, 53)

    // 리스트를 만드는 방법
    val list = arrayListOf(1, 7, 53)

    // 맵을 만드는 방법
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

    val strings = listOf("first", "second", "fourteenth")
    // fourteenth
    println(strings.last())

    val numbers = setOf(1, 14, 2)
    // 14
    // Kotlin 1.4 버전부터 `maxOrNull`로 변경됨(1.5 이상 버전부터 `max`는 오류 발생)
    println(numbers.maxOrNull())
}
