package com.xyleo.guice_test.shapes;

import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.assistedinject.FactoryModuleBuilder;

import com.google.inject.internal.UniqueAnnotations;
import com.google.inject.multibindings.MapBinder;

import com.xyleo.guice_test.Main;
import com.xyleo.guice_test.ShapeMain;
import com.xyleo.guice_test.shapes.Shape.TYPES;

/**
 * Created by J.D. Rosensweig on 2/10/15.
 */
public class ShapeModule extends AbstractModule {
    MapBinder<TYPES, AbstractShapeFactory> _shapeMapBinder;

    @Override
    protected void configure() {
        bind(Main.class).to(ShapeMain.class);
        createShapeFactoryMapBinding();
    }

    private void createShapeFactoryMapBinding() {
        _shapeMapBinder = MapBinder.newMapBinder(
                binder(), TYPES.class, AbstractShapeFactory.class);

        mapShapeEnumToConcreteClass(TYPES.CIRCLE, Circle.class);
        mapShapeEnumToConcreteClass(TYPES.TRIANGLE, Triangle.class);
        mapShapeEnumToConcreteClass(TYPES.RECTANGLE, Rectangle.class);
    }

    private void mapShapeEnumToConcreteClass(Shape.TYPES type, Class concrete) {
        Key key = Key.get(AbstractShapeFactory.class, UniqueAnnotations.create());
        install(new FactoryModuleBuilder().implement(Shape.class, concrete).build(key));
        _shapeMapBinder.addBinding(type).to(key);
    }
}
