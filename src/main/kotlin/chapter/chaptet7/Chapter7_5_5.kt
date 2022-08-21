package chapter.chaptet7

fun main() {
    val p = Person_list7_25()
    val data = mapOf("name" to "Dmitry", "company" to "JetBrains")
    for ((attrName, value) in data) {
        p.setAttribute(attrName, value)
    }
    println(p.name)
}

// 값을 맵에 저장하는 프로퍼티 사용하기
class Person_list7_25 {
    // 추가 정보
    private val _attributes = hashMapOf<String, String>()

    fun setAttribute(attrName: String, value: String) {
        _attributes[attrName] = value
    }

    // 필수 정보
    val name: String
        get() = _attributes["name"]!!
}

// 값을 맵에 저장하는 위임 프로퍼티 사용하기
class Person_list7_26 {
    private val _attributes = hashMapOf<String, String>()
    fun setAttribute(attrName: String, value: String) {
        _attributes[attrName] = value
    }

    // 위임 프로퍼티로 맵을 사용한다.
    val name: String by _attributes
}