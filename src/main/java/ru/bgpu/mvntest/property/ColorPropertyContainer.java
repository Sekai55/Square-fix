package ru.bgpu.mvntest.property;

import ru.bgpu.mvntest.Figure;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ColorPropertyContainer implements PropertyContainer {

    private JColorChooser input;
    private Field field;
    private Figure figure;

    public ColorPropertyContainer(JColorChooser input, Field field, Figure figure) {
        this.input = input;
        this.field = field;
        this.figure = figure;
    }

    @Override
    public void edit(Field field) {}

    @Override
    public void setValue() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        figure.getClass().getMethod(
                "set" + field.getName().substring(0, 1).toUpperCase()
                        + field.getName().substring(1),
                Color.class
        ).invoke(figure, input.getColor());
    }
}
