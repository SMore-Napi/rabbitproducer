package ru.innopolis.rabbitproducer

data class MessageDto(
    val gender: Gender,
    val name: String
) {
    override fun toString(): String {
        return "$gender:$name"
    }
}

enum class Gender {
    MALE, FEMALE
}
