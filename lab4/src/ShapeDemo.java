import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests for various kinds of shapes including
 * circles, rectangles, and triangles.
 */
class ShapeDemo {

  /** Shapes to be tested */
  Shape circle1, circle2, circle3, rect1, rect2, triangle1, triangle2;

  /**
   * Sets up the test fixtures before each test method.
   * This method is called before each test.
   */
  @BeforeEach
  void setup() {
    // ... (previous setup code) ...

    triangle1 = new Triangle(new Point2D(0, 0), new Point2D(3, 0), new Point2D(0, 4));
    triangle2 = new Triangle(new Point2D(1, 1), new Point2D(4, 1), new Point2D(1, 5));
  }

  /**
   * Tests whether objects have been created with the correct data.
   * This test verifies the correctness of the toString() method for each shape.
   */
  @Test
  void testObjectData() {
    // ... (previous tests) ...

    assertEquals("Triangle: points (0.000,0.000), (3.000,0.000), (0.000,4.000)", triangle1.toString());
    assertEquals("Triangle: points (1.000,1.000), (4.000,1.000), (1.000,5.000)", triangle2.toString());
  }

  /**
   * Tests the area calculation for all shapes.
   * This test verifies that the area() method returns the correct value for each shape.
   */
  @Test
  void testArea() {
    // ... (previous tests) ...

    assertEquals(6, triangle1.area(), 0.001);
    assertEquals(6, triangle2.area(), 0.001);
  }

  /**
   * Tests the perimeter calculation for all shapes.
   * This test verifies that the perimeter() method returns the correct value for each shape.
   */
  @Test
  void testPerimeter() {
    // ... (previous tests) ...

    assertEquals(12, triangle1.perimeter(), 0.001);
    assertEquals(12, triangle2.perimeter(), 0.001);
  }

  /**
   * Tests the resize operation for all shapes.
   * This test verifies that the resize() method correctly adjusts the area of each shape.
   */
  @Test
  void testResizes() {
    // ... (previous tests) ...

    Shape resizedTriangle1 = triangle1.resize(2.5);
    Shape resizedTriangle2 = triangle2.resize(0.5);

    assertEquals(2.5 * triangle1.area(), resizedTriangle1.area(), 0.001);
    assertEquals(0.5 * triangle2.area(), resizedTriangle2.area(), 0.001);
  }
}