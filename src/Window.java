import algorithms.Sort;
import algorithms.SortState;

import javax.swing.*;
import java.awt.event.*;

public class Window {
    private JPanel panel1;
    private JButton previousButton;
    private JButton nextButton;
    private JComboBox algorithmSelector;
    private JLabel arrayDisplay;
    private JSlider slider1;

    private SortState sortState = Sort.bubble(Sort.getTestArray(20));

    public Window() {
        updateProgress();
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortState.stepBack();
                updateProgress();
            }
        });
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortState.stepForward();
                updateProgress();
            }
        });
        algorithmSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortState = Sort.bubble(Sort.getTestArray(100));
                updateProgress();
            }
        });


        slider1.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                sortState.stepTo(slider1.getValue());
                displayArray();
                super.mouseDragged(e);
            }
        });
    }
    private void updateProgress(){

        slider1.setMaximum(sortState.getSteps());
        slider1.setValue(sortState.getCurrentIndex());
        displayArray();
    }
    private void displayArray(){
        String toDisplay = "";
        for(int i : sortState.getArray()){
            toDisplay = toDisplay + i + " | ";
        }
        arrayDisplay.setText(toDisplay);
    }
    public JPanel getPanel() {
        return panel1;
    }
}
