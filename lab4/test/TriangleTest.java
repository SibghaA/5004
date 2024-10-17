import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests for the {@code Triangle} class using the JUnit 5 framework.
 * <p>
 * It tests methods related to the construction, area calculation, perimeter calculation, resizing,
 * string representation, and distance from the origin for a triangle.
 */
class TriangleTest {
    private Triangle triangle;
    private static final double DELTA = 0.001;  // Tolerance for floating-point comparisons

    /**
     * Sets up the test environment by initializing a {@code Triangle} object before each test.
     * <p>
     * The triangle is initialized with vertices at (0, 0), (3, 0), and (0, 4), forming a right triangle.
     */
    @BeforeEach
    void setUp() {
        triangle = new Triangle(new Point2D(0, 0), new Point2D(3, 0), new Point2D(0, 4));
    }

    /**
     * Tests the valid construction of a {@code Triangle}.
     * <p>
     * Verifies that the triangle is created successfully with valid unique points.
     */
    @Test
    void testValidConstruction() {
        assertNotNull(triangle, "Triangle should be created successfully");
    }

    /**
     * Tests the invalid construction of a {@code Triangle} with non-unique points.
     * <p>
     * Verifies that an {@code IllegalArgumentException} is thrown when attempting to create a triangle
     * with duplicate points.
     */
    @Test
    void testInvalidConstruction() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(new Point2D(0, 0), new Point2D(0, 0), new Point2D(3, 4));
        }, "Should throw IllegalArgumentException for non-unique points");
    }

    /**
     * Tests the {@code area} method of the {@code Triangle} class.
     * <p>
     * The expected area is calculated using the formula for a right triangle: {@code (base * height) / 2}.
     */
    @Test
    void testArea() {
        assertEquals(6.0, triangle.area(), DELTA, "Area should be 6");
    }

    /**
     * Tests the {@code perimeter} method of the {@code Triangle} class.
     * <p>
     * The expected perimeter is the sum of the lengths of the three sides.
     */
    @Test
    void testPerimeter() {
        assertEquals(12.0, triangle.perimeter(), DELTA, "Perimeter should be 12");
    }

    /**
     * Tests the {@code resize} method of the {@code Triangle} class.
     * <p>
     * It checks if the resized shape is still a triangle and verifies that the area is scaled correctly.
     */
    @Test
    void testResize() {
        Shape resized = triangle.resize(4);
        assertAll(
                () -> assertTrue(resized instanceof Triangle, "Resized shape should be a Triangle"),
                () -> assertEquals(24.0, resized.area(), DELTA, "Area should be 24")
        );
    }

    /**
     * Tests the {@code toString} method of the {@code Triangle} class.
     * <p>
     * Verifies that the string representation of the triangle matches the expected format.
     */
    @Test
    void testToString() {
        String expected = "Triangle: points (0.000,0.000), (3.000,0.000), (0.000,4.000)";
        assertEquals(expected, triangle.toString(), "toString should match expected format");
    }

    /**
     * Tests the {@code distanceFromOrigin} method of the {@code Triangle} class.
     * <p>
     * Verifies that the distance from the origin (0, 0) to the triangle's reference point is correctly calculated.
     */
    @Test
    void testDistanceFromOrigin() {
        assertEquals(0.0, triangle.distanceFromOrigin(), DELTA, "Distance from origin should be 0");
    }
}
