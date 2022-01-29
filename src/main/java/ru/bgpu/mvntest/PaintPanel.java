package ru.bgpu.mvntest;

import ru.bgpu.mvntest.property.PropertiesPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class PaintPanel extends JComponent implements MouseMotionListener, MouseListener {

    private ArrayList<Figure> figureList = new ArrayList();
    private Color backgroundColor = Color.WHITE;

    private Figure currentFigure = null;
    private int currentX = 0;
    private int currentY = 0;

    private PropertiesPanel propertiesPanel;

    PaintPanel(PropertiesPanel propertiesPanel) {
        this.propertiesPanel = propertiesPanel;
        setPreferredSize(new Dimension(600, 400));
        figureList.add(new SquareFigure());
        figureList.add(new SquareFigure());
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.setColor(backgroundColor);
        graphics.fillRect(0,0, getWidth(), getHeight());
        for(Figure figure: figureList) {
            figure.paint(graphics);
        }
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        if(currentFigure != null) {
            currentFigure.move(
                    mouseEvent.getX()-currentX,
                    mouseEvent.getY()-currentY
            );
        }
        currentX = mouseEvent.getX();
        currentY = mouseEvent.getY();
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        currentX = mouseEvent.getX();
        currentY = mouseEvent.getY();
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        selectCurrentFigure(mouseEvent);
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        selectCurrentFigure(mouseEvent);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        currentFigure = null;
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {}

    @Override
    public void mouseExited(MouseEvent mouseEvent) {}

    private void selectCurrentFigure(MouseEvent mouseEvent) {
        for (Figure figure: figureList) {
            if(figure.contains(mouseEvent.getX(), mouseEvent.getY())) {
                if(currentFigure != figure) {
                    currentFigure = figure;
                    propertiesPanel.setFigure(figure);
                }
                break;
            }
        }
    }
}
