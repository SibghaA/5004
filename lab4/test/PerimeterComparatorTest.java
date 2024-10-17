import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests for the {@code PerimeterComparator} class using the JUnit 5 testing framework.
 * <p>
 * It tests the functionality of the {@code compare} method, which compares two shapes based on their perimeters.
 */
class PerimeterComparatorTest {
    private PerimeterComparator comparator;
    private Circle circle;
    private Rectangle rectangle;

    /**
     * Sets up the test environment by initializing a {@code PerimeterComparator} object, a {@code Circle},
     * and a {@code Rectangle} before each test.
     * <p>
     * The circle is initialized with a center at (0, 0) and a radius of 5, while the rectangle is initialized
     * with a width and height of 10.
     */
    @BeforeEach
    void setUp() {
        comparator = new PerimeterComparator();
        circle = new Circle(0, 0, 5);
        rectangle = new Rectangle(0, 0, 10, 10);
    }

    /**
     * Tests the {@code compare} method of the {@code PerimeterComparator} class.
     * <p>
     * The method is expected to return a negative value when the first shape has a smaller perimeter,
     * a positive value when the first shape has a larger perimeter, and zero when the perimeters are equal.
     */
    @Test
    void testCompare() {
        // Circle has a smaller perimeter than the rectangle
        assertTrue(comparator.compare(circle, rectangle) < 0);

        // Rectangle has a larger perimeter than the circle
        assertTrue(comparator.compare(rectangle, circle) > 0);

        // Both circles have the same perimeter
        assertEquals(0, comparator.compare(circle, new Circle(1, 1, 5)));
    }
}
