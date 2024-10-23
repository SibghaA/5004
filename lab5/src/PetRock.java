/**
 * Represents a Pet Rock object, inspired by the 1970s fad toy.
 * <p>
 * A Pet Rock has three primary attributes:
 * - A name that cannot be changed after creation
 * - A mass in arbitrary units that cannot be changed after creation
 * - A happiness state that begins as false and can be changed to true by petting
 * <p>
 * This class demonstrates proper implementation of equals() and hashCode() methods,
 * particularly showing how to handle floating-point comparisons within a specified
 * precision (three decimal places).
 *
 */
public class PetRock {
  /** The immutable name of the pet rock */
  private final String name;

  /** The current happiness state of the pet rock */
  private boolean happiness;

  /** The immutable mass of the pet rock in arbitrary units */
  private final double mass;

  /**
   * Constructs a new Pet Rock with the specified name and mass.
   * <p>
   * Creates an unhappy pet rock by default. The happiness state can be
   * changed later by petting the rock.
   *
   * @param name the name of the pet rock, must not be null or empty
   * @param mass the mass of the pet rock in arbitrary units, must be positive
   * @throws IllegalArgumentException if name is null or empty, or if mass is not positive
   */
  public PetRock(String name, double mass) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException("Name cannot be null or empty");
    }
    if (mass <= 0) {
      throw new IllegalArgumentException("Mass must be positive");
    }
    this.name = name;
    this.happiness = false;
    this.mass = mass;
  }

  /**
   * Returns the name of this pet rock.
   *
   * @return the immutable name of the pet rock
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the current happiness state of this pet rock.
   *
   * @return true if the rock has been petted, false otherwise
   */
  public boolean getHappiness() {
    return happiness;
  }

  /**
   * Makes the pet rock happy by petting it.
   * <p>
   * Once a rock has been petted, it remains happy forever.
   */
  public void petTheRock() {
    this.happiness = true;
  }

  /**
   * Returns the mass of this pet rock.
   *
   * @return the immutable mass of the pet rock in arbitrary units
   */
  public double getMass() {
    return mass;
  }

  /**
   * Determines whether this PetRock is equal to another object.
   * <p>
   * Two PetRock objects are considered equal if:
   * - They are both PetRock instances
   * - They have the same name (case-sensitive)
   * - They have the same happiness state
   * - Their masses are equal within three decimal places
   *
   * @param obj the object to compare this PetRock against
   * @return true if the given object represents a PetRock equivalent to this PetRock,
   *         false otherwise
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    PetRock petRock = (PetRock) obj;
    return happiness == petRock.happiness &&
            Math.abs(mass - petRock.mass) < 0.001 &&
            name.equals(petRock.name);
  }

  /**
   * Returns a hash code value for the PetRock.
   * <p>
   * The hash code is generated considering:
   * - The name of the pet rock
   * - The happiness state
   * - The mass rounded to three decimal places
   * <p>
   * This implementation ensures that two PetRock objects that are considered equal
   * according to equals() will return the same hash code, as required by the
   * general contract of hashCode().
   *
   * @return a hash code value for this PetRock
   * @see #equals(Object)
   */
  @Override
  public int hashCode() {
    int result = name.hashCode();
    result = 31 * result + (happiness ? 1 : 0);
    long massLong = Double.doubleToLongBits(Math.round(mass * 1000.0) / 1000.0);
    result = 31 * result + (int) (massLong ^ (massLong >>> 32));
    return result;
  }

  /**
   * Returns a string representation of this PetRock.
   * <p>
   * The string includes the rock's name, mass (formatted to three decimal places),
   * and current happiness state.
   *
   * @return a string representation of the PetRock
   */
  @Override
  public String toString() {
    return String.format("PetRock{name='%s', mass=%.3f, happiness=%b}",
            name, mass, happiness);
  }
}