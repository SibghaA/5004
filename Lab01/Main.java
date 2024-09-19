public class Main {
    public static void main(String[] args) {
        // Create a Person object
        Person person = new Person("John", "Doe", 1990);

        // Use the methods of the Person class
        System.out.println("First Name: " + person.getFirstName());  // Using getFirstName()
        System.out.println("Last Name: " + person.getLastName());    // Using getLastName()
        System.out.println("Full Name: " + person.getFullName());    // Using getFullName()
        System.out.println("Age: " + person.calculateAge(2024));     // Using calculateAge()

        // Using setter to change values
        person.setFirstName("Jane");
        person.setLastName("Smith");
        person.setYearOfBirth(1985);

        System.out.println("Updated Full Name: " + person.getFullName());
        System.out.println("Updated Age: " + person.calculateAge(2024));
    }
}