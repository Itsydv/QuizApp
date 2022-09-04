package io.itsydv.quizapp

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.itsydv.quizapp.models.QuestionModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.IOException

class FeedViewModel(context: Context): ViewModel() {

    private val questionRepo = QuestionsRepo()
    private val _questions = MutableLiveData<Resource<ArrayList<QuestionModel>>>()
    val questions get() = _questions

    init {
        getQuestions(context)
    }

    private fun getQuestions(context: Context) {
        _questions.postValue(Resource.Loading())
        viewModelScope.launch {
            delay(1700)
            try {
                val data = questionRepo.getQuestions(context)
                _questions.postValue(Resource.Success(data.reversed() as ArrayList<QuestionModel>))
            } catch (e: IOException) {
                _questions.postValue(Resource.Error("Connection failed", null))
            } catch (e: Exception) {
                _questions.postValue(Resource.Error("Something went wrong", null))
            }
        }
    }

}