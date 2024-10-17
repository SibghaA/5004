import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests for the {@code Circle} class using the JUnit 5 testing framework.
 * <p>
 * It tests the behavior of methods related to area calculation, perimeter calculation, resizing,
 * and string representation of a circle.
 */
class CircleTest {
    private Circle circle;
    private static final double DELTA = 0.001;  // Margin of error for floating-point comparisons

    /**
     * Sets up the test environment by initializing a {@code Circle} object before each test.
     * <p>
     * The circle is initialized with a center at coordinates (3, 4) and a radius of 5.
     */
    @BeforeEach
    void setUp() {
        circle = new Circle(3, 4, 5);
    }

    /**
     * Tests the {@code area} method of the {@code Circle} class.
     * <p>
     * The expected area is calculated as {@code Math.PI * radius^2}.
     */
    @Test
    void testArea() {
        assertEquals(Math.PI * 25, circle.area(), DELTA);
    }

    /**
     * Tests the {@code perimeter} method of the {@code Circle} class.
     * <p>
     * The expected perimeter is calculated as {@code 2 * Math.PI * radius}.
     */
    @Test
    void testPerimeter() {
        assertEquals(2 * Math.PI * 5, circle.perimeter(), DELTA);
    }

    /**
     * Tests the {@code resize} method of the {@code Circle} class.
     * <p>
     * It checks if the resized shape is an instance of {@code Circle} and verifies that the
     * new area is proportional to the resize factor.
     */
    @Test
    void testResize() {
        Shape resized = circle.resize(2.5);
        assertTrue(resized instanceof Circle);
        assertEquals(2.5 * circle.area(), resized.area(), DELTA);
    }

    /**
     * Tests the {@code toString} method of the {@code Circle} class.
     * <p>
     * Verifies that the string representation of the circle matches the expected format.
     */
    @Test
    void testToString() {
        assertEquals("Circle: center (3.000,4.000) radius 5.000", circle.toString());
    }
}
