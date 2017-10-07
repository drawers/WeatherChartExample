package com.tsongkha.weatherchartexample

import com.github.mikephil.charting.data.Entry
import org.threeten.bp.ZonedDateTime

/**
 * Created by rawsond on 24/09/17.
 */
interface WeatherContract {

    interface Presenter {

        fun loadTemperatures(startInclusive : ZonedDateTime, endInclusive : ZonedDateTime)

        fun takeView(v : View)

        fun dropView()
    }

    interface View {

        fun showChart(entries: List<Entry>, labels : List<String>)
    }

    interface Interactor {

    }
}