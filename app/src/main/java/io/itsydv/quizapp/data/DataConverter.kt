package io.itsydv.quizapp.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.itsydv.quizapp.models.Option


class DataConverter {
    @TypeConverter
    fun fromOptionList(optionList: ArrayList<Option>): String {
        val gson = Gson()
        val type = object : TypeToken<ArrayList<Option>>() {}.type
        return gson.toJson(optionList, type)
    }

    @TypeConverter
    fun toOptionList(optionListString: String): ArrayList<Option> {
        val gson = Gson()
        val type = object : TypeToken<ArrayList<Option>>() {}.type
        return gson.fromJson(optionListString, type)
    }

    @TypeConverter
    fun fromStringList(stringList: ArrayList<String>?): String? {
        val gson = Gson()
        val type = object : TypeToken<ArrayList<String>?>() {}.type
        return gson.toJson(stringList, type)
    }

    @TypeConverter
    fun toStringList(listString: String?): ArrayList<String>? {
        val gson = Gson()
        val type = object : TypeToken<ArrayList<String>?>() {}.type
        return gson.fromJson(listString, type)
    }
}