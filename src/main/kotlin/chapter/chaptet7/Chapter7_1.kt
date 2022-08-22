package chaptet7

data class Point1(var x: Int, var y: Int) {
    // operator 키워드가 꼭 있어야함!
    operator fun plus(other: Point1): Point1 {
        println("멤버 함수")
        return Point1(x + other.x, y + other.y)
    }
}

operator fun Point1.plus(other: Point1): Point1 {
    println("확장 함수")
    return Point1(x + other.x, y + other.y)
}

//operator fun Point.plusAssign(other: Point) {
//    x = x + other.x
//    y = y + other.y
//}

//plus 를 plusAssign 처럼 사용한 경우
//operator fun Point.plus(other: Point) {
//    x = x + other.x
//    y = y + other.y
//}

fun main() {
    var p1 = Point1(10, 20)
    val p1Copy = p1
    val p2 = Point1(30, 40)
    p1 += p2
    println(p1 === p1Copy)
    println(p2)
}
