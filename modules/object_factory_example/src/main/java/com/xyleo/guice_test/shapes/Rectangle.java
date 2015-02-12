package com.xyleo.guice_test.shapes;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.xyleo.guice_test.color.Color;

/**
 * Created by J.D. Rosensweig on 2/10/15.
 */
public class Rectangle implements Shape<Integer> {
    Color _color;

    @Inject
    public Rectangle(@Assisted Color _color) {
        this._color = _color;
    }

    @Override
    public Integer numberOfSides() {
        return 4;
    }

    @Override
    public String name() {
        return _color.getColor() + " Rectangle";
    }
}
