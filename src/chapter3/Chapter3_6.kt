package chapter3

/**
 * Chapter 3) 3.6 코드 다듬기: 로컬 함수와 확장
 */
class User(val id: Int, val name: String, val address: String)

// 로컬 함수 기반
fun saveUser(user: User) {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(
                "Can`t save user ${user.id}: empty ${fieldName}"
            )
        }
    }
    validate(user.name, "Name")
    validate(user.address, "Address")
}

// 확장 함수 기반
fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(
                "Can`t save user ${id}: empty ${fieldName}"
            )
        }
    }
    validate(name, "Name")
    validate(address, "Address")
}

fun saveUser2(user: User) {
    user.validateBeforeSave()
}

fun main() {
    saveUser(User(1, "a", "a"))
    saveUser(User(1, "a", ""))
}
