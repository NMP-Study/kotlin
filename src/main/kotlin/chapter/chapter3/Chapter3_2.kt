package chapter3

/**
 * Chapter 3) 3.2 함수를 호출하기 쉽게 만들기
 */
fun main() {
    defaultCollectionFunctionExample()
    namedArgumentsExample()
    defaultArgumentsExample()


}

/**
 * 3.1 코틀린에서 컬렉션 만들기
 */
fun defaultCollectionFunctionExample() {
    val list = listOf(1, 2, 3)

    // [1, 2, 3] `toString()`이 호출된다.
    println(list)
}

/**
 * 3.2 함수를 호출하기 쉽게 만들기: 이름 붙인 인자
 */
fun namedArgumentsExample() {
    val list = listOf(1, 2, 3)

    // (1; 2; 3)
    println(joinToString(list, "; ", "(", ")"))

    // 이름 붙인 인자
    println(joinToString(list, separator = "; ", prefix = "(", postfix = ")"))

    // 오류 X: 순서 변경시 이름을 모두 명시하면 오류 발생하지 않음
    //println(joinToString(list2, separator = "; ", postfix = "(", prefix = ")"))

    // 오류 X: 모든 인자는 이름 명시안해도 오류 안나는듯?
    //println(joinToString(list2, separator = "; ", "(", ")"))
    //println(joinToString(list2, separator = "; ", "(", postfix = ")"))

    // 오류 O: 순서가 바뀐 경우 모든 인자에 이름 명시 필요
    //println(joinToString(list2, separator = "; ", postfix = "(", ")"))
}

fun defaultArgumentsExample() {
    val list = listOf(1, 2, 3)

    // 1, 2, 3
    joinToStringWithDefaultValue(list, ", ", "", "")

    // 1, 2, 3
    joinToStringWithDefaultValue(list)

    // 1; 2; 3
    joinToStringWithDefaultValue(list, "; ")

    // 이름 붙인 인자 + 인자 일부 생략 -> 순서와 상관없이 지정 가능
    // # 1, 2, 3;
    joinToStringWithDefaultValue(list, postfix = ";", prefix = "# ")
}

// Top-level Property
var opCount = 0

fun performOperation() {
    // 최상위 프로퍼티의 값 변경
    opCount++
}

fun reportOperationCount() {
    // 최상위 프로퍼티의 값을 읽는다.
    println("Operation performed $opCount times")
}


// 자바 변환시: private static final + getter
val UNIX_LINE_SEPARATOR = "\n"

// 자바 변환시: public static final
const val UNIX_LINE_SEPARATOR_WITH_COUNT = "\n"


/**
 * 인자 붙인 함수 예제용
 */
fun <T> joinToString(
        collection: Collection<T>,
        separator: String,
        prefix: String,
        postfix: String
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}


/**
 * 디폴트 파라미터 값이 있는 함수
 */
fun <T> joinToStringWithDefaultValue(
        collection: Collection<T>,
        separator: String = ", ",
        prefix: String = "",
        postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

/**
 * 간이 예제. 자바에서 코틀린 함수 호출
 * @see TestJava
 */
@JvmOverloads
fun taengtest(num: Int = 3, str: String = "", isTrue: Boolean = true) {
    print("num: ${num}, str: ${str}, isTrue: $isTrue")
}