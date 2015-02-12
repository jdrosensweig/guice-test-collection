package com.xyleo.guice_test.shapes;

/**
 * Created by J.D. Rosensweig on 2/10/15.
 */
public interface Shape<E> {
    enum TYPES {
        CIRCLE,
        RECTANGLE,
        TRIANGLE,
        UNKNOWN;

        @Override
        public String toString() {
            String result = "";

            switch(this) {
                case CIRCLE:
                    result = "CIRCLE";
                    break;
                case TRIANGLE:
                    result = "TRIANGLE";
                    break;
                case RECTANGLE:
                    result = "RECTANGLE";
                    break;
                default:
                    result = "UNKNOWN";
                    break;
            }
            return result;
        }
    }

    public E numberOfSides();
    public String name();
}
