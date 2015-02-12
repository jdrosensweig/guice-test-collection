package com.xyleo.guice_test;

import java.util.Random;

/**
 * Created by J.D. Rosensweig on 2/10/15.
 */
public class RandomNumberGenerator implements NumberGenerator {
    int _generatedNumberCount;

    @Override
    public int getNumber() throws Exception {
        Random generator = new Random();
        _generatedNumberCount++;
        return generator.nextInt(1000) + 1;
    }

    @Override
    public boolean hasNext() {
        return (_generatedNumberCount < 20);
    }
}
