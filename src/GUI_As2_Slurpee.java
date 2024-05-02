import javax.swing.*;
import java.awt.*;

public class GUI_As2_Slurpee {
    private JPanel mainPanel;
    private JLabel slurpee;

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI_As2_Slurpee");
        frame.setContentPane(new GUI_As2_Slurpee().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        slurpee = new JLabel();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("F:\\IntelliJ_Java_D1B2\\CS30\\src\\slurpees.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
        slurpee.setIcon(imageIcon);
    }
}
