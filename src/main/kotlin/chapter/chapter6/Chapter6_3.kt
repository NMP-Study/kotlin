package chapter.chapter6

fun main() {
    main1()
    main2()
    main3()
    main4()
    main5()
}

/**
 * Chapter 1) 6.3.1 널 가능성과 컬렉션
 */
fun main1() {
    // 리스트 안의 각 값이 널일 수 있음
    val nullableElementList: List<Int?>

    // 리스트 자체가 널일 수 있음
    val nullableList: List<Int>?

    // 리스트 자체가 널일 수 있으며, 리스트 안의 각 값이 널일 수 있음
    val nullableOrNullableElementList: List<Int?>?

    // 널 값을 걸러내는 filterNotNull 함수
    val numbers: List<Int?> = listOf(1, null, 3, null, 5, null, 6)
    println(numbers.filterNotNull())
}

/**
 * Chapter 2) 6.3.2 읽기 전용과 변경 가능한 컬렉션
 */
fun main2() {
    // MutableCollection 은 내부 값이 변경될 수 있다
    val src: Collection<Int> = arrayListOf(1, 3, 5, 7)
    val target: MutableCollection<Int> = arrayListOf(2, 4, 6)
    copyElements(src, target)
    println(src)
    println(target)

    val list = arrayListOf(1, 2, 3)
    val mutableList: MutableCollection<Int> = list
    val immutableList: Collection<Int> = list

    // mutableList 객체를 통해 값을 수정 시, immutableList 내용도 변경될 수 있음
}

fun <T> copyElements(src: Collection<T>, target: MutableCollection<T>) {
    for (el in src) {
        target.add(el)
    }
}

/**
 * Chapter 3) 6.3.3 코틀린 컬렉션과 자바
 */
fun main3() {
    val arrList: ArrayList<Int> = arrayListOf()
    val mutableList: MutableList<Int> = arrList
    val list: List<Int> = mutableList

    // 컬렉션을 자바 코드에게 넘길 때는 특별히 주의를 기울여야 한다
    val alphabets = listOf("a", "b", "c")
    printInUppercase(alphabets)
}

fun printInUppercase(list: List<String>) {
    println(list)
    println(list.first())
    println(CollectionUtils.uppercaseAll(list))
    println(list.first())
}

/**
 * Chapter 4) 6.3.4 컬렉션을 플랫폼 타입으로 다루기
 */
fun main4() {
}

/**
 * Chapter 5) 6.3.5 객체의 배열과 원시 타입의 배열
 */
fun main5() {
    // 배열 사용법
    val arr: Array<Int> = arrayOf(1, 2, 3)
    for (i in arr.indices) {
        println(i)
    }

    // 배열 생성
    val arr1: Array<Int> = arrayOf(1, 2, 3)
    val arr2: Array<Int?> = arrayOfNulls(5)
    val arr3: Array<String> = Array(26) { ('a' + it).toString() }

    println(arr1.joinToString(", "))
    println(arr2.joinToString(", "))
    println(arr3.joinToString(", "))

    // 컬렉션을 배열로 바꾸기
    val strings = listOf("a", "b", "c")
    println("%s, %s, %s".format(*strings.toTypedArray()))

    // 원시 타입 배열
    val primitiveArr1 = intArrayOf(1, 2, 3)
    val primitiveArr2 = IntArray(5)
    val primitiveArr3 = IntArray(5) { (it + 1) * (it + 1) }

    println(primitiveArr1.joinToString(", "))
    println(primitiveArr2.joinToString(", "))
    println(primitiveArr3.joinToString(", "))

    // 언박싱
    arrayOf(1, 2, 3).toIntArray()

    // 코틀린의 배열은 컬렉션에서 사용하는 모든 확장 함수 사용 가능
    val array = arrayOf("a", "b", "c")
    array.forEachIndexed { i, item -> println("index: ${i}, item: ${item}") }
}
