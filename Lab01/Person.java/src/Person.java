/**
 * Represents a shoe with various attributes such as type, color, brand, and size.
 * This class provides methods to access and display information about a shoe.
 */
public class Shoe {
    private String type;
    private String color;
    private String brand;
    private double size;

    /**
     * Constructs a new Shoe with the specified attributes.
     *
     * @param type  The type of the shoe (e.g., "sneaker", "boot", "sandal")
     * @param color The color of the shoe
     * @param brand The brand of the shoe
     * @param size  The size of the shoe in standard shoe sizing
     */
    public Shoe(String type, String color, String brand, double size) {
        this.type = type;
        this.color = color;
        this.brand = brand;
        this.size = size;
    }

    /**
     * Gets the type of the shoe.
     *
     * @return The type of the shoe as a String
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the color of the shoe.
     *
     * @return The color of the shoe as a String
     */
    public String getColor() {
        return color;
    }

    /**
     * Gets the brand of the shoe.
     *
     * @return The brand of the shoe as a String
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Gets the size of the shoe.
     *
     * @return The size of the shoe as a double
     */
    public double getSize() {
        return size;
    }

    /**
     * Returns a string representation of the Shoe object.
     *
     * @return A string summarizing the shoe's attributes
     */
    @Override
    public String toString() {
        return "Shoe{" +
                "type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                ", size=" + size +
                '}';
    }
}