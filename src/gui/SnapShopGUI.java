// finish (and comment) me!

package gui;

import javax.swing.*;
import java.awt.*;

/**
 * The JFrame that contains all the panels and the Frame that the user will
 * be presented with to interact.
 * @author Xavier Hines
 * @version 12/4/21
 */
public class SnapShopGUI extends JFrame {
    /**
     * A new FunctionsButtonPanel object to be displayed in SnapShopGUI frame.
     */
    private static final FunctionsButtonPanel functionButtons = new FunctionsButtonPanel();
    /**
     * A new FileButtonPanel object to be displayed in SnapSopGUI frame.
     */
    private static final FileButtonPanel fileButtons = new FileButtonPanel();


    /**
     * When this method is called it creates a frame with FunctionsButtonPanel,
     * FileButtonPanel, and ImagePanel objects initialized and added to it.
     * Assigning the specific layout management using BorderLayout. It also
     * establishes the frames title, default close operation, and setting it visible.
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