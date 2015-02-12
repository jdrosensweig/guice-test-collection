package com.xyleo.guice_test;

import com.google.inject.AbstractModule;

/**
 * Created by J.D. Rosensweig on 2/10/15.
 */
public class AppTestModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(NumberGenerator.class).to(RandomNumberGenerator.class);
        bind(NumberAggregator.class).annotatedWith(AdditiveAgg.class).to(AdditiveAggregator.class);
        bind(NumberAggregator.class).annotatedWith(AddAndSubAgg.class).to(AddAndSubAggregator.class);
        bind(AppInterface.class).to(App.class);
    }
}
