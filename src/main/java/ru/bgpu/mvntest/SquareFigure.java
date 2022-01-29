package ru.bgpu.mvntest;

import java.awt.*;

public class SquareFigure extends Figure {

    private static Color color = Color.BLUE;
    private int x = 0,y = 0;
    private int width = 100;
    private int height = 100;

    public static void filling(){
        int redcol=(int)(Math.random()*255);
        int greencol=(int)(Math.random()*255);
        int bluecol=(int)(Math.random()*255);
        color = new Color(redcol,greencol,bluecol);
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillRect(x,y,width,height);
    }

    @Override
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
        figureEditListeners.forEach(listener -> {
            try {
                listener.edit(getClass().getDeclaredField("x"));
                listener.edit(getClass().getDeclaredField("y"));
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public boolean contains(int x, int y) {
        return x > this.x && x < this.x+width &&
                y > this.y && y < this.y+height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
