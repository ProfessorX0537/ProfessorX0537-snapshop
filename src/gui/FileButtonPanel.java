package gui;

import javax.swing.*;

public class FileButtonPanel extends JPanel {
    static FunctionsButtonPanel functionPanel;
    static JButton[] buttonArray = new JButton[3];
    final static String[] Title = {"Open...", "Save As...", "Close Image"};


    public FileButtonPanel() {
        for (int i = 0; i < buttonArray.length; i++) {
            buttonArray[i] = new JButton(Title[i]);
            int finalI = i;
            buttonArray[i].addActionListener(e -> FileButtonActionListener(finalI));
            add(buttonArray[i]);
        }
        buttonArray[1].setEnabled(false);
        buttonArray[2].setEnabled(false);
    }

    private void FileButtonActionListener(int buttonNum) {
        switch(buttonNum) {
            case 0 -> {
                System.out.println(Title[buttonNum]);
                FileButtonEnabler(true);
                functionPanel.FunctionButtonEnabler(true);
            }
            case 1 -> System.out.println(Title[buttonNum]);
            case 2 -> {
                System.out.println(Title[buttonNum]);
                FileButtonEnabler(false);
                functionPanel.FunctionButtonEnabler(false);
            }
        }
    }

    public void FileButtonEnabler(boolean b) {
        buttonArray[1].setEnabled(b);
        buttonArray[2].setEnabled(b);
    }

    //TODO may have to remove
    public boolean isFileButtonEnabled() {
        return buttonArray[1].isEnabled() && buttonArray[2].isEnabled();
    }

    public void setFunctionPanel(FunctionsButtonPanel f) {
        functionPanel = f;
    }
}
