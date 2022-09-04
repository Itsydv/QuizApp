package io.itsydv.quizapp.models

data class Option(
    val id: String,
    val image: String?,
    val isCorrect: Boolean,
    val text: String?
)