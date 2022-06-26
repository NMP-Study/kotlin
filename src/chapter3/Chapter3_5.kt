package chapter3

/**
 * Chapter 3) 3.5 문자열 나누기
 */
fun main() {
    /**
     * 3.5.1 문자열 나누기
     */
    println("12.345-6.A".split("\\.|-".toRegex()))
    println("12.345-6.A".split(".", "-"))

    /**
     * 3.5.2 정규식과 3중 따옴표로 묶은 문자열
     */
    println(parsePathWithRegex("/Users/yole/kotlin-book/chapter.adoc"))


    /**
     * 3.5.3 여러 줄 3중 따옴표 문자열
     */
    val kotlinLogo = """| //
                        .| //
                        .|/ |"""
    println(kotlinLogo.trimMargin("."))
}

// String 확장 함수를 사용해 경로 파싱
fun parsePath(path: String) {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")
    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")
    println("Dir: ${directory}, name:${fileName}, ext: ${extension}")
}

// 경로 파싱에 정규식 사용하기
fun parsePathWithRegex(path: String) {
    // "\" escape 불필요
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)

    if(matchResult != null) {
        val (directory, fileName, extension) = matchResult.destructured
        println("Dir: ${directory}, name:${fileName}, ext: ${extension}")
    }
}
