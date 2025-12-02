package UI;

import javax.swing.*;
import java.awt.*;

public class CellButton extends JButton {
    private final int row;
    private final int col;

    public CellButton(int row, int col) {
        super("");
        this.row = row;
        this.col = col;
        setFont(new Font("SansSerif", Font.BOLD, 36));
        setFocusPainted(false);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}

