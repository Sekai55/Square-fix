package ru.bgpu.mvntest;

import ru.bgpu.mvntest.property.FigureEditListener;

import java.awt.*;
import java.util.ArrayList;

public abstract class Figure {

    ArrayList<FigureEditListener> figureEditListeners = new ArrayList<>();

    abstract void paint(Graphics graphics);
    abstract void move(int dx,int dy);
    abstract boolean contains(int x, int y);

    public void addFigureEditListener(FigureEditListener listener) {
        figureEditListeners.add(listener);
    }

    public void removeFigureEditListener(FigureEditListener listener) {
        figureEditListeners.remove(listener);
    }
}
