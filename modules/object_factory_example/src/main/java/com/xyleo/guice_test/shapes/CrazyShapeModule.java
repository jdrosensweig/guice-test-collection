package com.xyleo.guice_test.shapes;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;
import com.xyleo.guice_test.Main;
import com.xyleo.guice_test.ShapeMain;
import com.xyleo.guice_test.shapes.Shape.TYPES;

/**
 * Created by J.D. Rosensweig on 2/10/15.
 */
public class CrazyShapeModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Main.class).to(ShapeMain.class);

        MapBinder.newMapBinder(binder(), TYPES.class, Shape.class)
                .addBinding(TYPES.CIRCLE).to(Rectangle.class);
        MapBinder.newMapBinder(binder(), TYPES.class, Shape.class)
                .addBinding(TYPES.RECTANGLE).to(Triangle.class);
        MapBinder.newMapBinder(binder(), TYPES.class, Shape.class)
                .addBinding(TYPES.TRIANGLE).to(Circle.class);
    }
}
