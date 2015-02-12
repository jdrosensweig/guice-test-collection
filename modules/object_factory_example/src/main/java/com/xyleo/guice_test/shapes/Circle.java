package com.xyleo.guice_test.shapes;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.xyleo.guice_test.color.Color;

/**
 * Created by J.D. Rosensweig on 2/10/15.
 */
public class Circle implements Shape<Float> {
    Color _color;

    @Inject
    public Circle(@Assisted Color _color) {
        this._color = _color;
    }

    @Override
    public Float numberOfSides() {
        return new Float(1.0);
    }

    @Override
    public String name() {
        return _color.getColor() + " Circle";
    }
}
