package operator

import chaptet7.Point1
import java.time.LocalDate
import kotlin.reflect.typeOf

operator fun Point1.get(index: Int): Int {
    return when(index) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException()
    }
}

// 다른 타입의 파라미터 사용 가능
operator fun Point1.get(index: Char): Int {
    return when(index) {
        '0' -> x
        '1' -> y
        else -> throw IndexOutOfBoundsException()
    }
}

// 파라미터 여러개 가능
operator fun Point1.get(index: Int, index2: Int): Int {
    return when(index) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException()
    }
}

// set 은 상태값을 변경하므로 var 로 선언된 프로퍼티에 적용 가능
data class MutablePoint(var x: Int, var y: Int)
operator fun MutablePoint.set(index: Int, value: Int) {
    when(index) {
        0 -> x = value
        1 -> y = value
        else -> throw IndexOutOfBoundsException()
    }
}

//fun main() {
//    val mutablePoint = MutablePoint(10, 20)
//    mutablePoint[1] = 40
//    println(mutablePoint)
//}

operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
    object : Iterator<LocalDate> {
        var current = start
        override fun hasNext(): Boolean {
            println("hasNext!")
            return current <= endInclusive
        }
        override fun next(): LocalDate {
            println("next!")
            return current.apply {
                current = plusDays(1)
            }
        }
    }

// in & for loop 관례
fun main() {
    val aMap = mutableMapOf("a" to 1)
    aMap["b"] = 2

    val now = LocalDate.now()
    val vacation = now .. now.plusDays(10)
    println(now.plusWeeks(2) in vacation)

    val newYear = LocalDate.ofYearDay(2017, 1)
    val daysOff = newYear.minusDays(1)..newYear
    for (dayOff in daysOff) {
        println(dayOff)
    }
}
