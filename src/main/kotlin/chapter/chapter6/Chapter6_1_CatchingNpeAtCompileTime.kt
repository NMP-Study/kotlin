package chapter.chapter6

data class Person(val age: Int = 20, var name: String = "동그라미") {
    fun sayHello() = println("Hello~! My name is ${name}!")
}

data class Car(val owner: Person)

//fun main() {
//    personTest(Person())
//    personTest(null)
//
//    personArrayTest(arrayOf(Person()))
//    personArrayTest(null)
//
//    throwTest()
//
//    val car: Car? = null
//    (car?.owner)?.age
//
//    car?.let {
//        it.owner
//    }.age
//
//    car.let {
//        it?.owner
//    }.age
//}
//
//fun personTest(person: Person?) {
//    // Calling the instance method of a null object
//    person.sayHello()
//    // Accessing or modifying the field of a null object
//    person.age
//    person.name = "John"
//}
//
//fun personArrayTest(personArray: Array<Person>?) {
//    // Taking the length of null as if it were an array
//    personArray.size
//    // Accessing or modifying the slots of null as if it were an array
//    personArray[0]
//    personArray[0] = Person()
//}
//
//fun throwTest() {
//    throw java.lang.IllegalArgumentException()
//    // Throwing null as if it were a Throwable value
//    throw null
//}


fun main() {
    println("-- personTest(Person()) --")
    personTest(Person())
    println("\n-- personTest(null) --")
    personTest(null)

    println("\n-- personArrayTest(arrayOf(Person())) --")
    personArrayTest(arrayOf(Person()))
    println("\n-- personArrayTest(null) --")
    personArrayTest(null)

    println("\n-- Car? --")
    val car: Car? = null
    println("age: ${car?.owner?.age}")
    println("owner: ${car?.owner ?: Person()}")
}

fun personTest(person: Person?) {
    // Calling the instance method of a null object
    person?.sayHello()
    // Accessing or modifying the field of a null object
    println("age : ${person?.age}")
    person?.name = "동원빈"
    println("person : ${person}")

    println("name: ${person?.name ?: "Unknown"}")
}

fun personArrayTest(personArray: Array<Person>?) {
    // Taking the length of null as if it were an array
    println("size: ${personArray?.size}")
    // Accessing or modifying the slots of null as if it were an array
    println("get(0): ${personArray?.get(0)}")
    personArray?.set(0, Person())
    println("personArray: ${personArray?.toStr()}")

    println("age: ${personArray?.get(0)?.age ?: 0}")
}

fun <T> Array<T>.toStr() = buildString {
    append("[ ")
    this@toStr.mapIndexed { idx, it ->
        append(it.toString())
        if (idx > 0) {
            append(", ")
        }
    }
    append(" ]")
}
