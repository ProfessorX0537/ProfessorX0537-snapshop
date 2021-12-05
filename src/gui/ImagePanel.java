package gui;

import image.PixelImage;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    private static JFrame mainFrame;
    private static JLabel LBL;

    public ImagePanel(SnapShopGUI myGUI) {
        mainFrame = myGUI;
        LBL = new JLabel(new ImageIcon());
        add(LBL, BorderLayout.CENTER);
    }

    public void imageUpdater(ImageIcon im) {
        //TODO should update image doesn't idk why
        LBL.setIcon(new ImageIcon(String.valueOf(im)));
        reSize();
    }

    public void imageUpdater(PixelImage pi) {
        LBL.setIcon(new ImageIcon(pi));
        reSize();

    }

    public void imageClearer() {
        LBL.setIcon(new ImageIcon());
        reSize();
    }

    private void reSize() {
        mainFrame.revalidate();
        mainFrame.repaint();
        mainFrame.setMinimumSize(new Dimension(0,0));
        mainFrame.pack();
        mainFrame.setMinimumSize(mainFrame.getSize());

    }
}
