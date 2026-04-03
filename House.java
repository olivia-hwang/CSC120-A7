/* This is a stub for the House class */
import java.util.ArrayList;

public class House extends Building implements HouseRequirements{

  private ArrayList<Student> residents;
  private boolean hasDiningRoom;


  /**
   * Constructor for House building
   * @param name for the name of the House (e.g. Parsons)
   * @param address for the address of the House
   * @param nFloors for the number of floors for the house (e.g. 4)
   */
  public House(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = false; //used generated code suggestion because i forgot the format for initializing variables
    System.out.println("You have built a house: 🏠");
  }

  /**
   * checks whether the house has a dining room or not
   * @return a boolean for whether the house has a dining room
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  /**
   * returns the number of residents in the house
   * @return the length of the list of residents
   */
  public int nResidents(){
    return this.residents.size();
  }

  /**
   * Adds the Student s to the list of residents
   * @param s is the student to add to the residents list
   */
  public void moveIn(Student s){
    this.residents.add(s);
  }

  /**
   * removes Student s from the list of residents
   * @param s is the students to remove from the list
   * @return the student to remove
   */
  public Student moveOut(Student s){
    if (this.residents.contains(s)) {
        this.residents.remove(s);  
        return s;
    }
    else {
      throw new RuntimeException("Student does not live in " + this.name);
    }
  }

  /**
   * checks if Student s is in the resident list for a house
   * @param s is the student to check for
   * @return boolean for whether the student is a resident
   */
  public boolean isResident(Student s){
    return this.residents.contains(s); //used code completion tool to understand an error
  }


  public static void main(String[] args) {
    House cutter = new House("Cutter", "10 Prospect St, Northampton MA", 3);
    Student jane = new Student("Jane", "x123", 2026);
    Student amy = new Student("amy", "x124", 2027);
    cutter.moveIn(jane); cutter.moveIn(amy);
    System.out.println(cutter.nResidents());
    System.out.println(cutter.isResident(amy));
  }

}