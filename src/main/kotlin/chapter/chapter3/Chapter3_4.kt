package chapter3

import java.util.ArrayList

/**
 * Chapter 3) 3.4 컬렉션 처리: 가변길이 인지ㅏ, 중위 함수 호출, 라이브러리 지원
 */
fun main() {
    /**
     * 3.4.1 string api 확장 함수
     */
    val strings: List<String> = listOf("first", "second", "fourteenth")

    println(strings.last())


    val numbers: Collection<Int> = setOf(1, 14, 2)

    print(numbers.maxOrNull())

    /**
     * 3.4.2 가변 인자, spread
     */
    val array = arrayOf("1", "2", "3")
    val list = listOf("4", *array)
    println(list)


    /**
     * 3.4.3 중위호출, 구조분해
     */

    val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
    // 1.to("one") === 1 to "one"

    val (number, name) = 1 to "one";
    println("number: ${number}, name: ${name}")
}
