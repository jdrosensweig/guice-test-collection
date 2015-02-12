package com.xyleo.guice_test;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;
import com.xyleo.guice_test.logger.Slf4jTypeListener;

/**
 * Created by J.D. Rosensweig on 2/10/15.
 */
public class AppModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(NumberGenerator.class).to(FiledBasedNumberGenerator.class);

        bind(NumberAggregator.class).annotatedWith(AdditiveAgg.class).to(AdditiveAggregator.class);
        bind(NumberAggregator.class).annotatedWith(AddAndSubAgg.class).to(AddAndSubAggregator.class);

        bind(NumberAggregator.class).to(AdditiveAggregator.class);
        bind(AppInterface.class).to(App.class);

        bindListener(Matchers.any(), new Slf4jTypeListener());
    }
}
