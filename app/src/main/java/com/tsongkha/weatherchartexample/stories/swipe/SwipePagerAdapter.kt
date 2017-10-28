package com.tsongkha.weatherchartexample.stories.swipe

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.tsongkha.weatherchartexample.stories.weather.WeatherConstants
import com.tsongkha.weatherchartexample.stories.weather.WeatherFragment

class SwipePagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        with (Bundle()) {
            putSerializable(WeatherConstants.VIEWPAGER_POSITION, position)
            return WeatherFragment.instantiate(this)
        }
    }

    override fun getCount(): Int = WeatherConstants.DAY_COUNT
}