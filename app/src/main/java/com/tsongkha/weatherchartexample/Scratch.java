package com.tsongkha.weatherchartexample;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by rawsond on 1/10/17.
 */

public class Scratch {

    DisposableObserver<TemperatureSample> d = new DisposableObserver<TemperatureSample>() {
        @Override
        public void onNext(TemperatureSample temperatureSample) {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    };
}
