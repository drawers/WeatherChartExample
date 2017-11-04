package com.tsongkha.weatherchartexample.stories.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.data.Entry
import com.tsongkha.weatherchartexample.R
import com.tsongkha.weatherchartexample.stories.weather.charting.TemperatureChart
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.weather_card.*
import javax.inject.Inject

/**
 * Created by rawsond on 23/10/17.
 */
class WeatherFragment : WeatherContract.View, DaggerFragment() {

    @Inject lateinit var presenter: WeatherContract.Presenter

    lateinit var chart: TemperatureChart

    companion object {
        @JvmStatic
        fun instantiate(args: Bundle?): WeatherFragment {
            with(WeatherFragment()) {
                arguments = args
                return this
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.weather_card, container, false)
    }

    override fun onResume() {
        super.onResume()
        chart = TemperatureChart(weather_linechart)
        val position = arguments?.getInt(WeatherConstants.VIEWPAGER_POSITION) ?: 0
        presenter.takeView(this)
        presenter.load(position)
    }

    override fun showChart(entries: List<Entry>, labels: List<String>) {
        chart.setData(entries, labels)
    }

    override fun showTitle(title: String) {
        weather_title.text = title
    }

    override fun onPause() {
        presenter.dropView()
        super.onPause()
    }
}