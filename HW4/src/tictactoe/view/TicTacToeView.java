package tictactoe.view;

import tictactoe.Player;

/**
 * Represents the View component of a Tic Tac Toe game following the MVC architecture pattern.
 * This interface defines the contract between the Controller and View, specifying all operations
 * that the Controller may need to interact with the user interface, whether it's text-based,
 * GUI-based, or a mock implementation for testing.
 */
public interface TicTacToeView {
    /**
     * Displays the current state of the game board to the user.
     * Implementation should be flexible enough to work with any visual representation
     * (text, GUI, etc.) while maintaining consistency with the model's board representation.
     *
     * @throws IllegalStateException if the view is in an invalid state to display the board
     *         or if called before initialization
     */
    void displayBoard();

    /**
     * Gets the next move from the user. The implementation should handle the specifics
     * of how to obtain this input (console, GUI events, etc.) and ensure it's valid
     * according to the model's constraints (zero-based indices, within board bounds).
     * <p>
     * Example returns:
     * <ul>
     *   <li>{0, 0} represents the top-left position</li>
     *   <li>{0, 2} represents the top-right position in a 3x3 board</li>
     *   <li>{2, 1} represents the bottom-middle position in a 3x3 board</li>
     * </ul>
     * </p>
     *
     * @return An array containing two integers representing the row and column of the move
     *         {row, column}, where both values are zero-based indices
     * @throws IllegalStateException if called when it's not appropriate to get a move
     *         (e.g., game is over) or if called before initialization
     */
    int[] getMoveFromUser();

    /**
     * Displays a message to the user indicating whose turn it is.
     * <p>
     * Example display messages:
     * <ul>
     *   <li>"Player X's turn"</li>
     *   <li>"Player O's turn"</li>
     * </ul>
     * </p>
     *
     * @param player the current player (X or O)
     * @throws IllegalArgumentException if player is null
     * @throws IllegalStateException if called before initialization or after game is over
     */
    void displayCurrentPlayer(Player player);

    /**
     * Displays the game outcome to the user (winner or draw).
     * <p>
     * Example scenarios:
     * <ul>
     *   <li>If winner is Player.X: "Player X wins!"</li>
     *   <li>If winner is Player.O: "Player O wins!"</li>
     *   <li>If winner is null: "Game ends in a draw"</li>
     * </ul>
     * </p>
     *
     * @param winner the winning player or null if it's a draw
     * @throws IllegalStateException if called when game is not over
     *         or if called before initialization
     */
    void displayGameOver(Player winner);

    /**
     * Displays an error message to the user.
     * This method should be used for invalid moves, illegal states, or other error conditions.
     * <p>
     * Example error messages:
     * <ul>
     *   <li>"Invalid move: Position already occupied"</li>
     *   <li>"Invalid move: Position out of bounds"</li>
     *   <li>"Cannot make move: Game is over"</li>
     * </ul>
     * </p>
     *
     * @param message the error message to display
     * @throws IllegalArgumentException if message is null
     * @throws IllegalStateException if called before initialization
     */
    void displayError(String message);

    /**
     * Prompts the user if they want to play again after a game ends.
     * <p>
     * Example prompt: "Would you like to play again? (yes/no)"
     * </p>
     *
     * @return true if the user wants to play again, false otherwise
     * @throws IllegalStateException if called when game is not over
     *         or if called before initialization
     */
    boolean getPlayAgainChoice();

    /**
     * Clears the display in preparation for a new game or updated view.
     * Implementation should be appropriate for the specific view type
     * (clear console, reset GUI, etc.).
     *
     * @throws IllegalStateException if called before initialization
     */
    void clearDisplay();

    /**
     * Initializes or resets the view to its starting state.
     * This should be called before beginning a new game or after reset().
     * <p>
     * Initialization typically includes:
     * <ul>
     *   <li>Setting up the display area</li>
     *   <li>Preparing input mechanisms</li>
     *   <li>Displaying initial welcome message</li>
     * </ul>
     * </p>
     *
     * @throws IllegalStateException if the view cannot be initialized due to
     *         resource constraints or other technical issues
     */
    void initialize();
}

/* Internal Implementation Notes:
 * - getMoveFromUser() uses zero-based indices to match the model's board representation
 * - We use the Player enum instead of Strings to maintain type safety and consistency
 *   with the model
 * - displayGameOver takes a Player parameter to match the model's getWinner() method,
 *   where null indicates a draw
 * - Error handling aligns with the model's exceptions (IllegalArgumentException for
 *   invalid positions, IllegalStateException for inappropriate timing)
 * - The view maintains no knowledge of board implementation, only displaying what the
 *   controller provides via model queries
 */