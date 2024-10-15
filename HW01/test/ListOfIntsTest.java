import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class for ListOfInts implementation.
 * This class contains unit tests for various operations on ListOfInts.
 */
public class ListOfIntsTest {

    /** The list instance to be used in tests. */
    private ListOfInts list;

    /**
     * Sets up a new empty list before each test.
     */
    @BeforeEach
    public void setUp() {
        list = new EmptyNode(); // Initialize list before each test
    }

    // ----------- Prepend Tests -----------

    /**
     * Tests prepending a single element to an empty list.
     */
    @Test
    public void testPrependSingle() {
        list = list.prepend(1);
        assertEquals("[1, []]", list.toString());
    }

    /**
     * Tests prepending multiple elements to an empty list.
     */
    @Test
    public void testPrependMultiple() {
        list = list.prepend(3).prepend(2).prepend(1);
        assertEquals("[1, [2, [3, []]]]", list.toString());
    }

    /**
     * Tests prepending elements to a non-empty list.
     */
    @Test
    public void testPrependToNonEmptyList() {
        list = list.append(4);
        list = list.prepend(3).prepend(2).prepend(1);
        assertEquals("[1, [2, [3, [4, []]]]]", list.toString());
    }

    // ----------- Append Tests -----------

    /**
     * Tests appending a single element to an empty list.
     */
    @Test
    public void testAppendSingle() {
        list = list.append(1);
        assertEquals("[1, []]", list.toString());
    }

    /**
     * Tests appending multiple elements to an empty list.
     */
    @Test
    public void testAppendMultiple() {
        list = list.append(1).append(2).append(3);
        assertEquals("[1, [2, [3, []]]]", list.toString());
    }

    /**
     * Tests appending elements to a non-empty list.
     */
    @Test
    public void testAppendToNonEmptyList() {
        list = list.prepend(0);
        list = list.append(1).append(2);
        assertEquals("[0, [1, [2, []]]]", list.toString());
    }

    /**
     * Tests inserting an element in the middle of the list.
     */
    @Test
    public void testInsertAtIndexMiddle() {
        list = list.append(1).append(3);
        list = list.insertAtIndex(2, 1); // Insert in the middle
        assertEquals("[1, [2, [3, []]]]", list.toString());
    }

    /**
     * Tests inserting an element at the start of the list.
     */
    @Test
    public void testInsertAtIndexStart() {
        list = list.append(2).append(3);
        list = list.insertAtIndex(1, 0); // Insert at start
        assertEquals("[1, [2, [3, []]]]", list.toString());
    }

    /**
     * Tests inserting an element at an invalid index.
     */
    @Test
    public void testInsertAtIndexOutOfBounds() {
        list = list.append(1);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.insertAtIndex(2, 5); // Index out of bounds
        });
    }


    /**
     * Tests retrieving data from a valid index.
     */
    @Test
    public void testGetDataAtIndexValid() {
        list = list.append(1).append(2).append(3);
        assertEquals(2, list.getDataAtIndex(1)); // Index 1 should return 2
    }

    /**
     * Tests retrieving the first element of the list.
     */
    @Test
    public void testGetDataAtIndexFirstElement() {
        list = list.append(1).append(2);
        assertEquals(1, list.getDataAtIndex(0)); // Index 0 should return 1
    }

    /**
     * Tests retrieving data from an empty list.
     */
    @Test
    public void testGetDataAtIndexInvalid() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.getDataAtIndex(0); // List is empty
        });
    }


    /**
     * Tests getting the count of an empty list.
     */
    @Test
    public void testGetCountClassicEmptyList() {
        assertEquals(0, list.getCountClassic());
    }

    /**
     * Tests getting the count of a non-empty list.
     */
    @Test
    public void testGetCountClassicNonEmptyList() {
        list = list.append(1).append(2).append(3);
        assertEquals(3, list.getCountClassic());
    }

    /**
     * Tests getting the count of a list with a single element.
     */
    @Test
    public void testGetCountClassicSingleElement() {
        list = list.append(1);
        assertEquals(1, list.getCountClassic());
    }


    /**
     * Tests getting the sum of an empty list.
     */
    @Test
    public void testGetSumEmptyList() {
        assertEquals(0, list.getSum()); // Sum of empty list should be 0
    }

    /**
     * Tests getting the sum of a list with multiple elements.
     */
    @Test
    public void testGetSumMultipleElements() {
        list = list.append(1).append(2).append(3);
        assertEquals(6, list.getSum()); // 1 + 2 + 3 = 6
    }

    /**
     * Tests getting the sum of a list with a single element.
     */
    @Test
    public void testGetSumSingleElement() {
        list = list.append(5);
        assertEquals(5, list.getSum()); // Single element list
    }
}