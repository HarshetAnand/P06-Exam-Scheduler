//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P06 Exam Scheduler: Room Class
// Course: CS 300 Spring 2022
//
// Author: Harshet Anand
// Email: hanand2@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Ahan Nair
// Partner Email: nair27@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X_ Write-up states that pair programming is allowed for this assignment.
// _X_ We have both read and understand the course Pair Programming Policy.
// _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This is a class which contains methods which operate on the Room type.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Room {
  private String location; // the building and room number, e.g. Noland 168
  private int capacity; // the maximum number of people who can be in the room at a time

  /**
   * This constructor intializes the data fields to the values of the arguments.
   * 
   * @param roomLocation the location of the room
   * @param roomCapacity the capacity of the room
   * @throws IllegalArgumentException if the provided integer is negative (<0) with a descriptive
   *                                  error message
   */
  public Room(String roomLocation, int roomCapacity) throws IllegalArgumentException {
    if (!(roomCapacity < 0)) {
      this.location = roomLocation;
      this.capacity = roomCapacity;
    } else {
      throw new IllegalArgumentException("Error! Room capacity is less than zero!");
    }
  }

  /**
   * This method gets the location of the specific room to be used for the course.
   * 
   * @return the location of this room
   */
  public String getLocation() {
    return this.location;
  }

  /**
   * This method gets the capacity of the specific room to be used for the course.
   * 
   * @return the capacity of this room
   */
  public int getCapacity() {
    return this.capacity;
  }

  /**
   * This method gets a new room object with the same location as the original room. However, this
   * capacity is less than this one's by the argument's amount. For example, if Room r has a
   * capacity of 10, calling r.reduceCapacity(3) will return a new Room object with the same
   * location as r but a capacity of 7.
   * 
   * @param reducedBy the amount the capacity will be reduced by
   * @return a new room object with the same location but new capacity which has been reduced
   * @throws IllegalArgumentException if argument is greater than the given Room's capacity with a
   *                                  descriptive error message
   */
  public Room reduceCapacity(int reducedBy) throws IllegalArgumentException {
    if (reducedBy > this.capacity) {
      throw new IllegalArgumentException(
          "Error! The reductive value is greater than the room's capacity!");
    } else {
      int newCapacity = capacity - reducedBy;
      Room r = new Room(location, newCapacity);
      return r;
    }
  }
}
