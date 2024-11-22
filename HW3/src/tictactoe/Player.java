package tictactoe;

/**
 * Represents a player in the Tic-Tac-Toe game.
 * <p>
 * This enumeration defines the two possible players in a game of Tic-Tac-Toe.
 * Using an enum ensures type safety and prevents invalid player states.
 * The two players are traditionally represented as X and O.
 * </p>
 *
 */
public enum Player {
    /** Represents the X player, traditionally moves first */
    X,
    /** Represents the O player, traditionally moves second */
    O;

    /**
     * Returns the opponent of the current player.
     * <p>
     * This method provides a convenient way to switch between players
     * during the game without needing to explicitly check which player
     * is current.
     * </p>
     *
     * @return the other player (X returns O, O returns X)
     */
    public Player opponent() {
        return this == X ? O : X;
    }
}