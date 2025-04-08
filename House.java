import java.util.*;
/**
 * The House class represents a residential building where students can live.
 * It extends the Building class and keeps track of student residents and whether it has a dining room.
 */

public class House extends Building implements HouseRequirements{

  private ArrayList<Student> residents;
  private boolean hasDiningRoom;

  /**
  * Constructs a new House.
  * 
  * @param name           The name of the house.
  * @param address        The address of the house.
  * @param nFloors        The number of floors in the house.
  * @param hasDiningRoom  Whether the house has a dining room.
  */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = hasDiningRoom;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Returns whether the house has a dining room.
   */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /**
   * Returns the number of current residents.
   */
  public int nResidents() {
    return this.residents.size();
  }

  /**
   * Moves a student into the house.
   * 
   * @param s The student moving in.
   */
  public void moveIn(Student s) {
    if (!this.residents.contains(s)) {
      this.residents.add(s);
    }
  }

  /**
   * Moves a student out of the house.
   * 
   * @param s The student moving out.
   * @return  The student who moved out.
   */
  public Student moveOut(Student s) {
    if (this.residents.remove(s)) {
      return s;
    } else {
      return null;
    }
  }

  /**
   * Checks if a student is a resident.
   * 
   * @param s The student to check.
   * @return  True if the student is a resident, false otherwise.
   */
  public boolean isResident(Student s) {
    return this.residents.contains(s);
  }

  /**
   * For testing the House class.
   */
  public static void main(String[] args) {
    House chase = new House("Chase House", "1 Paradise Rd", 3, true);
    Student s = new Student("Alex", "000123", 2026);
    chase.moveIn(s);
    System.out.println(chase.isResident(s)); // true
    System.out.println(chase.nResidents());  // 1
    chase.moveOut(s);
    System.out.println(chase.isResident(s)); // false
  }
}