import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Concrete Class to implement a Simple "To Do" list consisting of ToDoItems
 */
public class ToDoList {
  private List<ToDoItem> myToDoList;

  /** Constructor, creates a new, empty ToDoList
   * <p></p>
   * No parameters
   */
  public ToDoList() {
    myToDoList = new LinkedList<ToDoItem>();
  }

  /**
   * Adds a new ToDoItem to the end of the ToDoList
   * <p></p>
   * @param itm is a ToDoItem
   * Sorts the list in place, returns void
   */
  public void addItem(ToDoItem itm) {
    myToDoList.add(itm);
  }

  /**
   * Gets a ToDoItem from index position i
   * <p></p>
   * @param i is an integer index into the list
   * @return a ToDoItem
   * If the list is too short, passes through IndexOutOfBoundsException
   */
  ToDoItem getItem(int i) throws IndexOutOfBoundsException {
    return myToDoList.get(i);
  }

  /**
   * Removes all occurrences of a ToDoItem from the ToDoList
   * <p></p>
   * @param itm is a ToDoItem
   * @return true iff the object was found
   */
  boolean remove(ToDoItem itm) {
    return myToDoList.remove(itm);
  }

  /** Returns the size of the ToDoList as an int
   * <p></p>
   * @return int telling the number of ToDoItems in the ToDoList
   */
  int size() {
    return myToDoList.size();
  }

  /** Sorts so that the most important items are at the front
   * <p></p>
   * returns void -- the ToDoList is sorted in place
   * Assumes that Importance is the NATURAL ordering
   */
  void sortByImportance() {
    // STUDENT TO IMPLEMENT THIS METHOD
    Collections.sort(myToDoList);
  }

  /**
   * Sort so that the most urgent items are at the front
   * <p></p>
   * returns void -- the ToDoList is sorted in place
   */
  void sortByUrgency() {
    // STUDENT TO IMPLEMENT THIS METHOD
    Collections.sort(myToDoList, new UrgencyComparator());

  }

  /**
   * Returns the ToDoList as a string suitable for printing
   * <p></p>
   * @return a String with 1 ToDoItem per line
   * Refer to ToDoItem.toString for details of item strings
   * The list is enclosed in {curly braces}.
   */
  @Override
  public String toString() {
    String soFar = "{\n";
    for (ToDoItem anItem : myToDoList) {
      soFar += anItem.toString();
    }
    return soFar + "\n}";
  }
}
