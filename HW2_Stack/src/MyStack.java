import java.util.ArrayList;
import java.util.EmptyStackException;

import static java.util.Optional.empty;

/**
 * A generic stack implementation using ArrayList as the underlying data structure.
 * Follows LIFO (Last In First Out) principle.
 * Provides basic stack operations such as push, pop, top and checking for empty.
 *
 * @param <T> the type of elements stored in the stack
 */
public class MyStack<T> {
    /** The ArrayList used to store stack elements. */
    private ArrayList<T> elements;

    /**
     * Constructs an empty stack.
     * Initializes the internal ArrayList that will store the stack elements.
     */
    public MyStack() {
        elements = new ArrayList<>();
    }

    /**
     * Pushes an element onto the top of the stack making it the newest element in the stack.
     *
     * @param element the element to push onto the stack
     */
    public void push(T element) {
        elements.add(element);
    }

    /**
     * Removes and returns the element at the top of the stack. This element is the most recently added element.
     *
     * @return the element at the top of the stack.
     * @throws EmptyStackException if stack is empty.
     */
    public T pop() {
        if (elements.isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.remove(elements.size() - 1);
    }

    /**
     * Returns the element at the top of the stack without removing that element.
     *
     * @return the element at the stop of the stack.
     * @throws EmptyStackException if stack is empty.
     */
    public T top(){
        if (elements.isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.get(elements.size() - 1);
    }

    /**
     * Checks if stack is empty.
     *
     * @return true if the stack is empty and false otherwise.
     */
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    /**
     * Returns a string representing the stack's elements like so: "Stack: element1 element2..."
     *
     * @return a string representing the stack's elements. Each element is seperated by a space.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Stack: ");
        for (T element : elements) {
            sb.append(element).append(" ");
        }
        return sb.toString().trim();
    }

}
