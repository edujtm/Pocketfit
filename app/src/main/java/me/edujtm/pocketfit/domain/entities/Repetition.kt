package me.edujtm.pocketfit.domain.entities


data class Repetition(
    val id: Int,
    val quantity: Int,
    val weight: Int
) {
    fun score(): Int {
        return quantity * weight
    }
}