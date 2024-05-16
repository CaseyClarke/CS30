import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class GUI_As2_Slurpee {
    private JPanel mainPanel;
    private JLabel slurpee;
    private JComboBox sizeBox;
    private JButton purchaseButton;
    private JTextArea output;
    private JSlider slider1;
    private JRadioButton Small;
    private JRadioButton largeRadioButton;
    private JRadioButton EXTRASTUPIDLYFUCKINGLARGERadioButton;
    private JRadioButton mediumRadioButton;

    public GUI_As2_Slurpee() {
        String[] flavors = {"Cream soda", "Crush", "Orange", "Mystery"};

        purchaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Small.isSelected()) {
                    output.append("Small " + flavors[slider1.getValue()] + " " + 1.25 +  "$ \n");
                } else if(mediumRadioButton.isSelected()) {
                    output.append("Medium " + flavors[slider1.getValue()] + " " + 1.5 +  "$ \n");
                } else if(largeRadioButton.isSelected()) {
                    output.append("Large " + flavors[slider1.getValue()] + " " + 1.75 +  "$ \n");
                } else {
                    output.append("EXTRA SUPER DUPER FUCK YOU LARGE " + flavors[slider1.getValue()] + " " + 2.00 +  "$ \n");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI_As2_Slurpee");
        frame.setContentPane(new GUI_As2_Slurpee().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        slurpee = new JLabel();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("src/slurpee.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
        slurpee.setIcon(imageIcon);
    }
}
