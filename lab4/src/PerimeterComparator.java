import java.util.Comparator;

/**
 * This class implements a {@code Comparator} for {@code Shape} objects, comparing them based on their perimeters.
 * <p>
 * The {@code PerimeterComparator} allows shapes to be ordered or sorted by their perimeter values.
 */
public class PerimeterComparator implements Comparator<Shape> {

    /**
     * Compares two {@code Shape} objects based on their perimeters.
     * <p>
     * This method retrieves the perimeters of the two shapes and compares them.
     *
     * @param shape1 the first {@code Shape} to be compared
     * @param shape2 the second {@code Shape} to be compared
     * @return a negative integer, zero, or a positive integer as the first shape's
     *         perimeter is less than, equal to, or greater than the second shape's perimeter
     */
    @Override
    public int compare(Shape shape1, Shape shape2) {
        double perimeter1 = shape1.perimeter();
        double perimeter2 = shape2.perimeter();

        return Double.compare(perimeter1, perimeter2);
    }
}
