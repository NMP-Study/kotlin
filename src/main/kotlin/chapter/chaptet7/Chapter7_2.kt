package chaptet7

data class Point2(val x: Int, val y: Int) {
    // operator 가 아닌 override 키워드 사용
    // Any 의 equals 함수를 하는거라서
    override fun equals(other: Any?): Boolean {
        println("멤버함수")
        if (other === this) return true
        if (other !is Point2) return false
        return other.x == x && other.y == y
    }
}

fun Point2.equals(other: Any?): Boolean {
    println("확장함수")
    if (other === this) return true
    if (other !is Point2) return false
    return other.x == x && other.y == y
}

fun main() {
    val p1 = Point2(10, 20)
    val p2 = Point2(30, 40)
    println(p1 == p2)
}
