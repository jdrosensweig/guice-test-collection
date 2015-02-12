package com.xyleo.guice_test;

/**
 * Created by J.D. Rosensweig on 2/10/15.
 */
public interface NumberGenerator {
    int getNumber() throws Exception;
    boolean hasNext();
}
