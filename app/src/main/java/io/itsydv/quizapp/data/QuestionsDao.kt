package io.itsydv.quizapp.data

import androidx.room.*
import io.itsydv.quizapp.models.QuestionModel

@Dao
interface QuestionsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertQuestions(questions: List<QuestionModel>)

    @Update
    suspend fun updateQuestion(question: QuestionModel)

    @Query("SELECT * FROM questions where attempted = 0 ORDER BY questionIndex")
    suspend fun getUnAttemptedQuestion(): List<QuestionModel>

    @Query("SELECT * FROM questions where attempted = 1 ORDER BY questionIndex")
    suspend fun getAttemptedQuestion(): List<QuestionModel>
}