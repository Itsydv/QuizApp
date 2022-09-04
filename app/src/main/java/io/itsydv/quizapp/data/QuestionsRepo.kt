package io.itsydv.quizapp.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.itsydv.quizapp.models.QuestionModel

class QuestionsRepo(private val questionsDao: QuestionsDao) {

    suspend fun unAttemptedQuestions() = questionsDao.getUnAttemptedQuestion()
    suspend fun attemptedQuestions() = questionsDao.getAttemptedQuestion()

    suspend fun updateQuestion(questionModel: QuestionModel) {
        questionsDao.updateQuestion(questionModel)
    }

    suspend fun loadQuestions(context: Context) {
        var questions = getQuestions(context)
        questions = questions.reversed().mapIndexed { index, question ->
            question.questionIndex = index
            question
        }
        questionsDao.insertQuestions(questions)
    }

    private fun getQuestions(context: Context): List<QuestionModel> {
        val gson = Gson()
        val jsonString = context.assets.open("questions.json").bufferedReader().use { it.readText() }
        val listQuestionType = object : TypeToken<List<QuestionModel>>() {}.type
        return gson.fromJson(jsonString, listQuestionType)
    }
}