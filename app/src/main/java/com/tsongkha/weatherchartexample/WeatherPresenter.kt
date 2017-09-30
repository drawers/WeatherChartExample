package com.tsongkha.weatherchartexample

import com.github.mikephil.charting.data.Entry
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableObserver
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import org.threeten.bp.ZonedDateTime
import java.util.*
import javax.inject.Inject

/**
 * Created by rawsond on 24/09/17.
 */
class WeatherPresenter
@Inject constructor(private val repo: TemperatureRepository,
                    private val entryFactory: EntryFactory,
                    private val labelFactory: LabelFactory) : WeatherContract.Presenter {

    val entries: MutableList<Entry> = ArrayList()
    val labels: MutableList<String> = ArrayList()

    private var view: WeatherContract.View? = null
    private var disposables: CompositeDisposable = CompositeDisposable()

    override fun takeView(v: WeatherContract.View) {
        this.view = v
        loadTemperatures(ZonedDateTime.now().minusDays(1), ZonedDateTime.now())
    }

    override fun dropView() {
        disposables.clear()
        view = null
    }

    override fun loadTemperatures(startInclusive: ZonedDateTime, endInclusive: ZonedDateTime) {
        var count = 0
        repo.temperatures()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<TemperatureSample>() {
                    override fun onError(e: Throwable) {
                        throw e
                    }

                    override fun onNext(t: TemperatureSample) {
                        entries.add(entryFactory.create(count, t))
                        labels.add(labelFactory.create(t))
                        count++
                    }

                    override fun onComplete() {
                        view?.showChart(entries, labels);
                    }
                })
                .addTo(disposables)
    }


}