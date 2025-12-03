package Parejas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class MemoryGameFrame extends JFrame {
    private JPanel contentPane;
    private JPanel gridPanel;
    private JButton resetButton;
    private JLabel statusLabel;

    private List<String> symbols;
    private JButton[] buttons;
    private JButton firstSelected = null;
    private int attempts = 0;

    public MemoryGameFrame() {
        setTitle("Juego de Parejas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 450);
        setLocationRelativeTo(null);
        setContentPane(contentPane);

        initGame();
        resetButton.addActionListener(e -> resetGame());
    }

    private void initGame() {
        gridPanel.setLayout(new GridLayout(4, 4, 5, 5));
        gridPanel.removeAll();

        symbols = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            symbols.add(String.valueOf(i));
            symbols.add(String.valueOf(i));
        }
        Collections.shuffle(symbols);

        buttons = new JButton[16];
        for (int i = 0; i < 16; i++) {
            JButton btn = new JButton("?");
            btn.setFont(new Font("SansSerif", Font.BOLD, 20));
            final int index = i;
            btn.addActionListener(e -> onButtonClick(btn, index));
            buttons[i] = btn;
            gridPanel.add(btn);
        }

        statusLabel.setText("Intentos: 0");
    }

    private void onButtonClick(JButton btn, int index) {
        btn.setText(symbols.get(index));
        btn.setEnabled(false);

        if (firstSelected == null) {
            firstSelected = btn;
        } else {
            attempts++;
            statusLabel.setText("Intentos: " + attempts);

            if (!firstSelected.getText().equals(btn.getText())) {
                Timer timer = new Timer(800, (ActionEvent e) -> {
                    firstSelected.setText("?");
                    firstSelected.setEnabled(true);
                    btn.setText("?");
                    btn.setEnabled(true);
                    firstSelected = null;
                });
                timer.setRepeats(false);
                timer.start();
            } else {
                firstSelected = null;
            }
        }
    }

    private void resetGame() {
        gridPanel.removeAll();
        firstSelected = null;
        attempts = 0;
        initGame();
        gridPanel.revalidate();
        gridPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MemoryGameFrame().setVisible(true));
    }

}
