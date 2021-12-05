package gui;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

/**
 * Class that contains everything to create a panel holding all the Filing buttons
 */
public class FileButtonPanel extends JPanel {
    /**
     * FunctionsButtonPanel to be used in this class
     */
    private static FunctionsButtonPanel functionPanel;
    /**
     * ImagePanel instance to be used in this class
     */
    private static ImagePanel IP;
    /**
     * Static variable for and ImageIcon
     */
    private static ImageIcon image;
    /**
     * Array of buttons to be added to panel
     */
    static JButton[] buttonArray = new JButton[3];
    /**
     * String array containing names of buttons
     */
    final static String[] Title = {"Open...", "Save As...", "Close Image"};
    /**
     * File chooser variable
     */
    private final JFileChooser chooser = new JFileChooser();
    /**
     * FileChooserClass instance to assist in selecting files through file chooser dialog
     */
    private final static FileChooserClass FCC = new FileChooserClass();


    /**
     * FileButtonPanel constructor that initializes buttons adds them to the panel and assigns them
     * an actionListener
     */
    public FileButtonPanel() {
        //Loops through each button in array to initialize it assigns it an action listener
        for (int i = 0; i < buttonArray.length; i++) {
            buttonArray[i] = new JButton(Title[i]);
            int finalI = i;
            buttonArray[i].addActionListener(e -> {
                try {
                    FileButtonActionListener(finalI);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
            add(buttonArray[i]);
        }
        buttonArray[1].setEnabled(false);
        buttonArray[2].setEnabled(false);
    }

    /**
     * each case is and action listener associated with a button in the position on
     * the buttonArray.
     * @param buttonNum the position of the button in the array
     * @throws IOException if the file is not found
     */
    private void FileButtonActionListener(int buttonNum) throws IOException {
        switch(buttonNum) {
            //Open...
            case 0 -> {
                System.out.println(Title[buttonNum]); //TODO testing
                FileButtonEnabler(true);
                functionPanel.FunctionButtonEnabler(true);

                File imageSelected = FCC.selectImage(chooser); //returns file selected by user
                System.out.println(imageSelected); //TODO testing

                image = new ImageIcon(String.valueOf(imageSelected));
                System.out.println(image);
                functionPanel.setImg(imageSelected);
                IP.imageUpdater(image);
            }
            //Save as...
            case 1 -> {
                System.out.println(Title[buttonNum]); //TODO testing

                File imageToSave = FCC.saveImage(chooser); //saves file selected by user
                System.out.println(imageToSave); //TODO testing
            }
            //Close Image
            case 2 -> {
                System.out.println(Title[buttonNum]); //TODO testing
                FileButtonEnabler(false);
                functionPanel.FunctionButtonEnabler(false);
                IP.imageClearer();
            }
        }
    }

    /**
     * Disables or enables buttons
     * @param b boolean passed to change enable or disable
     */
    public void FileButtonEnabler(boolean b) {
        buttonArray[1].setEnabled(b);
        buttonArray[2].setEnabled(b);
    }

    /**
     * sets functionPanel the FunctionButtonPanel used in the Frame
     * @param f FunctionsButtonPanel
     */
    public void setFunctionPanel(FunctionsButtonPanel f) {
        functionPanel = f;
    }

    /**
     * sets IP to the ImagePanel used in the Frame
     * @param i ImagePanel
     */
    public void setIP(ImagePanel i) {
        IP = i;
    }

    /**
     * returns image that is selected by the JFileChooser
     * @return ImageIcon that was selected by user
     */
    public ImageIcon getImage() {
        return image;
    }
}
