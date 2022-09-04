package io.itsydv.quizapp.models

data class QuestionModel(
    var questionIndex: Int?,
    val chapters: ArrayList<String>?,
    val exams: ArrayList<String>?,
    val id: String,
    val options: ArrayList<Option>,
    val previousYearPapers: ArrayList<String>?,
    val question: ImageNText,
    val solution: ImageNText,
    val source: String?,
    val subjects: ArrayList<String>?,
    val type: String?
)