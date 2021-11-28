// finish (and comment) me!

package gui;

import javax.swing.*;
import java.awt.*;

/**
 * 
 * @author Xavier Hines
 * @version 0.1
 */
public class SnapShopGUI extends JFrame {
    FunctionsButtonPanel functionButtons = new FunctionsButtonPanel();
    FileButtonPanel fileButtons = new FileButtonPanel();

    /**
     * 
     */
    public void start() {
        add(functionButtons, BorderLayout.NORTH);
        add(fileButtons, BorderLayout.SOUTH);
        fileButtons.setFunctionPanel(functionButtons);

        setVisible(true);
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //javax.swing.JOptionPane.showMessageDialog(null, "SnapShop placeholder");
    }
}