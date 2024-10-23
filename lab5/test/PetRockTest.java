import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for PetRock. This class contains unit tests that verify the behavior
 * of the PetRock class, particularly focusing on equals(), hashCode(), and basic
 * functionality.
 * <p>
 * The tests verify:
 * - Object equality (reflexive, symmetric, and transitive properties)
 * - Hash code consistency
 * - Basic functionality (getters, setters)
 * - Mass comparison within three decimal places
 * - String representation
 */
class PetRockTest {
  /** Reference PetRock instance with name "Rocky" and mass 1.5 */
  private PetRock rock1;

  /** Identical PetRock to rock1 for equality testing */
  private PetRock rock2;

  /** Different PetRock instance for inequality testing */
  private PetRock rock3;

  /**
   * Sets up the test environment before each test method.
   * Creates three PetRock instances:
   * - rock1 and rock2: identical rocks named "Rocky" with mass 1.5
   * - rock3: different rock named "Pebbles" with mass 0.5
   */
  @BeforeEach
  void setUp() {
    rock1 = new PetRock("Rocky", 1.5);
    rock2 = new PetRock("Rocky", 1.5);
    rock3 = new PetRock("Pebbles", 0.5);
  }

  /**
   * Tests the reflexive property of equals():
   * x.equals(x) should return true.
   */
  @Test
  void testEqualsReflexive() {
    assertTrue(rock1.equals(rock1));
    assertEquals(rock1, rock1);
  }

  /**
   * Tests the symmetric property of equals():
   * x.equals(y) should return true if and only if y.equals(x) returns true.
   */
  @Test
  void testEqualsSymmetric() {
    assertTrue(rock1.equals(rock2));
    assertTrue(rock2.equals(rock1));
  }

  /**
   * Tests the transitive property of equals():
   * if x.equals(y) and y.equals(z), then x.equals(z) should return true.
   */
  @Test
  void testEqualsTransitive() {
    PetRock rock2Copy = new PetRock("Rocky", 1.5);
    assertTrue(rock1.equals(rock2));
    assertTrue(rock2.equals(rock2Copy));
    assertTrue(rock1.equals(rock2Copy));
  }

  /**
   * Tests equals() with different types of objects:
   * - Different PetRock instance
   * - null
   * - Object of different class
   */
  @Test
  void testEqualsWithDifferentObjects() {
    assertFalse(rock1.equals(rock3));
    assertFalse(rock1.equals(null));
    assertFalse(rock1.equals("Not a PetRock"));
  }

  /**
   * Tests equals() with different happiness states.
   * Two rocks with same name and mass but different happiness should not be equal.
   */
  @Test
  void testEqualsWithDifferentHappiness() {
    rock2.petTheRock();
    assertFalse(rock1.equals(rock2));
    assertFalse(rock3.equals(rock2));
  }

  /**
   * Tests equals() with mass differences within the three decimal place tolerance.
   * Masses that differ by less than 0.001 should be considered equal.
   */
  @Test
  void testEqualsWithSimilarMass() {
    PetRock rock4 = new PetRock("Rocky", 1.5001);
    assertTrue(rock1.equals(rock4));
    assertTrue(rock1.equals(rock2));
  }

  /**
   * Tests equals() with mass differences outside the three decimal place tolerance.
   * Masses that differ by 0.001 or more should not be considered equal.
   */
  @Test
  void testEqualsWithDifferentMass() {
    PetRock rock4 = new PetRock("Rocky", 1.51);
    assertFalse(rock1.equals(rock4));
    assertFalse(rock3.equals(rock4));
  }

  /**
   * Tests that hashCode() returns consistent results when called multiple times
   * on the same object.
   */
  @Test
  void testHashCodeConsistency() {
    int initialHashCode = rock1.hashCode();
    assertEquals(initialHashCode, rock1.hashCode());
    assertTrue(initialHashCode == rock1.hashCode());
  }

  /**
   * Tests that equal objects have equal hash codes.
   */
  @Test
  void testHashCodeEqualObjects() {
    assertEquals(rock1.hashCode(), rock2.hashCode());
    assertTrue(rock1.hashCode() == rock2.hashCode());
  }

  /**
   * Tests that objects considered equal due to mass tolerance
   * have the same hash code.
   */
  @Test
  void testHashCodeWithSimilarMass() {
    PetRock rock4 = new PetRock("Rocky", 1.5001);
    assertEquals(rock1.hashCode(), rock4.hashCode());
  }

  /**
   * Tests that different objects have different hash codes.
   */
  @Test
  void testHashCodeDifferentObjects() {
    PetRock rock4 = new PetRock("Rocky", 1.5001);
    assertNotEquals(rock1.hashCode(), rock3.hashCode());
    assertNotEquals(rock3.hashCode(), rock4.hashCode());
  }

  /**
   * Tests all getter methods to ensure they return the correct values.
   */
  @Test
  void testGetters() {
    assertEquals("Rocky", rock1.getName());
    assertEquals(1.5, rock1.getMass());
    assertFalse(rock1.getHappiness());
  }

  /**
   * Tests the petTheRock() method to ensure it properly changes
   * the happiness state from false to true.
   */
  @Test
  void testPetTheRock() {
    assertFalse(rock1.getHappiness());
    rock1.petTheRock();
    assertTrue(rock1.getHappiness());
  }

  /**
   * Tests equals() with different names to ensure rocks with
   * different names are not considered equal.
   */
  @Test
  void testEqualsWithDifferentNames() {
    PetRock rock4 = new PetRock("Different", 1.5);
    assertFalse(rock1.equals(rock4));
    assertFalse(rock4.equals(rock1));
  }

  /**
   * Tests equality of rocks with masses that round to the same
   * three decimal places.
   */
  @Test
  void testMassExactThreeDecimalPlaces() {
    PetRock rock4 = new PetRock("Rocky", 1.500);
    PetRock rock5 = new PetRock("Rocky", 1.5);
    assertTrue(rock4.equals(rock5));
    assertEquals(rock4.hashCode(), rock5.hashCode());
  }

  /**
   * Tests the toString() method to ensure it properly formats the
   * rock's properties and responds to state changes.
   */

  /**
   * Tests for PetRock constructor validation and initialization.
   */
  @Test
  void testValidConstruction() {
    PetRock rock = new PetRock("Rocky", 1.5);
    assertEquals("Rocky", rock.getName(), "Name should be set correctly");
    assertEquals(1.5, rock.getMass(), "Mass should be set correctly");
  }

  /**
   * Tests that a newly constructed rock starts unhappy.
   */
  @Test
  void testInitialHappiness() {
    PetRock rock = new PetRock("Rocky", 1.5);
    assertFalse(rock.getHappiness(), "New rock should be unhappy");
    assertEquals(false, rock.getHappiness(), "New rock's happiness should be false");
  }

  /**
   * Tests constructor with null name.
   */
  @Test
  void testNullName() {
    IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new PetRock(null, 1.0),
            "Constructor should throw IllegalArgumentException for null name"
    );
    assertTrue(exception.getMessage().contains("null"),
            "Exception message should mention null");
    assertNotNull(exception.getMessage(),
            "Exception should have a non-null message");
  }

  /**
   * Tests constructor with empty name.
   */
  @Test
  void testEmptyName() {
    IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new PetRock("", 1.0),
            "Constructor should throw IllegalArgumentException for empty name"
    );
    assertTrue(exception.getMessage().contains("empty"),
            "Exception message should mention empty");
    assertNotNull(exception.getMessage(),
            "Exception should have a non-null message");
  }

  /**
   * Tests constructor with blank name (only whitespace).
   */
  @Test
  void testBlankName() {
    IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new PetRock("   ", 1.0),
            "Constructor should throw IllegalArgumentException for blank name"
    );
    assertTrue(exception.getMessage().contains("empty"),
            "Exception message should mention empty");
    assertNotNull(exception.getMessage(),
            "Exception should have a non-null message");
  }

  /**
   * Tests constructor with zero mass.
   */
  @Test
  void testZeroMass() {
    IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new PetRock("Rocky", 0.0),
            "Constructor should throw IllegalArgumentException for zero mass"
    );
    assertTrue(exception.getMessage().contains("positive"),
            "Exception message should mention positive");
    assertNotNull(exception.getMessage(),
            "Exception should have a non-null message");
  }

  /**
   * Tests constructor with negative mass.
   */
  @Test
  void testNegativeMass() {
    IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new PetRock("Rocky", -1.0),
            "Constructor should throw IllegalArgumentException for negative mass"
    );
    assertTrue(exception.getMessage().contains("positive"),
            "Exception message should mention positive");
    assertNotNull(exception.getMessage(),
            "Exception should have a non-null message");
  }

  /**
   * Tests constructor with minimum positive mass.
   */
  @Test
  void testMinimumPositiveMass() {
    PetRock rock = new PetRock("Rocky", Double.MIN_VALUE);
    assertTrue(rock.getMass() > 0, "Mass should be positive");
    assertEquals(Double.MIN_VALUE, rock.getMass(), "Mass should be set to minimum positive double");
  }

  /**
   * Tests constructor with very large mass.
   */
  @Test
  void testLargeMass() {
    double largeMass = 1.0e308;  // Very large but valid double
    PetRock rock = new PetRock("Rocky", largeMass);
    assertTrue(rock.getMass() > 0, "Mass should be positive");
    assertEquals(largeMass, rock.getMass(), "Mass should be set to large value");
  }

  /**
   * Tests constructor with name containing special characters.
   */
  @Test
  void testSpecialCharacterName() {
    String specialName = "Rock#1!@$%";
    PetRock rock = new PetRock(specialName, 1.0);
    assertEquals(specialName, rock.getName(), "Name should allow special characters");
    assertNotNull(rock.getName(), "Name should not be null");
  }

  @Test
  void testToString() {
    assertEquals("PetRock{name='Rocky', mass=1.500, happiness=false}",
            rock1.toString());
    rock1.petTheRock();
    assertEquals("PetRock{name='Rocky', mass=1.500, happiness=true}",
            rock1.toString());
  }
}