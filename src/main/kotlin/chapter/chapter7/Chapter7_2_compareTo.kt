package chaptet7

class Person3(
    val age: Int
) : Comparable<Person3> {
    override fun compareTo(other: Person3): Int {
        return compareValuesBy(this, other, Person3::age)
    }
}

fun main() {
    val person1 = Person3(10)
    val person2 = Person3(20)
    println(person1 < person2)
}
