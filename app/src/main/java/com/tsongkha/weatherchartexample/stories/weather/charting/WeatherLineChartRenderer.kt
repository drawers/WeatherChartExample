package com.tsongkha.weatherchartexample.stories.weather.charting

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import com.github.mikephil.charting.animation.ChartAnimator
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider
import com.github.mikephil.charting.renderer.LineChartRenderer
import com.github.mikephil.charting.utils.Transformer
import com.github.mikephil.charting.utils.ViewPortHandler

/**
 * Created by rawsond on 5/11/17.
 */
class WeatherLineChartRenderer(chart: LineDataProvider, animator: ChartAnimator, viewPortHandler: ViewPortHandler, private val sourceBitmap: Bitmap)
    : LineChartRenderer(chart, animator, viewPortHandler) {

    val TAG: String = this.javaClass.simpleName!!

    var imageSize: Int = 5
    var drawPredicate: (Float) -> Boolean = { true }

    private val imagePositionBuffer = FloatArray(2)

    private var resizedBitmap: Bitmap? = null

    override fun drawExtras(c: Canvas?) {
        super.drawExtras(c)
        drawImages(c)
    }

    fun drawImages(c: Canvas?) {
        mRenderPaint.style = Paint.Style.FILL

        val dataSets = mChart.lineData.dataSets

        for (i in dataSets.indices) {

            val dataSet = dataSets[i]

            if (!dataSet.isVisible || dataSet.entryCount == 0)
                continue

            val trans = mChart.getTransformer(dataSet.axisDependency)

            val adjustedImageSize = calculateAdjustedImageSize(trans)

            resizedBitmap = Bitmap.createScaledBitmap(sourceBitmap, adjustedImageSize.toInt(), adjustedImageSize.toInt(), false);

            mXBounds.set(mChart, dataSet)

            val boundsRangeCount = mXBounds.range + mXBounds.min

            for (j in mXBounds.min..boundsRangeCount) {

                val e = dataSet.getEntryForIndex(j) ?: break

                imagePositionBuffer[0] = e.x
                imagePositionBuffer[1] = e.y * mAnimator.phaseY

                trans.pointValuesToPixel(imagePositionBuffer)

                if (!mViewPortHandler.isInBoundsRight(imagePositionBuffer[0]))
                    break

                if (!mViewPortHandler.isInBoundsLeft(imagePositionBuffer[0]) || !mViewPortHandler.isInBoundsY(imagePositionBuffer[1]))
                    continue

                if (drawPredicate(e.x)) {
                    c?.drawBitmap(resizedBitmap, imagePositionBuffer[0] - adjustedImageSize, imagePositionBuffer[1] - adjustedImageSize * 1.25f, null)
                }
            }
        }
    }

    private fun calculateAdjustedImageSize(trans: Transformer): Float {
        val zero = floatArrayOf(0f, 0f)
        val one = floatArrayOf(1f, 1f)
        trans.pointValuesToPixel(zero)
        trans.pointValuesToPixel(one)
        val scalar = one[0] - zero[0]
        return scalar * imageSize
    }
}