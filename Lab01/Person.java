public class Person {
    // Fields
    private String firstName;
    private String lastName;
    private int yearOfBirth;

    // Constructor
    public Person(String firstName, String lastName, int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    // Method to display full name
    public String getFullName() {
        return firstName + " " + lastName;
    }

    // Method to calculate age
    public int calculateAge(int currentYear) {
        return currentYear - yearOfBirth;
    }
}

