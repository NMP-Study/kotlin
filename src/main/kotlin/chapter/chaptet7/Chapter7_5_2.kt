package chapter.chaptet7

fun main() {
    val p = Person("Kimtaeng")
    p.emails
    p.emails
}

class Email {
    /* ... */
}

fun loadEmails(person: Person): List<Email> {
    println("${person.name}의 이메일을 가져옴")
    return listOf(/* ... */)
}

//class Person(val name: String) {
//    private var _emails: List<Email>? = null
//    val emails: List<Email>
//        get() {
//            if (_emails == null) {
//                _emails = loadEmails(this)
//            }
//            return _emails!! // 6장에서 나온 Non-null assertion operator
//        }
//}

class Person(val name: String) {
    val emails by lazy { loadEmails(this) }
}

