import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;

/**
 * Test class for MyStack implementation.
 * Contains comprehensive tests with three assertions for each method.
 */
public class MyStackTest {

    private MyStack<String> stringStack;
    private MyStack<Integer> intStack;
    private MyStack<Double> doubleStack;
    private MyStack<Character> charStack;
    private MyStack<Book> bookStack;

    @BeforeEach
    void setUp() {
        stringStack = new MyStack<>();
        intStack = new MyStack<>();
        doubleStack = new MyStack<>();
        charStack = new MyStack<>();
        bookStack = new MyStack<>();
    }

    /**
     * Tests push operation with String data type.
     */
    @Test
    void testPushString() {
        stringStack.push("Hello");
        assertEquals("Stack: Hello", stringStack.toString());
        assertFalse(stringStack.isEmpty());
        stringStack.push("World");
        assertEquals("Stack: Hello World", stringStack.toString());
    }

    /**
     * Tests push operation with Double data type.
     */
    @Test
    void testPushDouble() {
        doubleStack.push(3.14);
        doubleStack.push(2.718);
        assertEquals("Stack: 3.14 2.718", doubleStack.toString());
        assertFalse(doubleStack.isEmpty());
        assertEquals(2, doubleStack.toString().split(" ").length - 1); // -1 for "Stack:"
    }

    /**
     * Tests push operation with Book objects.
     */
    @Test
    void testPushBook() {
        Book book1 = new Book("Harry Potter 1");
        bookStack.push(book1);
        assertEquals("Stack: Harry Potter 1", bookStack.toString());
        assertFalse(bookStack.isEmpty());
        Book book2 = new Book("Harry Potter 2");
        bookStack.push(book2);
        assertTrue(bookStack.toString().contains("Harry Potter 2"));
    }

    /**
     * Tests pop operation with Integer data type.
     */
    @Test
    void testPopInteger() {
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);
        assertEquals(3, intStack.pop());
        assertEquals("Stack: 1 2", intStack.toString());
        assertEquals(2, intStack.pop());
    }

    /**
     * Tests pop operation with String data type.
     */
    @Test
    void testPopString() {
        stringStack.push("First");
        stringStack.push("Second");
        assertEquals("Second", stringStack.pop());
        assertEquals("Stack: First", stringStack.toString());
        assertEquals("First", stringStack.pop());
    }

    /**
     * Tests pop operation with empty stack.
     */
    @Test
    void testPopEmpty() {
        assertThrows(EmptyStackException.class, () -> charStack.pop());
        charStack.push('A');
        charStack.pop();
        assertThrows(EmptyStackException.class, () -> charStack.pop());
        assertTrue(charStack.isEmpty());
    }

    /**
     * Tests top operation with Double data type.
     */
    @Test
    void testTopDouble() {
        doubleStack.push(1.1);
        doubleStack.push(2.2);
        assertEquals(2.2, doubleStack.top());
        assertEquals("Stack: 1.1 2.2", doubleStack.toString());
        assertEquals(2.2, doubleStack.top()); // Verify top doesn't change stack
    }

    /**
     * Tests top operation with Book objects.
     */
    @Test
    void testTopBook() {
        Book book1 = new Book("Book1");
        Book book2 = new Book("Book2");
        bookStack.push(book1);
        bookStack.push(book2);
        assertEquals(book2, bookStack.top());
        assertEquals("Stack: Book1 Book2", bookStack.toString());
        assertEquals(book2, bookStack.top()); // Verify top is consistent
    }

    /**
     * Tests top operation with empty stack.
     */
    @Test
    void testTopEmpty() {
        assertThrows(EmptyStackException.class, () -> stringStack.top());
        stringStack.push("Test");
        assertEquals("Test", stringStack.top());
        stringStack.pop();
        assertThrows(EmptyStackException.class, () -> stringStack.top());
    }

    /**
     * Tests empty operation with different data types.
     */
    @Test
    void testEmpty() {
        assertTrue(stringStack.isEmpty());  // Test initial state
        stringStack.push("Test");
        assertFalse(stringStack.isEmpty()); // Test after push
        stringStack.pop();
        assertTrue(stringStack.isEmpty());  // Test after pop
    }

    /**
     * Tests empty operation with multiple operations.
     */
    @Test
    void testEmptyWithMultipleOperations() {
        assertTrue(doubleStack.isEmpty());
        doubleStack.push(1.0);
        doubleStack.push(2.0);
        assertFalse(doubleStack.isEmpty());
        doubleStack.pop();
        doubleStack.pop();
        assertTrue(doubleStack.isEmpty());
    }

    /**
     * Tests empty operation with Book objects.
     */
    @Test
    void testEmptyWithBooks() {
        assertTrue(bookStack.isEmpty());
        bookStack.push(new Book("Test Book"));
        assertFalse(bookStack.isEmpty());
        bookStack.pop();
        assertTrue(bookStack.isEmpty());
    }
}