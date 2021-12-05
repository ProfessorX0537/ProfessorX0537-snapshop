package gui;


import filters.*;
import image.PixelImage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

/**
 * Makes a panel and attaches all button to it that performer operations on the image
 */
public class FunctionsButtonPanel extends JPanel {
    /**
     * ImagePanel Variable will be assigned to current image panel
     */
    private static ImagePanel IP;
    /**
     * PixelImage variable so that filter operations can be performed
     */
    private static PixelImage img;
    private static final JButton[] buttonArray = new JButton[7];
    private final static String[] names = {"Edge Detect", "Edge Highlight", "Flip Horizontal", "Flip Vertical", "Grayscale", "Sharpen", "Soften"};

    /**
     * Constructs a panel with the 7 buttons assigns them and action listener.
     * Assigns them an action listener and sets there base enabled value to false.
     * Then adds them to the FunctionsButtonPanel
     */
    public FunctionsButtonPanel() {
        for (int i = 0; i < buttonArray.length; i++) {
            buttonArray[i] = new JButton(names[i]);
            int finalI = i;
            buttonArray[i].addActionListener(e -> FunctionsButtonActionListener(finalI));
            buttonArray[i].setEnabled(false);
            add(buttonArray[i]);
        }
    }

    /**
     * Takes and integer and then assigns that button the according action listener function
     * @param buttonNum represents appropriate cases for buttons.
     */
    private void FunctionsButtonActionListener(int buttonNum) {

        switch (buttonNum) {
            //Edge Detect
            case 0 -> {System.out.println(names[buttonNum]);
                new EdgeDetectFilter().filter(img);
                IP.imageUpdater(img);
            }
            //Edge Highlight
            case 1 -> {
                System.out.println(names[buttonNum]);
                new EdgeHighlightFilter().filter(img);
                IP.imageUpdater(img);
            }
            //Flip Horizontal
            case 2 -> {
                System.out.println(names[buttonNum]);
                new FlipHorizontalFilter().filter(img);
                IP.imageUpdater(img);
            }
            // Flip Vertical
            case 3 -> {
                System.out.println(names[buttonNum]);
                new FlipVerticalFilter().filter(img);
                IP.imageUpdater(img);
            }
            //Grayscale
            case 4 -> {
                System.out.println(names[buttonNum]);
                new GrayscaleFilter().filter(img);
                IP.imageUpdater(img);
            }
            //Sharpen
            case 5 -> {
                System.out.println(names[buttonNum]);
                new SharpenFilter().filter(img);
                IP.imageUpdater(img);
            }
            //Soften
            case 6 -> {
                System.out.println(names[buttonNum]);
                new SoftenFilter().filter(img);
                IP.imageUpdater(img);
            }
        }
    }

    /**
     * Takes a boolean value and assigns it to the enabled state of each button.
     * So that buttons may be disabled and enabled.
     * @param b boolean value
     */
    public void FunctionButtonEnabler(boolean b) {
        for (JButton button: buttonArray) {
            button.setEnabled(b);
        }
    }

    /**
     * Sets the variable img to a PixelImage of the image at the
     * given file.
     * @param image The File containing the image to be filtered
     * @throws IOException if the file isn't an image
     */
    public void setImg(File image) throws IOException {
        img = PixelImage.load(image);
    }

    /**
     * Sets the ImagePanel variable IP to the current ImagePanel
     * being used in the JFrame
     * @param i The ImagePanel being used by JFrame
     */
    public void setIP(ImagePanel i) {
        IP = i;
    }

}
