package com.tsongkha.weatherchartexample.stories.swipe

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.PagerAdapter
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

    override fun getItemPosition(`object`: Any?): Int {
        //always recreate the fragment in case of notifyDatasetChanged() - see https://stackoverflow.com/questions/18088076/update-fragment-from-viewpager
        return PagerAdapter.POSITION_NONE
    }
}