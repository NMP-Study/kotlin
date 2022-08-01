package chapter.chapter6

fun main() {
    "a".isNullOrEmpty()

//    null.isNullOrEmpty()
    (null as? CharSequence).isNullOrEmpty()

    (null as? CharSequence)?.let { print(it) }
    (null as? CharSequence).let { print(it.isNullOrEmpty()) }

    null + 1
    1 + 1

    println(null + "world") // String?
    println("hello" + null)

    println(null + null)
}

fun String?.test(): String? {
    return this?.plus("1")
}
