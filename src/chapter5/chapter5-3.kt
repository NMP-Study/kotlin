package chapter5

data class Person(val name: String, val age: Int)

class Book(val title: String, val authors: List<String>)

fun lazytest() {
    val people = listOf(Person("Alice", 31), Person("bob", 29), Person("Carol", 31))

    val result = people.asSequence()
        .map(Person::name)
        .filter { it.startsWith("A") }
        .toList()

    println(result)

    // sequence 동작 확인하기
    println("noSequence: ")
    val noSequence = listOf(1, 2, 3, 4)
        .map { print("map($it"); it * it }
        .filter { print("filter($it"); it % 2 == 0 }
        .toList()
    println()

    println("doSequence: ")
    val doSequence = listOf(1, 2, 3, 4).asSequence()
        .map { print("map($it)"); it * it }
        .filter { print("filter($it)"); it % 2 == 0 }
        .toList()
    println()
    println()

    // sequence 순서 확인하기
    println("map > filter")
    val mapfilter = people.asSequence().map{ print("map "); it.name }.filter { print("filter "); it.length < 4 }.toList()
    println()

    println("filter > map")
    val filtermap = people.asSequence().filter { print("filter "); it.name.length < 4 }.map{ print("map "); it.name }.toList()
    println()
    println()

    // generateSequence 사용
    val naturalNumbers = generateSequence(0) {it + 1}
    val numberTo100 = naturalNumbers.takeWhile { it <= 100 }
    // 최종연산
    println(numberTo100.sum())

}

/*class javaLambda {
    /* Java 메소드 */
    void postponeComputation(int delay, Runnable computation);

    /* 람다를 인자로 전달
   => 객체를 명시적으로 선언하지 X + 변수 포획 X
   => 호출시마다 같은 객체를 공유
    postponeComputation(1000) {println(42)}*/

    /* 람다를 인자로 전달
   => 객체를 명시적으로 선언 O
   => 호출시마다 새로운 객체를 생성
    postponeComputation(1000, object : Runnable {
        override fun run() {
            println(42)
        }
    })*/
}*/

fun alphabetWith():String {
    val stringBuilder = StringBuilder()
    return with(stringBuilder) { // 메서드 호출하려는 수신 객체 지정
        for(letter in 'A'..'Z') {
            this.append(letter) // this를 통해 앞에서 지정한 수신객체의 메서드 호출
        }
        append("\nNow I know the alphabet!") // this는 생략 가능
        this.toString() // 람다에서 값 반환!
    }
}

fun alphabetApply() = java.lang.StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet!")
}.toString()

fun main() {
    lazytest()
    //javaLambda()

}