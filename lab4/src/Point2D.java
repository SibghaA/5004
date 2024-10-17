/**
 * This class represents a 2D point. This point is denoted in Cartesian
 * coordinates as (x,y).
 */
public class Point2D {
  private double x;
  private double y;

  /**
   * Construct a 2d point with the given coordinates
   *
   * @param x the x-coordinate of this point
   * @param y the y-coordinate of this point
   */
  public Point2D(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Compute and return the Euclidean distance of this point to the origin
   *
   * @return the euclidean distance
   */
  public double distToOrigin() {
    return Math.sqrt(x * x + y * y);
  }

  /**
   * Compute and return the Euclidean distance between this point and another point
   *
   * @param other the other point
   * @return the euclidean distance between this point and the other point
   */
  public double distTo(Point2D other) {
    double dx = this.x - other.x;
    double dy = this.y - other.y;
    return Math.sqrt(dx * dx + dy * dy);
  }

  /**
   * Return the x-coordinate of this point
   *
   * @return x-coordinate of this point
   */
  public double getX() {
    return x;
  }

  /**
   * Return the y-coordinate of this point
   *
   * @return y-coordinate of this point
   */
  public double getY() {
    return y;
  }

  /**
   * Create a new Point2D that is this point scaled from the origin
   *
   * @param factor the scaling factor
   * @return a new Point2D that is this point scaled by the factor
   */
  public Point2D scale(double factor) {
    return new Point2D(this.x * factor, this.y * factor);
  }

  /**
   * Create a new Point2D that is this point scaled from a center point
   *
   * @param center the center point to scale from
   * @param factor the scaling factor
   * @return a new Point2D that is this point scaled from the center by the factor
   */
  public Point2D scaleFrom(Point2D center, double factor) {
    double dx = this.x - center.x;
    double dy = this.y - center.y;
    return new Point2D(center.x + dx * factor, center.y + dy * factor);
  }

  /**
   * Return a string representation of this point
   *
   * @return a string representation of this point
   */
  @Override
  public String toString() {
    return String.format("(%.3f,%.3f)", x, y);
  }

  /**
   * Check if this point is equal to another object
   *
   * @param obj the object to compare with
   * @return true if the objects are equal, false otherwise
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof Point2D)) return false;
    Point2D other = (Point2D) obj;
    return Double.compare(other.x, x) == 0 && Double.compare(other.y, y) == 0;
  }

  /**
   * Compute the hash code for this point
   *
   * @return the hash code for this point
   */
  @Override
  public int hashCode() {
    return Double.hashCode(x) * 31 + Double.hashCode(y);
  }
}