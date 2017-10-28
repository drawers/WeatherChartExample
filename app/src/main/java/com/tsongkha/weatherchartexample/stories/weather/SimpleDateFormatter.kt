package com.tsongkha.weatherchartexample.stories.weather

import android.content.Context
import org.threeten.bp.LocalDate
import org.threeten.bp.ZoneId
import java.text.DateFormat
import java.util.*
import javax.inject.Inject

/**
 * Created by rawsond on 7/10/17.
 */
class SimpleDateFormatter @Inject constructor(ctx : Context) {

    val dtf : DateFormat = android.text.format.DateFormat.getMediumDateFormat(ctx)

    fun format(date : LocalDate) : String {
        val javaDate = Date(date.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli())
        return dtf.format(javaDate)
    }
}