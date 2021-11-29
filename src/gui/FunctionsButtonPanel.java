package gui;

import filters.EdgeDetectFilter;

import javax.swing.*;

public class FunctionsButtonPanel extends JPanel {
    static JButton[] buttonArray = new JButton[7];
    final static String[] names = {"Edge Detect", "Edge Highlight", "Flip Horizontal", "Flip Vertical", "Grayscale", "Sharpen", "Soften"};

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
                //new EdgeDetectFilter().filter();
            }
            //Edge Highlight
            case 1 -> System.out.println(names[buttonNum]);
            //Flip Horizontal
            case 2 -> System.out.println(names[buttonNum]);
            // Flip Vertical
            case 3 -> System.out.println(names[buttonNum]);
            //Grayscale
            case 4 -> System.out.println(names[buttonNum]);
            //Sharpen
            case 5 -> System.out.println(names[buttonNum]);
            //Soften
            case 6 -> System.out.println(names[buttonNum]);
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
}
