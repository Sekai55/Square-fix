package ru.bgpu.mvntest;
/**
 * @author  Maxim
 * @version 1.0
 * @since   2022-01-29
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.bgpu.mvntest.property.PropertiesPanel;

import javax.swing.*;
import java.awt.*;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Start program");
        JFrame frame = new JFrame("Vector Pain 0.1 alpha");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PropertiesPanel propertiesPanel = new PropertiesPanel(frame);
        PaintPanel paintPanel = new PaintPanel(propertiesPanel);
        JPanel center = new JPanel(new BorderLayout());
        center.add(paintPanel, BorderLayout.CENTER);
        center.add(propertiesPanel,BorderLayout.EAST);
        frame.setContentPane(center);
        frame.pack();
        frame.setVisible(true);
    }
}
