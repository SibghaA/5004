import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests for the {@code Rectangle} class using the JUnit 5 framework.
 * <p>
 * It tests methods related to area calculation, perimeter calculation, resizing, and string representation
 * of a rectangle.
 */
class RectangleTest {
    private Rectangle rectangle;
    private static final double DELTA = 0.001;  // Tolerance for floating-point comparisons

    /**
     * Sets up the test environment by initializing a {@code Rectangle} object before each test.
     * <p>
     * The rectangle is initialized with its lower-left corner at (5, 6), a width of 2.5, and a height of 2.
     */
    @BeforeEach
    void setUp() {
        rectangle = new Rectangle(5, 6, 2.5, 2);
    }

    /**
     * Tests the {@code area} method of the {@code Rectangle} class.
     * <p>
     * The expected area is calculated as {@code width * height}.
     */
    @Test
    void testArea() {
        assertEquals(5, rectangle.area(), DELTA);
    }

    /**
     * Tests the {@code perimeter} method of the {@code Rectangle} class.
     * <p>
     * The expected perimeter is calculated as {@code 2 * (width + height)}.
     */
    @Test
    void testPerimeter() {
        assertEquals(9, rectangle.perimeter(), DELTA);
    }

    /**
     * Tests the {@code resize} method of the {@code Rectangle} class.
     * <p>
     * It checks if the resized shape is an instance of {@code Rectangle} and verifies that the
     * new area is proportional to the resize factor.
     */
    @Test
    void testResize() {
        Shape resized = rectangle.resize(12.5);
        assertTrue(resized instanceof Rectangle);
        assertEquals(12.5 * rectangle.area(), resized.area(), DELTA);
    }

    /**
     * Tests the {@code toString} method of the {@code Rectangle} class.
     * <p>
     * Verifies that the string representation of the rectangle matches the expected format.
     */
    @Test
    void testToString() {
        assertEquals("Rectangle: LL corner (5.000,6.000) width 2.500 height 2.000", rectangle.toString());
    }
}
