package io.itsydv.quizapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.itsydv.quizapp.models.QuestionModel

@Database(entities = [QuestionModel::class], version = 1, exportSchema = false)
@TypeConverters(DataConverter::class)
abstract class QuestionsDatabase: RoomDatabase() {

    abstract fun questionsDao(): QuestionsDao

    companion object {
        @Volatile
        private var INSTANCE: QuestionsDatabase? = null

        fun getDatabase(context: Context): QuestionsDatabase {

            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    QuestionsDatabase::class.java,
                    "questions_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}