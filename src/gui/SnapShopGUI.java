// finish (and comment) me!

package gui;

import javax.swing.*;
import java.awt.*;

/**
 * 
 * @author Xavier Hines
 * @version 12/4/21
 */
public class SnapShopGUI extends JFrame {
    private static final FunctionsButtonPanel functionButtons = new FunctionsButtonPanel();
    private static final FileButtonPanel fileButtons = new FileButtonPanel();


    /**
     * 
     */
    public void start() {
        ImagePanel imagePanel = new ImagePanel(this);

        add(functionButtons, BorderLayout.NORTH);
        add(fileButtons, BorderLayout.SOUTH);
        add(imagePanel, BorderLayout.CENTER);
        fileButtons.setFunctionPanel(functionButtons);
        fileButtons.setIP(imagePanel);
        functionButtons.setIP(imagePanel);


        setVisible(true);
        setTitle("TCSS 305 - Assignment 3");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }
}