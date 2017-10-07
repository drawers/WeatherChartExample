package com.tsongkha.weatherchartexample

import org.threeten.bp.LocalTime
import org.threeten.bp.format.DateTimeFormatter
import javax.inject.Inject

/**
 * Created by rawsond on 7/10/17.
 */
class SimpleTimeFormatter @Inject constructor() {

    val dtf : DateTimeFormatter

    init {
        dtf = DateTimeFormatter.ofPattern("hh:mm")
    }

    fun format(time : LocalTime) = dtf.format(time)
}