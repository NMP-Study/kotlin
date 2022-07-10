package chapter2

/**
 * Chapter 2) 2.1.1 Hello, World!
 */
fun main1() {
    println("Hello, world!")
}


/**
 * Chapter 2) 2.1.2 함수
 */
fun main2() {
    println(max1(10, 20))
    println(max2(10, 20))
}

// 블록이 본문인 함수
fun max1(a: Int, b: Int): Int {
    return if (a > b) a else b
}

// 식이 본문인 함수
fun max2(a: Int, b: Int) = if (a > b) a else b


/**
 * Chapter 2) 2.1.3 변수
 */
fun main3() {
    // 변수 선언 방법
    val age1: Int = 21
    val age2 = 21 // 타입을 생략할 수 있다.


    // 똑똑한 컴파일러가 val이여도 한번만 초기화됨을 확인하면 허용
    val result: String
    if (isSuccess()) {
        result = "성공"
        // ... 기타 작업
    } else {
        result = "실패"
        // .. 기타 작업
    }
    // Compile Error!!!
//    result = "또 다른,"
}

fun isSuccess() = true


/**
 * Chapter 2) 2.1.4 문자열 템플릿
 */
fun main4() {
    val name = "홍길동"
    println("${name}님 반갑습니다!")

    // Compile Error!!!
//    println("$name님 반갑습니다!")
}
