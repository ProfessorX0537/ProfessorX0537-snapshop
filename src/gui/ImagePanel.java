package gui;

import image.PixelImage;

import javax.swing.*;
import java.awt.*;

/**
 * Creates new Panel to handle the image that the user selects.
 * Places it in a JLabel and resizes the frame accordingly.
 */
public class ImagePanel extends JPanel {
    /**
     * JFrame variable will be assigned to the JFrame in which
     * this panel is contained.
     */
    private static JFrame mainFrame;
    /**
     * JLabel variable to be accessed throughout the class.
     */
    private static JLabel LBL;

    /**
     * Takes the JFrame that ImagePanel is in, sets LBL to a new empty
     * JLabel and then adds it to the Panel with BorderLayout assigned to
     * center.
     * @param myGUI The JFrame that IMagePanel is contained in.
     */
    public ImagePanel(SnapShopGUI myGUI) {
        mainFrame = myGUI;
        LBL = new JLabel(new ImageIcon());
        add(LBL, BorderLayout.CENTER);
    }

    /**
     * Updates the ImageIcon in the JLabel with the image that was
     * selected by the user.
     * @param im The ImageIcon the was selected by the user
     */
    public void imageUpdater(ImageIcon im) {
        LBL.setIcon(new ImageIcon(String.valueOf(im)));
        reSize();
    }

    /**
     * Updates the image in the JLabel to be the modified PixelImage
     * passed from the FunctionsButtonPanel.
     * @param pi PixelImage passed in from the FunctionButtonsPanel actionListener
     */
    public void imageUpdater(PixelImage pi) {
        LBL.setIcon(new ImageIcon(pi));
        reSize();

    }

    /**
     * Is called to set the JLabel image to nothing.
     */
    public void imageClearer() {
        LBL.setIcon(new ImageIcon());
        reSize();
    }

    /**
     * Is called to resize the mainFrame when the image in
     * the JLabel is called. This is done so that the
     * image will properly fit the frame.
     */
    private void reSize() {
        mainFrame.revalidate();
        mainFrame.repaint();
        mainFrame.setMinimumSize(new Dimension(0,0));
        mainFrame.pack();
        mainFrame.setMinimumSize(mainFrame.getSize());

    }
}
