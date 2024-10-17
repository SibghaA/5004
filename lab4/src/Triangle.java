import java.util.Arrays;

/**
 * This class represents a triangle shape. It extends {@code AbstractShape} and implements
 * all the operations mandated by the {@code Shape} interface.
 * <p>
 * A triangle is defined by three unique points in a 2D space. This class provides methods
 * to calculate the area, perimeter, and to resize the triangle by scaling its vertices.
 */
public class Triangle extends AbstractShape {
    private Point2D point2;
    private Point2D point3;

    /**
     * Constructs a {@code Triangle} object using three unique points.
     *
     * @param p1 The first point of the triangle (used as the reference point)
     * @param p2 The second point of the triangle
     * @param p3 The third point of the triangle
     * @throws IllegalArgumentException if the points are not unique
     */
    public Triangle(Point2D p1, Point2D p2, Point2D p3) {
        super(p1);
        if (arePointsUnique(p1, p2, p3)) {
            this.point2 = p2;
            this.point3 = p3;
        } else {
            throw new IllegalArgumentException("Points must be unique");
        }
    }

    /**
     * Checks if the three points provided are unique.
     *
     * @param p1 The first point
     * @param p2 The second point
     * @param p3 The third point
     * @return {@code true} if all points are unique, {@code false} otherwise
     */
    private boolean arePointsUnique(Point2D p1, Point2D p2, Point2D p3) {
        return !(p1.getX() == p2.getX() && p1.getY() == p2.getY() ||
                p1.getX() == p3.getX() && p1.getY() == p3.getY() ||
                p2.getX() == p3.getX() && p2.getY() == p3.getY());
    }

    /**
     * Computes the area of the triangle using Heron's formula.
     *
     * @return the area of the triangle
     */
    @Override
    public double area() {
        double a = distanceBetween(reference, point2);
        double b = distanceBetween(point2, point3);
        double c = distanceBetween(point3, reference);
        double s = (a + b + c) / 2; // Semi-perimeter
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    /**
     * Computes the perimeter of the triangle by summing the lengths of its sides.
     *
     * @return the perimeter of the triangle
     */
    @Override
    public double perimeter() {
        return distanceBetween(reference, point2) +
                distanceBetween(point2, point3) +
                distanceBetween(point3, reference);
    }

    /**
     * Resizes the triangle by scaling its points relative to the reference point.
     *
     * @param factor the factor by which to scale the triangle's size
     * @return a new {@code Triangle} object with resized vertices
     */
    @Override
    public Shape resize(double factor) {
        double scaleFactor = Math.sqrt(factor);
        Point2D newP2 = scalePoint(reference, point2, scaleFactor);
        Point2D newP3 = scalePoint(reference, point3, scaleFactor);
        return new Triangle(reference, newP2, newP3);
    }

    /**
     * Scales a point relative to a center point by a given factor.
     *
     * @param center The center point from which to scale
     * @param point The point to scale
     * @param factor The scaling factor
     * @return A new {@code Point2D} object representing the scaled point
     */
    private Point2D scalePoint(Point2D center, Point2D point, double factor) {
        double newX = center.getX() + (point.getX() - center.getX()) * factor;
        double newY = center.getY() + (point.getY() - center.getY()) * factor;
        return new Point2D(newX, newY);
    }

    /**
     * Computes the Euclidean distance between two points in 2D space.
     *
     * @param p1 The first point
     * @param p2 The second point
     * @return The distance between the two points
     */
    private double distanceBetween(Point2D p1, Point2D p2) {
        double dx = p2.getX() - p1.getX();
        double dy = p2.getY() - p1.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Returns a string representation of the triangle.
     *
     * @return A string representation of the triangle's vertices
     */
    @Override
    public String toString() {
        return String.format("Triangle: points (%.3f,%.3f), (%.3f,%.3f), (%.3f,%.3f)",
                reference.getX(), reference.getY(),
                point2.getX(), point2.getY(),
                point3.getX(), point3.getY());
    }
}
