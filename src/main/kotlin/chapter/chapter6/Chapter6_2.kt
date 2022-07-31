package main.kotlin.chapter.chapter6

fun main() {
    main1()
    main2()
    main3()
    main4()
    main5()
    main6()
}

/**
 * Chapter 1) 6.2.1 원시 타입: Int, Boolean 등
 */
fun main1() {
    // 코틀린은 원시 타입도 메서드 사용 가능
    printProgress(1)
    printProgress(50)
    printProgress(100)
    printProgress(-1)
    printProgress(101)

    // 코틀린은 원시 타입도 컬렉션에 사용 가능
    val i: Int = 1
    val list: List<Int> = listOf(1, 2, 3)
    println(i)
    println(list)
}

fun printProgress(progress: Int) {
    println("Progressing... ${progress.coerceIn(0, 100)}%")
}

/**
 * Chapter 2) 6.2.2 널이 될 수 있는 원시 타입: Int?, Boolean? 등
 */
fun main2() {
    // weight는 원시 타입, age는 래퍼 타입
    val dave = Person("Dave", 70, 32)
    val sam = Person("Sam", 80, 35)
    val jane = Person("Jane", 50)

    println(dave.isOlderThan(sam))
    println(dave.isOlderThan(jane))
}

data class Person(val name: String, val weight: Int, val age: Int? = null) {
    fun isOlderThan(other: Person): Boolean? {
        if (age == null || other.age == null) {
            return null
        }
        return age > other.age
    }
}

/**
 * Chapter 3) 숫자 변환
 */
fun main3() {
    // 코틀린은 숫자 자동 변환 안됨
    val i = 1

    // 컬파일 오류!!!
//    val l1: Long = i

    // 직접 변환 메서드 사용
    val l2: Long = i.toLong()


    // 묵시적 변환을 허용하지 않는 이유
    val x = 1L
    val list = listOf(1L, 2L, 3L)
    // 컴파일 오류!!!
    println(x in list)
}

/**
 * Chapter 4) Any, Any?: 최상위 타입
 */
fun main4() {
    // Any는 Object로 대응됨
    val nonNullAny: Any
    val nullableAny: Any?

    // wait() 등 사용하려면 Object로 캐스트해야 한다.
    val answer: Any = 1
    val o: Object = answer as Object
}

/**
 * Chapter 5) Unit 타입: 코틀린의 void
 */
fun main5() {
    // 함수의 반환 타입 Unit은 쓰거나 안쓰거나 동일하다
    f1()
    f2()
}

fun f1(): Unit {
    println(1)
}

fun f2() {
    println(1)
}

interface Processor<T> {
    fun process(): T
}

class NoResultProcessor : Processor<Unit> {
    override fun process() {
        // 여기서 return 을 명시하지 않아도 된다.
    }
}

/**
 * Chapter 6) Nothing 타입: 이 함수는 결코 정상적으로 끝나지 않는다
 */
fun main6() {
    fail("Failed!!!")
}

fun fail(message: String): Nothing {
    throw IllegalStateException(message)
}
