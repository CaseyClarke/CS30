import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class GUI_As2_Slurpee {
    private JPanel mainPanel;
    private JLabel slurpee;
    private JComboBox flavorBox;
    private JComboBox sizeBox;
    private JButton purchaseButton;
    private JTextArea output;

    public GUI_As2_Slurpee() {
        HashMap<String, Double> sizes = new HashMap<String, Double>();
        String[] flavors = {"Cream soda", "Crush", "Orange", "Mystery"};
        {
            sizes.put("Small", 1.25);
            sizes.put("Medium", 1.50);
            sizes.put("Large", 1.75);
            sizes.put("Mega Super Duper Large", 2.00);
        }

        flavorBox.setModel(new javax.swing.DefaultComboBoxModel(flavors));
        sizeBox.setModel(new javax.swing.DefaultComboBoxModel(sizes.keySet().toArray(new String[0])));

        purchaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.append(sizeBox.getSelectedItem() + " " + flavorBox.getSelectedItem() + " " + sizes.get(sizeBox.getSelectedItem())  +  "$ \n");
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
