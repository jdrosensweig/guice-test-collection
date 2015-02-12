package com.xyleo.guice_test;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.xyleo.guice_test.color.Red;
import com.xyleo.guice_test.shapes.*;

import java.util.Map;

/**
 * Created by J.D. Rosensweig on 2/10/15.
 */
public class ShapeMain implements Main {
    Map<Shape.TYPES, AbstractShapeFactory> _map;


    @Inject
    public ShapeMain(Map<Shape.TYPES, AbstractShapeFactory> map) {
        _map = map;
    }

    @Override
    public void execute() {
        ShapeRequest[] requests = {
            new ShapeRequestImpl(Shape.TYPES.CIRCLE),
                new ShapeRequestImpl(Shape.TYPES.RECTANGLE),
                new ShapeRequestImpl(Shape.TYPES.TRIANGLE)};

        for (ShapeRequest request : requests) {
            Shape.TYPES type = request.getRequest();
            System.out.println("Creating object for " + type.toString() + " shape!");
            AbstractShapeFactory shapeFactory = _map.get(type);

            if (shapeFactory == null) {
                throw new RuntimeException("Shape factory is null!");
            }

            Shape shape = shapeFactory.getShape(type, new Red());

            if (shape != null) {
                System.out.println("Shape type = " + shape.name());
                System.out.println("Shape sides = " + shape.numberOfSides());
                System.out.println("");
            } else {
                System.out.println(type.toString() + " is an unknown type");
            }
        }
    }

    static Injector _injector;
    public static void main(String[] args) {
        _injector = Guice.createInjector(new ShapeModule());
        Main main = _injector.getInstance(Main.class);
        main.execute();
    }
}
