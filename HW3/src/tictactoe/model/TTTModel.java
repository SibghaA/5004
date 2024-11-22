package tictactoe.model;

import tictactoe.Player;

/**
 * Defines the contract for a Tic-Tac-Toe game model.
 * <p>
 * This interface specifies all operations that a controller needs to manage
 * a game of Tic-Tac-Toe, while hiding implementation details of how the
 * board state is maintained. The interface provides methods for making moves,
 * querying the game state, and managing the game lifecycle.
 * </p>
 * <p>
 * The game board uses zero-based indexing for rows and columns, where:
 * <ul>
 *   <li>Row 0 is the top row</li>
 *   <li>Column 0 is the leftmost column</li>
 * </ul>
 * </p>
 *
 *
 */
public interface TTTModel {

    /**
     * Attempts to make a move for the current player at the specified position.
     * <p>
     * This method validates the move and updates the game state if the move is legal.
     * A move is considered legal if:
     * <ul>
     *   <li>The game is not over</li>
     *   <li>The specified position is within the board boundaries</li>
     *   <li>The specified position is not already occupied</li>
     * </ul>
     * </p>
     *
     * @param row zero-based row index where 0 is the top row
     * @param col zero-based column index where 0 is the leftmost column
     * @throws IllegalStateException if the game is already over
     * @throws IllegalArgumentException if the position is outside the board dimensions
     * @throws IllegalStateException if it's not the specified player's turn
     * @return true if the move was successful, false if the position was already occupied
     */
    boolean makeMove(int row, int col);

    /**
     * Returns the player whose piece occupies the specified position.
     * <p>
     * This method allows the controller to query the state of any position
     * on the board. A null return value indicates an empty position.
     * </p>
     *
     * @param row zero-based row index
     * @param col zero-based column index
     * @throws IllegalArgumentException if the position is outside the board dimensions
     * @return the Player who has a piece at the specified position, or null if the position
     *         is empty. Returning null was chosen over a special EMPTY enum value to
     *         maintain clear distinction between actual players and empty spaces.
     */
    Player getPlayerAt(int row, int col);

    /**
     * Returns the player whose turn it currently is.
     * <p>
     * This method allows the controller to determine which player should
     * make the next move. A null return value indicates that the game is
     * over and no further moves are allowed.
     * </p>
     *
     * @return the Player whose turn it is, or null if the game is over.
     *         Null is returned for game-over state to prevent moves after game completion.
     */
    Player getCurrentPlayer();

    /**
     * Checks if the game has ended.
     * <p>
     * The game can end either by:
     * <ul>
     *   <li>A player winning by completing a row, column, or diagonal</li>
     *   <li>A draw when all positions are filled with no winner</li>
     * </ul>
     * </p>
     *
     * @return true if the game is over, false if moves can still be made
     */
    boolean isGameOver();

    /**
     * Returns the winner of the game, if any.
     * <p>
     * This method should be called to determine if a player has won the game.
     * A null return value can indicate either that the game is still in progress
     * or that the game ended in a draw.
     * </p>
     *
     * @return the Player who has won, or null if there is no winner (either game
     *         is still in progress or ended in a draw). Null was chosen to clearly
     *         distinguish between a player victory and other game states.
     */
    Player getWinner();

    /**
     * Gets the size of the game board.
     * <p>
     * The board is always square, so this value represents both the number
     * of rows and columns. For a traditional Tic-Tac-Toe game, this will
     * return 3.
     * </p>
     *
     * @return the number of rows (or columns) in the square board
     */
    int getBoardSize();

    /**
     * Resets the game to its initial state.
     * <p>
     * This method:
     * <ul>
     *   <li>Clears all positions on the board</li>
     *   <li>Sets X as the current player</li>
     *   <li>Resets any game-over state</li>
     * </ul>
     * </p>
     */
    void reset();
}

