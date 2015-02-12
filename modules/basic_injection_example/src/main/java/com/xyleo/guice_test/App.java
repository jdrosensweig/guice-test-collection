package com.xyleo.guice_test;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.intuit.data.link.common.impl.LogConfigTweaker;
import com.xyleo.guice_test.logger.InjectLogger;
import org.slf4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

/**
 * Hello world!
 */
public class App implements AppInterface {
    @InjectLogger
    Logger _logger;
    NumberAggregator _agg;
    NumberGenerator _gen;

    @Inject
    public App(@AddAndSubAgg NumberAggregator _agg) {
        this._agg = _agg;
    }

    public void execute() {
        _logger.info("App is now executing");
        try {
            while (_gen.hasNext()) {
                _agg.insert(_gen.getNumber());
            }

            System.out.println("Aggregation Result = " + _agg.getAggregation());
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void setNumberSource(NumberGenerator generator) {
        _gen = generator;
    }

    static Injector _injector;

    public static void main(String[] args) {
        try {
            LogConfigTweaker tweaker = new LogConfigTweaker();
            tweaker.setLogName("GuiceTest");

            _injector = Guice.createInjector(new AppModule());

            AppInterface app = setUpApp();
            app.execute();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    private static AppInterface setUpApp() throws FileNotFoundException {
        File numbersFile = findFileInClassPath();
        NumberGenerator generator =
                new FiledBasedNumberGenerator().setNumbersFile(numbersFile);

        AppInterface app = _injector.getInstance(AppInterface.class);
        app.setNumberSource(generator);
        return app;
    }

    private static File findFileInClassPath() {
        ClassLoader loader = App.class.getClassLoader();
        URL url = loader.getResource("numbers.txt");
        return new File(url.getFile());
    }
}
