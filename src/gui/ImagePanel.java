package gui;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    private static JLabel LBL;

    public ImagePanel() {
        LBL = new JLabel(new ImageIcon());
        add(LBL, BorderLayout.CENTER);
    }

    public void imageUpdater(ImageIcon im) {
        //TODO should update image doesn't idk why
        LBL.setIcon(new ImageIcon(String.valueOf(im)));
    }

    public void imageClearer() {
        LBL.setIcon(new ImageIcon());
    }
}
