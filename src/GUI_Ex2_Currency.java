import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Ex2_Currency {
    private JPanel mainPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox comboBox1;
    private JSlider slider1;
    private JButton convertButton;
    private JLabel name;

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI_Ex2_Currency");
        frame.setContentPane(new GUI_Ex2_Currency().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public GUI_Ex2_Currency() {

        String[] currencies = {"CAD", "USD", "YEN", "Euro"};
        Double[] rates = {1.00, 0.73, 114.53, 0.68};
        comboBox1.setModel(new javax.swing.DefaultComboBoxModel(currencies));
        name.setText(currencies[0]);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double rate = rates[comboBox1.getSelectedIndex()];
                double fee = slider1.getValue() * 0.01;
                double cad = Double.parseDouble( textField1.getText());
                textField2.setText("" + cad * rate * (1 - fee));
            }
        });

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name.setText(currencies[comboBox1.getSelectedIndex()]);
            }
        });
    }
}
