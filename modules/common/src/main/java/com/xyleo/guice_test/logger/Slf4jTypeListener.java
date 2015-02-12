package com.xyleo.guice_test.logger;

import java.lang.reflect.Field;

import org.slf4j.Logger;

import com.google.inject.TypeLiteral;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;

/**
 * Created by J.D. Rosensweig on 2/10/15.
 */
public class Slf4jTypeListener implements TypeListener {

    public <I> void hear(TypeLiteral<I> literal, TypeEncounter<I> encounter) {

        for (Field field : literal.getRawType().getDeclaredFields()) {
            if (isLoggerAndHasAnnotation(field)) {
                registerSlf4jInjector(encounter, field);
            }
        }
    }

    private <I> void registerSlf4jInjector(TypeEncounter<I> aTypeEncounter, Field field) {
        aTypeEncounter.register(new Slf4jMembersInjector<I>(field));
    }

    private boolean isLoggerAndHasAnnotation(Field field) {
        return field.getType() == Logger.class
                && field.isAnnotationPresent(InjectLogger.class);
    }
}
