package com.xyleo.guice_test.shapes;

import com.xyleo.guice_test.color.Color;
import com.xyleo.guice_test.shapes.Shape.TYPES;

/**
 * Created by J.D. Rosensweig on 2/10/15.
 */
public class ShapeFactory implements AbstractShapeFactory {
    @Override
    public Shape getShape(TYPES type, Color color) {
        switch (type) {
            case TRIANGLE:
                return new Triangle(color);
            case RECTANGLE:
                return new Rectangle(color);
            case CIRCLE:
                return new Circle(color);
            default:
                return new Triangle(color);
        }
    }
}
