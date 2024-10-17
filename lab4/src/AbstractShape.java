/**
 * Created by ashesh on 1/26/2017.
 */
public abstract class AbstractShape implements Shape {
  protected Point2D reference;

  public AbstractShape(Point2D reference) {
    this.reference = reference;
  }

  @Override
  public double distanceFromOrigin() {
    return reference.distToOrigin();
  }


  @Override
  public int compareTo(Shape s) {
    double areaThis = this.area();
    double areaOther = s.area();

    if (areaThis < areaOther) {
      return -1;
    } else if (areaOther < areaThis) {
      return 1;
    } else {
      return 0;
    }
  }
}

/** ANSWER TO QUESTION 3 **/

/**
 The shared code in AbstractShape.java helps a lot in easy modification.
 If we didn’t have that, and we needed to change the Shape to be based on perimeter
 and not area we would need to modify not only the compareTo method in AbstractShape.java
 but also the area method in each of the concrete Shape classes we have created because they
 have their own specific implementation of compareTo.
**/