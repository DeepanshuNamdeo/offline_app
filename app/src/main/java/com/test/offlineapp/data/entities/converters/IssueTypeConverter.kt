package com.test.offlineapp.data.entities.converters

import androidx.room.TypeConverter
import com.google.gson.Gson


class IssueTypeConverter<T> {

    @TypeConverter
    fun appToString(app: T): String = Gson().toJson(app)

    @TypeConverter
    fun stringToApp(string: String): T? {
        val typeParameterClass: T? = null
       return Gson().fromJson(string, typeParameterClass!!::class.java)
    }



}