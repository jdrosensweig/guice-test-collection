package com.xyleo.guice_test;

/**
 * Created by J.D. Rosensweig on 2/10/15.
 */
public class AdditiveAggregator implements NumberAggregator {
    int _runningSum;

    public AdditiveAggregator() {
    }

    @Override
    public void insert(int number) {
        _runningSum += number;
    }

    @Override
    public int getAggregation() {
        return _runningSum;
    }
}
