package Triqui.UI.model;

public class Game {
    private final Board board = new Board();
    private Player current = Player.X;
    private boolean finished = false;
    private Player winner = null;

    public Board board() { return board; }
    public Player current() { return current; }
    public boolean isFinished() { return finished; }
    public Player winner() { return winner; }

    public boolean play(int r, int c) {
        if (finished) return false;
        if (!board.place(r, c, current)) return false;

        winner = board.winner();
        if (winner != null) finished = true;
        else if (board.isFull()) finished = true; // Empate
        else current = current.next();

        return true;
    }

    public void reset() {
        board.clear();
        current = Player.X;
        finished = false;
        winner = null;
    }
}
