package com.tsongkha.weatherchartexample

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var temperatureRepository : TemperatureRepository;

    lateinit var chart : TemperatureChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        chart = TemperatureChart(lineChart);
        chart.setData(temperatureRepository.temperatures());
    }
}
