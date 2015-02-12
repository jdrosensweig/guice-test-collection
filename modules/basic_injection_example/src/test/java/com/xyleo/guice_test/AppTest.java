package com.xyleo.guice_test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest {
    private static Injector _injector;
    private AppInterface _app;
    private NumberGenerator _generator;

    @BeforeClass
    public static void initialize() throws Exception {
        _injector = Guice.createInjector(new AppTestModule());
    }

    @Before
    public void setUp() throws Exception {
        _injector = Guice.createInjector(new AppModule());
        _generator = new RandomNumberGenerator();

        _app = _injector.getInstance(AppInterface.class);
        _app.setNumberSource(_generator);
    }

    @Test
    public void testExecute() throws Exception {
        _app.execute();
    }
}