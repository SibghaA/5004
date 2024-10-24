public abstract class ToDoItemAbs implements ToDoItem, Comparable<ToDoItem> {
  protected String description;
  protected int urgency;
  protected Importance importance;

  /**
   * Javadocs in progress STUDENT TO COMPLETE THIS ONE
   * Constructs a new ToDoItemAbs with the specified description, urgency and importance.
   * It is an abstract class for different types of ToDo items
   * @param description a String briefly describing a ToDo item
   * @param importance importance level of a ToDo item. Importance level can be low,medium or high
   * @param urgency an integer representing urgency of a ToDo item. The higher the level the more urgent the task is.
   * @param NullPointerException if description or importance is null
   */
  public ToDoItemAbs(String description,
      Importance importance,
      int urgency) {
    this.description = description;
    this.importance = importance;
    this.urgency = urgency;
  }

  /**
   * Javadocs in progress STUDENT TO IMPLEMENT THIS ONE
   * Returns the description of this ToDo item.
   * The description gives details to what needs to be done in the task.
   */
  public String getDescription() {
    return this.description;
    }

  /**
   * Returns the importance of this item
   * <p></p>
   * @return Importance (an enum: LOW, MEDIUM, or HIGH)
   */
  @Override
  public Importance getImportance() {
    return this.importance;
  }

  /**
   * Javadocs in progress
   * @return urgency of this item as an int
   */
  @Override
  public int getUrgency() {
    return this.urgency;
  }

  /**
   * Javadocs in progress
   *
   * @param urgency
   */
  public void setUrgency(int urgency) {
    this.urgency = urgency;
  }

  /**
   * Comparable Interface for sorting by importance
   * @param other -- a ToDoItem
   * @return negative, 0, or positive int for LOW, MEDIUM, or HIGH
   */
  @Override
  public int compareTo(ToDoItem other) {
    // STUDENT TO IMPLEMENT THIS METHOD
    if (other == null) {
      throw new NullPointerException("Can't compare null ToDo Item");
    }
    return 0;
    }
}


