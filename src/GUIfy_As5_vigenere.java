import javax.swing.*;

public class GUIfy_As5_vigenere {
    private JPanel mainPanel;
    private JTextPane square;
    private JTextPane encode;
    private JTextPane decodeTextPane;


    public static void main(String[] args) {
        JFrame frame = new JFrame("GUIfy_As5_vigenere");
        frame.setContentPane(new GUIfy_As5_vigenere().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public GUIfy_As5_vigenere() {
        square.setText("asdasd");
    }
}
