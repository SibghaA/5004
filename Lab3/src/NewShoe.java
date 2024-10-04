/**
 * Represents a shoe with various attributes such as type, color, brand, and size.
 * This class provides methods to access and display information about a shoe.
 */
public class NewShoe {
    private String type;
    private Color color;
    private String brand;
    private double size;

    /**
     * Constructs a new NewShoe with the specified attributes.
     *
     * @param type  The type of the shoe (e.g., "sneaker", "boot", "sandal"). Cannot be an empty string.
     * @param color The color of the shoe, provided as an enum value.
     * @param brand The brand of the shoe.
     * @param size  The size of the shoe in standard shoe sizing.
     * @throws IllegalArgumentException If the type is an empty string.
     */
    public NewShoe(String type, Color color, String brand, double size) {
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Shoe type cannot be empty.");
        }
        this.type = type;
        this.color = color;
        this.brand = brand;
        this.size = size;
    }

    /**
     * Gets the type of the shoe.
     *
     * @return The type of the shoe as a String.
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the color of the shoe.
     *
     * @return The color of the shoe as an enum value.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Gets the brand of the shoe.
     *
     * @return The brand of the shoe as a String.
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Gets the size of the shoe.
     *
     * @return The size of the shoe as a double.
     */
    public double getSize() {
        return size;
    }

    /**
     * Returns a string representation of the NewShoe object.
     * The color is displayed with a customized spelling or capitalization for certain cases.
     *
     * @return A string summarizing the shoe's attributes in this format:
     *         "NewShoe{type='type', color='custom color string', brand='brand', size=size}"
     */
    @Override
    public String toString() {
        String colorString;
        switch (color) {
            case RED:
                colorString = "Red";
                break;
            case BLUE:
                colorString = "Blue";
                break;
            case BLACK:
                colorString = "Black";
                break;
            case WHITE:
                colorString = "White";
                break;
            default:
                colorString = "To Be Determined";
                break;
        }

        return "NewShoe{" +
                "type='" + type + '\'' +
                ", color='" + colorString + '\'' +
                ", brand='" + brand + '\'' +
                ", size=" + size +
                '}';
    }
}