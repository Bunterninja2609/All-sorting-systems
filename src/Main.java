import algorithms.Sort;
import algorithms.SortState;

import javax.swing.*;
import java.awt.*;

public class Main {
    static Window window;
    static JFrame frame;

    public static void main(String[] args) {
        window = new Window();
        frame = new JFrame();
        frame.setContentPane(window.getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 300));frame.pack();frame.setVisible(true);

        int[] testArray = Sort.getTestArray(10);
        SortState state = Sort.bubble(testArray);
        state.printSorting();
        Sort.printArray(testArray);
    }
}