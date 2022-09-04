package io.itsydv.quizapp

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.itsydv.quizapp.models.QuestionModel

class QuestionsRepo {

    fun getQuestions(context: Context): ArrayList<QuestionModel> {
        val gson = Gson()
        val jsonString = context.assets.open("questions.json").bufferedReader().use { it.readText() }
        val listQuestionType = object : TypeToken<ArrayList<QuestionModel>>() {}.type
        return gson.fromJson(jsonString, listQuestionType)
    }

}