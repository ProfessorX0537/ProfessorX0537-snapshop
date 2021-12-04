// finish (and comment) me!

package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * 
 * @author Xavier Hines
 * @version 0.1
 */
public class SnapShopGUI extends JFrame {
    FunctionsButtonPanel functionButtons = new FunctionsButtonPanel();
    FileButtonPanel fileButtons = new FileButtonPanel();
    ImagePanel imagePanel = new ImagePanel();

    /**
     * 
     */
    public void start() {
        add(functionButtons, BorderLayout.NORTH);
        add(fileButtons, BorderLayout.SOUTH);
        add(imagePanel, BorderLayout.CENTER);
        fileButtons.setFunctionPanel(functionButtons);
        fileButtons.setIP(imagePanel);


        setVisible(true);
        setTitle("TCSS 305 - Assignment 3");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }
}