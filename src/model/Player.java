package model;

public enum Player {
    X("X"), O("O");

    private final String symbol;

    Player(String symbol) { this.symbol = symbol; }
    public String symbol() { return symbol; }

    public Player next() { return this == X ? O : X; }
}
