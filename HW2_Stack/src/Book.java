/**
 * Represents a book with a title.
 * Used as an example of a custom object that can be stored in MyStack.
 */
public class Book {
    private String title;

    /**
     * Constructs a Book with the given title.
     *
     * @param title the title of the book
     */
    public Book(String title) {
        this.title = title;
    }

    /**
     * Gets the title of the book.
     *
     * @return the book's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the book.
     *
     * @param title the new title for the book
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns string representation of Book object.
     *
     * @return the title of the book
     */
    @Override
    public String toString() {
        return title;
    }
}