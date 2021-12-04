package gui;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class FileButtonPanel extends JPanel {
    private static FunctionsButtonPanel functionPanel;
    private static ImagePanel IP;
    private static ImageIcon image;
    static JButton[] buttonArray = new JButton[3];
    final static String[] Title = {"Open...", "Save As...", "Close Image"};
    private final JFileChooser chooser = new JFileChooser();
    private final static FileChooserClass FCC = new FileChooserClass();


    public FileButtonPanel() {
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

    public void FileButtonEnabler(boolean b) {
        buttonArray[1].setEnabled(b);
        buttonArray[2].setEnabled(b);
    }

    public void setFunctionPanel(FunctionsButtonPanel f) {
        functionPanel = f;
    }

    public void setIP(ImagePanel i) {
        IP = i;
    }

    public ImageIcon getImage() {
        return image;
    }
}
