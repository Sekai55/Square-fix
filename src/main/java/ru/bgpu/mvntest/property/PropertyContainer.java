package ru.bgpu.mvntest.property;

import java.lang.reflect.InvocationTargetException;

public interface PropertyContainer extends FigureEditListener {
    void setValue() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException;
}
