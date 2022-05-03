package com.example.ecommerce.common.database.typeConverter

import androidx.room.TypeConverter
import com.example.ecommerce.data.Rate
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RateConverter {
    @TypeConverter
    fun fromMedia(value: Rate?): String? {
        if (value == null) return null
        val gson = Gson()
        val type = object : TypeToken<Rate>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toMedia(value: String?): Rate? {
        if (value == null) return null
        val gson = Gson()
        val type = object : TypeToken<Rate>() {}.type
        return gson.fromJson(value, type)
    }
}