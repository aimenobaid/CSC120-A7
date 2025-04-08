import java.util.*;

/**
 * The Library class represents a library building that stores a collection of books.
 * It extends the Building class and manages the availability of titles.
 */

public class Library extends Building implements LibraryRequirements{

  private Hashtable<String, Boolean> collection;

  /**
  * Constructs a new Library.
  * 
  * @param name    The name of the library.
  * @param address The address of the library.
  * @param nFloors The number of floors in the library.
  */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }

  /**
  * Adds a new title to the library's collection.
  * 
  * @param title The title of the book to add.
  */
  public void addTitle(String title) {
    collection.put(title, true); // Mark the book as available (true)
  }

  /**
  * Removes a title from the library's collection.
  * 
  * @param title The title of the book to remove.
  * @return The title that was removed.
  */
  public String removeTitle(String title) {
    collection.remove(title);
    return title;
  }

  /**
  * Checks out a book, marking it as unavailable.
  * 
  * @param title The title of the book to check out.
  */
  public void checkOut(String title) {
    if (collection.containsKey(title)) {
      collection.put(title, false); // Mark the book as unavailable (false)
    }
  }

  /**
  * Returns a book, marking it as available again.
  * 
  * @param title The title of the book to return.
  */
  public void returnBook(String title) {
    if (collection.containsKey(title)) {
      collection.put(title, true); // Mark the book as available (true)
    }
  }

  /**
  * Checks if the library contains a specific title.
  * 
  * @param title The title to check.
  * @return True if the title is in the collection, false otherwise.
  */
  public boolean containsTitle(String title) {
    return collection.containsKey(title);
  }

  /**
  * Checks if a specific title is available.
  * 
  * @param title The title to check.
  * @return True if the book is available, false if it is checked out.
  */
  public boolean isAvailable(String title) {
    return collection.getOrDefault(title, false);
  }

  /**
  * Prints out the entire collection of books and their availability.
  */
  public void printCollection() {
    for (String title : collection.keySet()) {
      System.out.println(title + " - " + (collection.get(title) ? "Available" : "Checked out"));
    }
  }

  /**
  * For testing the Library class.
  */
  public static void main(String[] args) {
    Library library = new Library("Central Library", "123 Main St", 5);
    library.addTitle("The Great Gatsby");
    library.addTitle("1984 by George Orwell");
    library.printCollection(); // Lists both titles

    library.checkOut("1984 by George Orwell");
    System.out.println(library.isAvailable("1984 by George Orwell")); // false
    library.returnBook("1984 by George Orwell");
    System.out.println(library.isAvailable("1984 by George Orwell")); // true
  }
}