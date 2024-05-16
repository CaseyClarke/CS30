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
    private JTextPane square;

    private final char[] alphabet = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
    private char[][] vigenere;
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

    public static void printSquare(char[][] sudokuGrid) {
        for (int row = 0; row < sudokuGrid.length; row++) {
            if (row < 10) {
                System.out.print(row + "  ");
            } else {
                System.out.print(row + " ");
            }
            for (int col = 0; col < sudokuGrid[row].length; col++) {
                if (sudokuGrid[row][col] < 10) {
                    System.out.print(sudokuGrid[row][col] + "  ");
                } else {
                    System.out.print(sudokuGrid[row][col] + " ");
                }
            }
            System.out.println();
        }
    }// printSudoku

    public static int linearSearch(char[] arr, char searchTerm) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == searchTerm) {
                return i;
            }
        }
        return -1;
    }

    public static char getChar(char[][] board, int row, int col) {
        return board[row][col];
    }

    public GUIfy_As5_vigenere() {

        vigenere = createVSquare(alphabet);
        encodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.removeAll();
                cards.add(encode);
                cards.revalidate();
                cards.repaint();
            }
        });
        displaySquareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.removeAll();
                cards.add(display);
                cards.revalidate();
                cards.repaint();
            }
        });
        decodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.removeAll();
                cards.add(decode);
                cards.revalidate();
                cards.repaint();
            }
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

            protected void updateFieldState() {
//                output.setText(decode(vigenere, toDecode.getText(), key.getText()));
            }


        };
        key.getDocument().addDocumentListener(d1);
        toDecode.getDocument().addDocumentListener(d1);
    }
}
