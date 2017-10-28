package com.tsongkha.weatherchartexample.stories.swipe

import android.os.Bundle
import com.tsongkha.weatherchartexample.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_swipe.*

/**
 * Created by rawsond on 23/10/17.
 */
class SwipeActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swipe)
        swipe_viewpager.adapter = SwipePagerAdapter(supportFragmentManager!!)
    }
}