package gui;

import javax.swing.*;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

/**
 * Class containing methods for JFileChooser to select files and one to save files
 */
public class FileChooserClass {

    /**
     * Establishes a JFileChooser that can only select images and opens to sample
     * images' directory.
     * @param chooser JFileChooser passed in
     * @return File with selected image
     */
    public File selectImage(JFileChooser chooser) {
        File imageSelected;
        //sets the file chooser to access only files that are in this path
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setFileFilter(new FileNameExtensionFilter("Image files", "gif", "jpg", "png")); //specifies which files can be selected
        chooser.setCurrentDirectory(new File("X:\\Programming Everything\\Java Projects\\prga#03-netid-snapshop\\sample_images"));
        int returned = chooser.showOpenDialog(null); //select file to open and returns zero if file selected one if cancelled/closed

        if(returned == JFileChooser.APPROVE_OPTION) {
            //sets new file path to the selected files path
            imageSelected = new File(chooser.getSelectedFile().getAbsolutePath());
            System.out.println(imageSelected); //TODO testing
            return imageSelected;
        } else {
            return null;
        }
    }

    public File saveImage(JFileChooser chooser) {
        File imageToSave;

        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setFileFilter(new FileNameExtensionFilter("Image files", "gif", "jpg", "png")); //specifies which files can be selected
        chooser.setCurrentDirectory(new File("X:\\Programming Everything\\Java Projects\\prga#03-netid-snapshop\\sample_images"));
        int returned =  chooser.showSaveDialog(null);

        if(returned == JFileChooser.APPROVE_OPTION) {
            imageToSave = new File(chooser.getSelectedFile().getAbsolutePath());
            System.out.println(imageToSave); //TODO Testing
            return imageToSave;
        } else {
            return null;
        }
    }
}

