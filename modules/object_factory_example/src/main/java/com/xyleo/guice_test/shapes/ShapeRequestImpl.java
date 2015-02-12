package com.xyleo.guice_test.shapes;

/**
 * Created by JD Rosensweig on 2/11/15.
 */
public class ShapeRequestImpl implements ShapeRequest {
    Shape.TYPES _type;

    public ShapeRequestImpl(Shape.TYPES type) {
        _type = type;
    }

    @Override
    public Shape.TYPES getRequest() {
        return _type;
    }
}
