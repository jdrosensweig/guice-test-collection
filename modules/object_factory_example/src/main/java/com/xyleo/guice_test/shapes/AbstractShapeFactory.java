package com.xyleo.guice_test.shapes;

import com.xyleo.guice_test.color.Color;

/**
 * Created by J.D. Rosensweig on 2/10/15.
 */
public interface AbstractShapeFactory {
    public Shape getShape(Shape.TYPES type, Color color);
}
