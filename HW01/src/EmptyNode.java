/**
 * Represents an empty node in the list.
 */
public class EmptyNode implements ListOfInts {

    /**
     * Prepends an element to the empty list, creating a new non-empty list.
     *
     * @param data The integer to prepend.
     * @return A new ElementNode containing the data, with this empty node as the rest.
     */
    @Override
    public ListOfInts prepend(int data) {
        return new ElementNode(data, this);
    }

    /**
     * Appends an element to the empty list, creating a new non-empty list.
     *
     * @param data The integer to append.
     * @return A new ElementNode containing the data, with this empty node as the rest.
     */
    @Override
    public ListOfInts append(int data) {
        return new ElementNode(data, this);
    }

    /**
     * Inserts an element at a specified index in the empty list.
     *
     * @param data The integer to insert.
     * @param index The index at which to insert the data.
     * @return A new ElementNode if index is 0, otherwise throws an exception.
     * @throws IndexOutOfBoundsException If the index is not 0.
     */
    @Override
    public ListOfInts insertAtIndex(int data, int index) {
        if (index != 0) {
            throw new IndexOutOfBoundsException("Invalid index for empty list.");
        }
        return new ElementNode(data, this);
    }

    /**
     * Attempts to retrieve data at a specified index in the empty list.
     *
     * @param index The index to retrieve data from.
     * @throws IndexOutOfBoundsException Always, as the list is empty.
     */
    @Override
    public int getDataAtIndex(int index) {
        throw new IndexOutOfBoundsException("Empty list.");
    }

    /**
     * Attempts to get the rest of the empty list.
     *
     * @throws IllegalStateException Always, as an empty list has no rest.
     */
    @Override
    public ListOfInts getRest() {
        throw new IllegalStateException("Empty list has no rest.");
    }

    /**
     * Returns the count of elements in the list using a classic approach.
     *
     * @return 0, as the list is empty.
     */
    @Override
    public int getCountClassic() {
        return 0;
    }

    /**
     * Returns the count of elements in the list using a helper method.
     *
     * @return The result of calling getCountHelper with initial accumulator 0.
     */
    @Override
    public int getCountWithHelper() {
        return getCountHelper(0);
    }

    /**
     * Helper method for counting elements in the list.
     *
     * @param acc The accumulator for counting.
     * @return The final accumulator value, which is 0 for an empty list.
     */
    @Override
    public int getCountHelper(int acc) {
        return acc;
    }

    /**
     * Calculates the sum of all elements in the list.
     *
     * @return 0, as the list is empty.
     */
    @Override
    public int getSum() {
        return 0;
    }

    /**
     * Returns a string representation of the empty list.
     *
     * @return "[]", representing an empty list.
     */
    @Override
    public String toString() {
        return "[]";
    }
}