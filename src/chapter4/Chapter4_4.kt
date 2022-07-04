package chapter4

import java.awt.Window
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.io.File

object CaseInsensitiveFileComparator: Comparator<File> {
    override fun compare (filel: File, file2: File) : Int {
        return filel.path. compareTo (file2.path, ignoreCase = true)
    }
}

data class Person(val name: String) {
    object NameComparator : Comparator<Person> {
        override fun compare(p1: Person, p2: Person): Int =
            p1.name.compareTo(p2.name)
    }
}

fun getFacebookName(accountId: Int) = "fb:$accountId"

/*class User {
    val nickname: String

    constructor(email: String) {
        nickname = email.substringBefore('@')
    }

    constructor(facebookAccountId: Int) {
        nickname =  getFacebookName(facebookAccountId)
    }
}*/

class User private constructor(val nickname: String) {
    companion object {
        fun newSubscribingUser(email: String) =
            User(email.substringBefore('@'))
        fun newFacebookUser(accountId: Int) =
            User(getFacebookName(accountId))
    }
}

interface JSONFactory<T> {
    fun fromJSON(jsonText: String?): T
}

class Person2(val name: String) {
    companion object: JSONFactory<Person> {
        override fun fromJSON(jsonText: String?): Person {
            return Person("Person")
        }
    }
}

fun <T> loadFromJSON(factory: JSONFactory<T>): T {
    println(factory)
    return Person2.fromJSON("") as T
}

class PersonExtend(val firstName: String, val lastName: String) {
    companion object {
    }
}

fun PersonExtend.Companion.fromJSON(json: String): Person {
    return Person("AAA")
}

fun countClicks(window: Window) {
    var clickCount = 0
    window.addMouseListener(
        object: MouseAdapter() {
            override fun mouseClicked(e: MouseEvent?) {
            clickCount++
            // super.mouseClicked(e)
        }
    })
}

fun object_test() {
    println(CaseInsensitiveFileComparator.compare(File("/Users"), File("/users")))

    val files = listOf(File("/a"), File("/b"))
    println(files.sortedWith(CaseInsensitiveFileComparator))

    val persons = listOf(Person("Bob"), Person("Alice"))
    println(persons.sortedWith(Person.NameComparator))
}

fun compainon_test() {
    val subscribingUser = User.newSubscribingUser("bob@gmail.com")
    val facebookUser = User.newFacebookUser(4)
    println(subscribingUser.nickname)
    println(facebookUser.nickname)

    println(loadFromJSON(Person2))
}

fun main() {
    object_test()
    compainon_test()
}