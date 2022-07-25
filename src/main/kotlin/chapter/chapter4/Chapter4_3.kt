package chapter4

import java.lang.StringBuilder

class Client(val name: String, val postalCode: Int) {
    /*override fun toString() = "Client(name=${name})"
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Client)
            return false
        return name == other.name && postalCode == other.postalCode
    }*/
}

data class DataClient(val name: String, val postalCode: Int) {
    fun copy2(name: String = this.name, postalCode: Int = this.postalCode) = DataClient(name, postalCode)
}

open class SuperClient(var gender: String) {}
data class ExtendClient(val name: String, val postalCode: Int): SuperClient("Male") {
    override fun equals(other: Any?): Boolean {
        return super.gender == gender
    }
}

/*class DelegatingCollection<T>: Collection<T> {
    private val innerList = arravListof<T>()

    override val size: Int get () = innerList.size
    override fun isEmpty() : Boolean = innerList. isEmpty ()
    override fun contains(element: T) : Boolean = innerList.contains (element)
    override fun iterator(): Iterator<T> = innerList.iterator()
    override fun containsAll(elements: Collection<T>): Boolean = innerList. containsAll (elements)
}*/

class DelegatingCollection<T>(innerList: Collection<T> =
                                  ArrayList<T>()): Collection<T> by innerList {
}

class CountingSet<T>(
    val innerSet: MutableCollection<T> = HashSet<T>()
) : MutableCollection<T> by innerSet {
    var objectsAdded = 0

    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(c: Collection<T>): Boolean {
        objectsAdded += c.size
        return innerSet.addAll(c)
    }
}

fun equalsTest_1() {
    val num1 = 1;
    val num2 = 1;
    val str1 = "a"
    val str2 = "a"
    val str3 = String(StringBuilder("AAA"))
    var str4 = String(StringBuilder("AAA"))
    var list1 = listOf("A", "B", "C")
    var list2 = listOf("A", "B", "C")

    println(num1 == num2)
    println(num1 === num2)

    println(str1 == str2)
    println(str1 === str2)

    println(str3 == str4)
    println(str3 === str4)

    println(list1 == list2)
    println(list1 === list2)
    println(list1.hashCode())
    println(list2.hashCode())

    val client1 = Client("name", 11)
    val client2 = Client("name", 11)
    val dataClient1 = DataClient("name", 11)
    val dataClient2 = DataClient("name", 11)
    println(client1 == client2)
    println(client1 === client2)
    println(dataClient1 == dataClient2)
    println(dataClient1 === dataClient2)

    val extendClient1 = ExtendClient("name", 11)
    val extendClient2 = ExtendClient("name", 11).apply {
        gender = "FeMale"
    }
    println(extendClient1 == extendClient2)
    println(extendClient1 === extendClient2)
}


fun components_test() {
    val clientA = DataClient("name", 11)
    val (postalCode, name) = clientA
    println("Destructuring Declarations: ${name}, ${postalCode}")
    println(clientA.component1())
    println(clientA.component2())
}

fun by_test() {
    val cset = CountingSet<Int>()
    cset.addAll(listOf(1, 1, 2))
    println("${cset.objectsAdded} objects were added, ${cset.size} remain")
}

fun main() {
    equalsTest_1()
    components_test()
    by_test()
}