package chapter.chapter8

val people = listOf(Person("Alice", 29), Person("Bob", 31))

fun lookForAlice(people: List<Person>) {
    for (person in people) {
        if (person.name == "Alice")
            println("Found!!")
            return
    }
    println("Alice is not Found")
}

fun lookForAliceForEach(people: List<Person>) {
    people.forEach {
        if (it.name == "Alice") {
            println("Found!!")
            return
        }
    }
    println("Alice is not Found")
}

fun lookForAliceLabel(people: List<Person>) {
    people.forEach label@{
        if (it.name == "Alice") return@label
    }
    println("Alice might be somewhere")
}

fun lookForAliceLabelForEach(people: List<Person>) {
    people.forEach {
        if (it.name == "Alice") return@forEach
    }
    println("Alice might be somewhere")
}

fun lookForAliceAnonymous(people: List<Person>) {
    people.forEach(fun(person) {
        // return은 가장 가까운 함수 -> 익명함수
        if (person.name == "Alice") return
        println("${person.name} is not Alice")
    })

    people.filter(fun(person): Boolean { return person.age < 30 })
    // return 생략 가능
    people.filter(fun(person) = person.age < 30)
}

fun main() {
    lookForAlice(people)
    lookForAliceForEach(people)
    lookForAliceLabel(people)
    lookForAliceLabelForEach(people)
    lookForAliceAnonymous(people)
}