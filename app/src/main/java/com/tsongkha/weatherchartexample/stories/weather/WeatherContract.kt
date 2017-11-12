package com.tsongkha.weatherchartexample.stories.weather

import com.github.mikephil.charting.data.Entry

/**
 * Created by rawsond on 24/09/17.
 */
interface WeatherContract {

    interface Presenter {

        fun load(position: Int)

        fun takeView(v : View)

        fun dropView()
    }

    interface View {

        fun showChart(entries: List<Entry>, labels : List<String>)

        fun showTitle(title : String)
    }

    interface Interactor {

    }
}