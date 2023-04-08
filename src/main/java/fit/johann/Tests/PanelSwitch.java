package fit.johann.Tests;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelSwitch {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Switch Panel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create two panels
        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("This is Panel 1"));

        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("This is Panel 2"));

        // Add a button to switch panels
        JButton button = new JButton("Switch Panels");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Switch to the other panel
                Container contentPane = frame.getContentPane();
                if (contentPane.getComponent(0) == panel1) {
                    contentPane.remove(panel1);
                    contentPane.add(panel2);
                } else {
                    contentPane.remove(panel2);
                    contentPane.add(panel1);
                }
                contentPane.validate();
            }
        });

        // Add the first panel and the button to the frame
        frame.getContentPane().add(panel1);
        frame.getContentPane().add(button, BorderLayout.SOUTH);

        // Set the frame size and show it
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
