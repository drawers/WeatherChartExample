package com.tsongkha.weatherchartexample.stories.weather.charting

import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.formatter.DefaultValueFormatter
import com.github.mikephil.charting.utils.ViewPortHandler

/**
 * Created by rawsond on 4/11/17.
 */
class ChartValueFormatter() : DefaultValueFormatter(0) {
    
    var formatPredicate : (Float) -> Boolean = { true }

    override fun getFormattedValue(value: Float, entry: Entry?, dataSetIndex: Int, viewPortHandler: ViewPortHandler?): String {
        if (formatPredicate(entry!!.x)) {
            return super.getFormattedValue(value, entry, dataSetIndex, viewPortHandler)
        }
        
        return ""
    }
}