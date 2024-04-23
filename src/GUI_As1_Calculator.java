import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_As1_Calculator {
    private JPanel mainPanel;
    private JTextField num1;
    private JTextField num2;
    private JTextField result;
    private JButton clearButton;
    private JButton ADDButton;
    private JButton MODButton;
    private JButton SUBTRACTButton;
    private JButton MULTIPLYButton;
    private JButton DIVIDEButton;
    private JButton negativeButton;
    private JTextArea pastCalcs;
    private JButton saveButton;
    private JButton loadButton;

    private double saved = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI_As1_Calculator");
        frame.setContentPane(new GUI_As1_Calculator().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public GUI_As1_Calculator() {
        num1.setText("0.0");
        num2.setText("0.0");

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1.setText("");
                num2.setText("");
                result.setText("");
                pastCalcs.setText("");
            }
        });
        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result.setText( Double.toString(Double.parseDouble(num1.getText()) + Double.parseDouble(num2.getText()) ));

                pastCalcs.append(num1.getText() + " + " + num2.getText() + " = " + result.getText() + '\n');
            }
        });
        MODButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(num2.getText().equals("0") || num2.getText().equals("")) {
                    result.setText("DIVIDE BY ZERO ERROR");
                } else {
                    result.setText( Double.toString(Double.parseDouble(num1.getText()) % Double.parseDouble(num2.getText()) ));
                    pastCalcs.append(num1.getText() + " % " + num2.getText() + " = " + result.getText() + '\n');
                }
            }
        });
        SUBTRACTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result.setText( Double.toString(Double.parseDouble(num1.getText()) - Double.parseDouble(num2.getText()) ));
                pastCalcs.append(num1.getText() + " - " + num2.getText() + " = " + result.getText() + '\n');
            }
        });
        MULTIPLYButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result.setText( Double.toString(Double.parseDouble(num1.getText()) * Double.parseDouble(num2.getText()) ));
                pastCalcs.append(num1.getText() + " * " + num2.getText() + " = " + result.getText() + '\n');
            }
        });
        DIVIDEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(num2.getText().equals("0") || num2.getText().equals("")) {
                    result.setText("DIVIDE BY ZERO ERROR");
                } else {
                    result.setText( Double.toString(Double.parseDouble(num1.getText()) / Double.parseDouble(num2.getText()) ));
                    pastCalcs.append(num1.getText() + " / " + num2.getText() + " = " + result.getText() + '\n');
                }

            }
        });
        negativeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1.setText("" + Double.parseDouble(num1.getText()) * -1);
                pastCalcs.append("Flipped first number to " + num1.getText() + '\n');
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saved = Double.parseDouble(result.getText());
                pastCalcs.append("Saved " + saved + " to memory" + '\n');
            }
        });
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1.setText("" + saved);
                pastCalcs.append("Loaded " + saved + " to first number" + '\n');
            }
        });
    }
}
