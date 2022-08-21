package chapter.chaptet7

fun main() {
    basicDestructuring()
    collectionDestructuring()
}

fun basicDestructuring() {
    val p = Point(10, 20)
    val (x, y) = p
    println(x) // 10
    println(y) // 20
}

data class Point(val x: Int, val y: Int)

/**
 * 데이터 타입이 아닌 클래스에도 정의할 수 있다.
 */
//class Point(val x: Int, val y: Int) {
//    operator fun component1() = x
//    operator fun component2() = y
//}


fun collectionDestructuring() {
    // 오류 없음
    val list = listOf(1, 2)
    val (a, b) = list
    println("a: $a, b: $b")

    // 런타임 오류 발생 "Index 2 out of bounds for length 2"
    val (x, y, z) = list


    // 컴파일 오류 발생 "Destructuring declaration initializer of type List<Int> must have a 'component6()' function"
    // val (e, f, g, h, i, j) = x

    val map = mapOf("key1" to "value1", "key2" to "value2")
    for ((key, value) in map) {
        println("$key: $value")
    }
}