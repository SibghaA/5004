/**
 * Represents a node in the list containing an integer and a reference to the next node.
 */
public class ElementNode implements ListOfInts {
    /** The integer data stored in this node. */
    private final int data;

    /** Reference to the next node in the list. */
    private final ListOfInts next;

    /**
     * Constructs a new ElementNode with the given data and next node.
     *
     * @param data The integer to store in this node.
     * @param next The next node in the list.
     */
    public ElementNode(int data, ListOfInts next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Prepends a new element to the beginning of this list.
     *
     * @param data The integer to prepend.
     * @return A new ElementNode containing the given data, with this node as the next node.
     */
    @Override
    public ListOfInts prepend(int data) {
        return new ElementNode(data, this);
    }

    /**
     * Appends a new element to the end of this list.
     *
     * @param data The integer to append.
     * @return A new list with the given data appended to the end.
     */
    @Override
    public ListOfInts append(int data) {
        return new ElementNode(this.data, next.append(data));
    }

    /**
     * Inserts a new element at the specified index in this list.
     *
     * @param data The integer to insert.
     * @param index The position at which to insert the new element.
     * @return A new list with the given data inserted at the specified index.
     * @throws IndexOutOfBoundsException If the index is negative.
     */
    @Override
    public ListOfInts insertAtIndex(int data, int index) {
        if (index == 0) {
            return prepend(data);
        } else if (index > 0) {
            return new ElementNode(this.data, next.insertAtIndex(data, index - 1));
        } else {
            throw new IndexOutOfBoundsException("Index cannot be negative.");
        }
    }

    /**
     * Retrieves the data at the specified index in this list.
     *
     * @param index The index of the data to retrieve.
     * @return The integer at the specified index.
     * @throws IndexOutOfBoundsException If the index is negative or out of bounds.
     */
    @Override
    public int getDataAtIndex(int index) {
        if (index == 0) {
            return this.data;
        } else if (index > 0) {
            return next.getDataAtIndex(index - 1);
        } else {
            throw new IndexOutOfBoundsException("Invalid index.");
        }
    }

    /**
     * Returns the rest of the list (all elements except the first).
     *
     * @return The list containing all elements after this one.
     */
    @Override
    public ListOfInts getRest() {
        return this.next;
    }

    /**
     * Counts the number of elements in the list using a classic recursive approach.
     *
     * @return The number of elements in the list.
     */
    @Override
    public int getCountClassic() {
        return 1 + next.getCountClassic();
    }

    /**
     * Counts the number of elements in the list using a helper method.
     *
     * @return The number of elements in the list.
     */
    @Override
    public int getCountWithHelper() {
        return getCountHelper(0);
    }

    /**
     * Helper method for counting elements in the list.
     *
     * @param acc The accumulator for counting.
     * @return The total number of elements in the list.
     */
    @Override
    public int getCountHelper(int acc) {
        return next.getCountHelper(acc + 1);
    }

    /**
     * Calculates the sum of all elements in the list.
     *
     * @return The sum of all integers in the list.
     */
    @Override
    public int getSum() {
        return this.data + next.getSum();
    }

    /**
     * Returns a string representation of the list.
     *
     * @return A string representation of the list in the format "[data, rest]".
     */
    @Override
    public String toString() {
        return "[" + this.data + ", " + next.toString() + "]";
    }
}