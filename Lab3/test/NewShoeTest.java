import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the NewShoe class. This class will test all the methods of the NewShoe class to ensure it is working correctly.
 */
public class NewShoeTest {

    private NewShoe shoe;

    @BeforeEach
    public void setUp() {
        // This method runs before each test and initializes a common NewShoe object.
        shoe = new NewShoe("sneaker", Color.RED, "Nike", 9.5);
    }

    // Test for constructor
    @Test
    public void testConstructorEmptyTypeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new NewShoe("", Color.RED, "Nike", 10);
        });
    }

    @Test
    public void testConstructorValidInputs() {
        NewShoe validShoe = new NewShoe("sneaker", Color.BLUE, "Adidas", 9.5);
        assertEquals("sneaker", validShoe.getType());
        assertEquals(Color.BLUE, validShoe.getColor());
        assertEquals("Adidas", validShoe.getBrand());
        assertEquals(9.5, validShoe.getSize(), 0.01);
    }

    // Test for getType()
    @Test
    public void testGetType() {
        assertEquals("sneaker", shoe.getType());
    }

    @Test
    public void testGetTypeDifferentValue() {
        NewShoe differentShoe = new NewShoe("sandal", Color.WHITE, "Reebok", 7.5);
        assertEquals("sandal", differentShoe.getType());
    }

    // Test for getColor()
    @Test
    public void testGetColor() {
        assertEquals(Color.RED, shoe.getColor());
    }

    @Test
    public void testGetColorDifferentValue() {
        NewShoe differentShoe = new NewShoe("sandal", Color.YELLOW, "Puma", 8);
        assertEquals(Color.YELLOW, differentShoe.getColor());
    }

    // Test for getBrand()
    @Test
    public void testGetBrand() {
        assertEquals("Nike", shoe.getBrand());
    }

    @Test
    public void testGetBrandDifferentValue() {
        NewShoe differentShoe = new NewShoe("sandal", Color.PINK, "Crocs", 6.5);
        assertEquals("Crocs", differentShoe.getBrand());
    }

    // Test for getSize()
    @Test
    public void testGetSize() {
        assertEquals(9.5, shoe.getSize(), 0.01);
    }

    @Test
    public void testGetSizeDifferentValue() {
        NewShoe differentShoe = new NewShoe("sandal", Color.ORANGE, "Reebok", 7.5);
        assertEquals(7.5, differentShoe.getSize(), 0.01);
    }

    // Test for toString()
    @Test
    public void testToString() {
        String expected = "NewShoe{type='sneaker', color='Red', brand='Nike', size=9.5}";
        assertEquals(expected, shoe.toString());
    }

    @Test
    public void testToStringWithDefaultColor() {
        NewShoe greyShoe = new NewShoe("boot", Color.GREY, "Adidas", 10);
        String expected = "NewShoe{type='boot', color='To Be Determined', brand='Adidas', size=10.0}";
        assertEquals(expected, greyShoe.toString());
    }
}