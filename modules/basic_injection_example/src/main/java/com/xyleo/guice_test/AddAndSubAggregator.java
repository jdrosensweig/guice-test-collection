package com.xyleo.guice_test;

import com.xyleo.guice_test.logger.InjectLogger;
import org.slf4j.Logger;

/**
 * Created by J.D. Rosensweig on 2/10/15.
 */
public class AddAndSubAggregator implements NumberAggregator {
    @InjectLogger
    Logger _logger;
    boolean shouldAdd = true;
    int _runningTotal;

    @Override
    public void insert(int number) {
        if (shouldAdd()) {
            _logger.debug("Adding {} to {}", number, _runningTotal);
            _runningTotal += number;
            setSubMode();
        } else {
            _logger.debug("Subtracting {} from {}", number, _runningTotal);
            _runningTotal -= number;
            setAddMode();
        }
    }

    public boolean shouldAdd() {
        return shouldAdd;
    }

    public void setAddMode() {
        shouldAdd = true;
    }

    public void setSubMode() {
        shouldAdd = false;
    }

    @Override
    public int getAggregation() {
        return _runningTotal;
    }
}
