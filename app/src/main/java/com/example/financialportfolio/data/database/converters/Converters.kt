package com.example.financialportfolio.data.database.converters

import android.util.Log
import androidx.room.TypeConverter
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Converters {
    private val dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE

    @TypeConverter
    fun fromLocalDate(date: LocalDate): String {
        return try {
            date.format(dateFormatter)
        } catch (e: Exception) {
            Log.d("Converter", "LocalDate")
        }.toString()
        "Try later"
    }

    @TypeConverter
    fun toLocalDate(dateString: String): LocalDate {
        return try {
            LocalDate.parse(dateString, dateFormatter)
        } catch (e: Exception) {
            Log.d("Converter", "LocalDate")
            LocalDate.MIN
        }
    }

}