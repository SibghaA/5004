/**
 * Javadocs in Progress
 */
public class ToDoItemSchool extends ToDoItemAbs {
  private boolean required;

  /**
   * One of two constructors, because "required" is not required!
   * <p></p>
   * @param description -- String describing the object
   * @param importance -- Enum: LOW, MEDIUM, or HIGH
   * @param urgency -- int (larger means more urgent)
   * @param required -- whether  assignment is required or optional
   */
  public ToDoItemSchool(String description,
      Importance importance,
      int urgency,
      boolean required) {
    super(description, importance, urgency);
    this.required = required;
  }

  /**
   * Alternate constructor, where "required" defaults to true
   * <p></p>
   * @param description -- String describing the ToDoItem
   * @param importance -- Enum LOW, MEDIUM, or HIGH
   * @param urgency -- int for how urgent (bigger = more urgent)
   */
  public ToDoItemSchool(String description,
      Importance importance,
      int urgency) {
    super(description, importance, urgency);
    this.required = true;
  }

  /**
   * Javadocs in progress
   *
   * @return boolean, whether a school assignment is required or not
   */
  public boolean getRequired() {
    return this.required;
  }

  // STUDENT TO IMPLEMENT EQUALS FOR THIS CLASS HERE

  // STUDENT TO IMPLEMENT HASHCODE FOR THIS CLASS HERE

  /**
   * @returns a String representation of a School ToDoItem
   */
  @Override
  public String toString() {
    String str = "ToDoItem: " + this.getDescription();
    str += " Importance: " + this.getImportance() + " Urgency: " + this.getUrgency();
    str += "required: " + this.getRequired();
    return str;
  }

  @Override
  public boolean equals (Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    ToDoItemSchool other = (ToDoItemSchool) obj;
    return this.required == other.required && this.urgency == other.urgency
            && this.importance == other.importance
            && (this.description == null ? other.description == null : this.description.equals(other.description));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (description == null ? 0 : description.hashCode());
    result = 31 * result + importance.hashCode();
    result = 31 * result + urgency;
    result = 31 * result + (required ? 1 : 0);

    return result;
  }
}
