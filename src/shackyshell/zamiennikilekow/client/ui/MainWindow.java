package shackyshell.zamiennikilekow.client.ui;

import javax.swing.*;

/**
 * Created by Dawid on 26.02.2017.
 */
public class MainWindow{
    private JTextField textField1;
    private JButton button1;
    private JPanel panel;


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new MainWindow().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
