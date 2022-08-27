package chapter.chapter8

import java.io.BufferedReader
import java.io.FileReader
import java.util.concurrent.locks.Lock

inline fun <T> synchronized(lock: Lock, action: () -> T): T {
    lock.lock()
    try {
        return action()
    }
    finally {
        lock.unlock()
    }
}

class LockOwner(val lock: Lock) {
    fun runUnderLock(body: () -> Unit) {
        synchronized(lock, body)
    }
}

fun function8_13(l: Lock) {
    println("Before sync")

    synchronized(l) {
        println("Action")
    }
    println("AfterSync")
}

data class Person(val name: String, val age: Int)

fun function8_14() {
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    println(people.filter {it.age < 30}
        .map(Person::name))
}

fun readFirstLineFromFile(path: String): String {
    BufferedReader(FileReader(path)).use {
        br -> return br.readLine()
    }
}

fun function8_17() {

}

fun main() {

}