/* This is a stub for the Library class */

import java.util.Hashtable;
import java.util.Set;
import java.util.Iterator;

public class Library extends Building implements LibraryRequirements{
  
  private Hashtable<String, Boolean> collection;

  /**
   * Constructor for library building
   * @param name of the library
   * @param address of the library
   * @param nFloors is the number of floors of the library
   */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }

  
  /**
   * add a book (title) to the library
   * @param title is the title to add to the collection
   */
  public void addTitle(String title){
    this.collection.put(title, true);
  }

  /**
   * remove a book (title) from the library. Will send an error if the title doesn't exist in the collection
   * @param title is the title to remove
   * @return the title to remove
   */
  public String removeTitle(String title){
    if (this.collection.get(title)) {
        this.collection.remove(title, true);
        return title;
    } else if (this.collection.get(title) == false){
      return (title + " is checked out. please check the title in before removing.");
    } else {
      throw new RuntimeException("this title does not exist in the collection");
    }
    
  } 

  /**
   * checkout a title from the library-- changes boolean value in hashtable to false
   * @param title is the title to checkout
   */
  public void checkOut(String title){
    if (this.collection.get(title)) {
        this.collection.replace(title, false);
    } else {
      throw new RuntimeException("Could not be checked out. Title is either already checked out or does not exist in the collection.");
    }
  }

  /**
   * return a book that has been checked out already-- changes boolean value in hashtable to true
   * returns an error if the book has already been returned or if it doesn't exist in the collection
   * @param title is the title to return
   */
  public void returnBook(String title){
    if (this.collection.containsKey(title) & this.collection.get(title)== false) {
        this.collection.replace(title, true);
    } else {
      throw new RuntimeException("Could not be returned. Title is either already returned or does not exist in the collection.");
    }
  }

  /**
   * check if a title is in the collection
   * @param title to check if it exists in the collection
   * @return true or false depending on whether it exists or not
   */
  public boolean containsTitle(String title){
    if (this.collection.containsKey(title)){
      return true;
    } else{
      return false;
    }
  }

  /**
   * check if a title is in the collection and available to be checked out
   * @param title to check if it available
   * @return true or false depending on whether it is available
   */
  public boolean isAvailable(String title){
    if (this.containsTitle(title) & this.collection.get(title)) {
      return true;
    } else {
      return false;
    }
  }


  public void printCollection(){
    System.out.println("The titles in the collection are: ");
    //create a set of the keys (titles) and values (booleans for checked out status)
    Set<String> titleSet = this.collection.keySet(); //I used an online source for this
    Object[] arr = titleSet.toArray();
    for (Object obj:arr) {
      Boolean a = this.collection.get(obj);
      System.out.println(obj + ", checked in?:" + a);
    }
  }

  public static void main(String[] args) {
    Library myLibrary = new Library("Neilson", "1 Chapin way, Northampton", 4);
    myLibrary.addTitle("Very Hungry Caterpillar"); myLibrary.addTitle("Harry Potter");
    myLibrary.printCollection();
  }
  
  }