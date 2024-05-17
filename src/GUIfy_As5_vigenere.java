import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.*;

public class GUIfy_As5_vigenere {
    private JPanel mainPanel;
    private JPanel buttons;
    private JPanel cards;
    private JButton encodeButton;
    private JButton displaySquareButton;
    private JButton decodeButton;
    private JPanel encode;
    private JPanel display;
    private JPanel decode;
    private JTextField toDecode;
    private JTextField key;
    private JTextField output;
    private JTextArea square;
    private JTextArea vText;
    private JTextField toEncode;
    private JTextField encodeKey;
    private JTextField encodeOutput;

    private static final char[] alphabet = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
    private final char[][] vigenere;
    public static void main(String[] args) {
        JFrame frame = new JFrame("GUIfy_As5_vigenere");
        frame.setContentPane(new GUIfy_As5_vigenere().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public static String decode(char[][] board, String key, String input) {
        String ans = "";
        key = key.repeat(input.length() / key.length() + 1);

        for (int k = 0; k < input.length(); k++) {
            int row = 0;
            for (int i = 0; i < board.length; i++) {
                if (board[i][0] == key.charAt(k)) {
                    row = i;
                }
            }
            int col = linearSearch(board[row], input.charAt(k));
            ans += board[0][col];
        }
        return ans;
    }

    public static String encode(char[][] board, String key, String input) {
        String ans = "";
        key = key.repeat(input.length() / key.length() + 1);
        for(int i = 0; i < input.length(); i++) {
            ans += board[linearSearch(alphabet, key.charAt(i))][linearSearch(alphabet, input.charAt(i))];
        }
        return ans;
    }

    private static char[][] createVSquare(char[] alphabet) {
        char[][] square = new char[alphabet.length][alphabet.length];
        int a;
        for (int row = 0; row < alphabet.length; row++) {
            for (int col = 0; col < alphabet.length; col++) {
                a = row + col;
                if (a >= alphabet.length) {
                    a = a - alphabet.length;
                }
                square[row][col] = alphabet[a];
            }
        }
        return square;

    }// createVSquare

    public static String printSquare(char[][] sudokuGrid) {
        String output = "";
        for (int row = 0; row < sudokuGrid.length; row++) {
            if (row < 10) {
                output += row + "   ";
            } else {
                output += row + " ";
            }
            for (int col = 0; col < sudokuGrid[row].length; col++) {
                if (sudokuGrid[row][col] < 10) {
                    output += sudokuGrid[row][col] + "   ";
                } else {
                    output += sudokuGrid[row][col] + " ";
                }
            }
            output += "\n";
        }
        return output.substring(0, output.length() -  2);
    }// printSudoku

    public static int linearSearch(char[] arr, char searchTerm) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == searchTerm) {
                return i;
            }
        }
        return -1;
    }

    public GUIfy_As5_vigenere() {
        vText.setText("The Vigenère cipher is a sophisticated method of\n" +
                "encrypting text that employs a keyword to shift each\n" +
                "letter of the plaintext. Unlike the simpler Caesar cipher,\n" +
                "which shifts all letters by the same amount, the Vigenère\n" +
                "cipher uses different shifts for each letter based on the\n" +
                "keyword. This makes it a polyalphabetic substitution\n" +
                "cipher, which is significantly more secure.\n" +
                "\n" +
                "To encrypt a message, first, choose a keyword. Write the\n" +
                "keyword repeatedly above the plaintext until each letter\n" +
                "of the plaintext has a corresponding keyword letter. Each\n" +
                "letter in the keyword is then used to determine the shift\n" +
                "value for the corresponding letter in the plaintext. The\n" +
                "shift value is based on the position of the letter in the\n" +
                "alphabet (A=0, B=1, ..., Z=25).\n" +
                "\n" +
                "Decryption involves reversing the process, shifting each\n" +
                "letter of the ciphertext backward by the value of the\n" +
                "corresponding keyword letter. The Vigenère cipher was\n" +
                "considered unbreakable for many years until the 19th\n" +
                "century, when methods for breaking it were developed. Its\n" +
                "strength lies in its use of multiple shifting alphabets,\n" +
                "which makes frequency analysis, a common technique for\n" +
                "breaking simpler ciphers, much more difficult." +
                "\n" +
                "\n");

        cards.removeAll();
        cards.add(display);
        cards.revalidate();
        cards.repaint();

        vigenere = createVSquare(alphabet);
        square.setText(printSquare(vigenere));
        encodeButton.addActionListener(e -> {
            cards.removeAll();
            cards.add(encode);
            cards.revalidate();
            cards.repaint();
        });
        displaySquareButton.addActionListener(e -> {
            cards.removeAll();
            cards.add(display);
            cards.revalidate();
            cards.repaint();
        });
        decodeButton.addActionListener(e -> {
            cards.removeAll();
            cards.add(decode);
            cards.revalidate();
            cards.repaint();
        });
        DocumentListener d1 = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateFieldState();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateFieldState();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateFieldState();
            }

            private void updateFieldState() {
                if(!key.getText().isEmpty() && !toDecode.getText().isEmpty()) {
                    output.setText(decode(vigenere, key.getText().toUpperCase(), toDecode.getText().toUpperCase()));
                } else {
                    output.setText("");
                }
            }


        };
        DocumentListener d2 = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateFieldState();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateFieldState();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateFieldState();
            }

            private void updateFieldState() {
                if(!encodeKey.getText().isEmpty() && !toEncode.getText().isEmpty()) {
                    encodeOutput.setText(encode(vigenere, encodeKey.getText().toUpperCase(), toEncode.getText().toUpperCase()));
                } else {
                    output.setText("");
                }
            }


        };

        encodeKey.getDocument().addDocumentListener(d2);
        toDecode.getDocument().addDocumentListener(d2);

        key.getDocument().addDocumentListener(d1);
        toDecode.getDocument().addDocumentListener(d1);
    }
}
