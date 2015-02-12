package com.xyleo.guice_test.logger;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.MembersInjector;

/**
 * Created by J.D. Rosensweig on 2/10/15.
 */
public class Slf4jMembersInjector<T>  implements MembersInjector<T> {
    private final Field _field;
    private final Logger _logger;

    Slf4jMembersInjector(Field field) {
        _field = field;
        _logger = LoggerFactory.getLogger(_field.getDeclaringClass());
        _field.setAccessible(true);
    }

    public void injectMembers(T arg) {
        try {
            _field.set(arg, _logger);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
