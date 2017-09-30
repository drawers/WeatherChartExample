package com.tsongkha.weatherchartexample

import android.os.Bundle
import com.github.mikephil.charting.data.Entry
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), WeatherContract.View {

    @Inject lateinit var presenter : WeatherContract.Presenter

    lateinit var chart : TemperatureChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        chart = TemperatureChart(lineChart)
        presenter.takeView(this)
    }


    override fun showChart(entries: List<Entry>, labels: List<String>) {
        chart.setData(entries, labels)
    }

    override fun onDestroy() {
        presenter.dropView();
        super.onDestroy()
    }
}
