package ru.bgpu.mvntest.property;

import ru.bgpu.mvntest.Figure;

import javax.swing.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class IntPropertyContainer implements PropertyContainer {

    private JTextField input;
    private Field field;
    private Figure figure;

    public IntPropertyContainer(JTextField input, Field field, Figure figure) {
        this.input = input;
        this.field = field;
        this.figure = figure;
    }

    @Override
    public void setValue() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        figure.getClass().getMethod(
                "set" + field.getName().substring(0, 1).toUpperCase()
                        + field.getName().substring(1),
                int.class
        ).invoke(figure, Integer.parseInt(input.getText()));
    }

    @Override
    public void edit(Field field) {
        if(field.equals(this.field)) {
            try {
                input.setText(
                        figure.getClass().getMethod(
                                "get" + field.getName().substring(0, 1).toUpperCase()
                                        + field.getName().substring(1)
                        ).invoke(figure).toString()
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
