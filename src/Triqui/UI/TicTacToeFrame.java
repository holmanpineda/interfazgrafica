package Triqui.UI;

import Triqui.UI.model.Game;
import Triqui.UI.model.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TicTacToeFrame extends JFrame {
    private JPanel contentPane;
    private JPanel gridPanel;
    private JLabel statusLabel;
    private JButton resetButton;

    private final Game game = new Game();
    private final List<CellButton> buttons = new ArrayList<>(9);

    public TicTacToeFrame() {
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(360, 420);
        setLocationRelativeTo(null);
        initUI();
        updateStatus();
    }

    private void initUI() {
        contentPane = new JPanel(new BorderLayout(10, 10));
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);

        // Top status
        statusLabel = new JLabel("", SwingConstants.CENTER);
        statusLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        contentPane.add(statusLabel, BorderLayout.NORTH);

        // Grid 3x3
        gridPanel = new JPanel(new GridLayout(3, 3, 6, 6));
        contentPane.add(gridPanel, BorderLayout.CENTER);

        // Crear botones de celdas
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                CellButton btn = new CellButton(r, c);
                btn.addActionListener(e -> onCellClick(btn));
                buttons.add(btn);
                gridPanel.add(btn);
            }
        }

        // Bottom reset
        resetButton = new JButton("Reiniciar");
        resetButton.addActionListener(e -> onReset());
        contentPane.add(resetButton, BorderLayout.SOUTH);
    }

    private void onCellClick(CellButton btn) {
        if (!game.play(btn.getRow(), btn.getCol())) return;

        Player p = game.board().get(btn.getRow(), btn.getCol());
        btn.setText(p.symbol());
        btn.setEnabled(false);

        if (game.isFinished()) {
            lockBoard();
            if (game.winner() != null) {
                statusLabel.setText("Ganó " + game.winner().symbol() + " ✨");
            } else {
                statusLabel.setText("Empate 🤝");
            }
        } else {
            updateStatus();
        }
    }

    private void lockBoard() {
        for (CellButton b : buttons) b.setEnabled(false);
    }

    private void unlockBoard() {
        for (CellButton b : buttons) {
            b.setEnabled(true);
            b.setText("");
        }
    }

    private void updateStatus() {
        statusLabel.setText("Turno: " + game.current().symbol());
    }

    private void onReset() {
        game.reset();
        unlockBoard();
        updateStatus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TicTacToeFrame().setVisible(true));
    }
}
