/**
 * Defines an Interface for ToDoItems, for use in ToDoList
 * <p></p>
 * There is more than one implementation of ToDoItem
 * Some methods can be shared, so an Abstract Class could be useful
 */
public interface ToDoItem {
  String getDescription();

  Importance getImportance();

  int getUrgency();

  @Override
  // Please override toString when implementing
  String toString();
}
