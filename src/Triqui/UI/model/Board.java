package Triqui.UI.model;

import java.util.Arrays;

public class Board {
    private final Player[][] cells = new Player[3][3];
    private int moves = 0;

    public Board() { clear(); }

    public void clear() {
        for (Player[] row : cells) Arrays.fill(row, null);
        moves = 0;
    }

    public boolean isEmpty(int r, int c) { return cells[r][c] == null; }

    public boolean place(int r, int c, Player p) {
        if (p == null || r < 0 || r > 2 || c < 0 || c > 2 || !isEmpty(r, c)) return false;
        cells[r][c] = p;
        moves++;
        return true;
    }

    public Player get(int r, int c) { return cells[r][c]; }

    public boolean isFull() { return moves == 9; }

    public Player winner() {

        for (int i = 0; i < 3; i++) {
            if (cells[i][0] != null && cells[i][0] == cells[i][1] && cells[i][1] == cells[i][2]) return cells[i][0];
            if (cells[0][i] != null && cells[0][i] == cells[1][i] && cells[1][i] == cells[2][i]) return cells[0][i];
        }

        if (cells[1][1] != null) {
            if (cells[0][0] == cells[1][1] && cells[1][1] == cells[2][2]) return cells[1][1];
            if (cells[0][2] == cells[1][1] && cells[1][1] == cells[2][0]) return cells[1][1];
        }
        return null;
    }
}
