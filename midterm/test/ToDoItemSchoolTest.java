import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ToDoItemSchoolTest {
  private ToDoItemSchool homework;

  @BeforeEach
  void setUp() {
    //  STUDENT TO IMPLEMENT AS NEEDED FOR THE TESTS BELOW
    homework = new ToDoItemSchoolTest("5004 lab", Importance.HIGH, 5, true);
  }

  @Test
  void getRequired() {
    // STUDENT TO IMPLEMENT THIS TEST WITH 1 ASSERTION
    assertTrue(homework.getRequired());
  }

  @Test
  void testToString() {
    // STUDENT TO IMPLEMENT THIS TEST WITH 1 ASSERTION
    String expected = "ToDoItem: 5004 lab Importance: HIGH Urgency: 5required: true";
    assertEquals(expected, homework.toString());
  }
}