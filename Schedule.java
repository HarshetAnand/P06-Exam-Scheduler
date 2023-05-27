//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P06 Exam Scheduler: Schedule Class
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

/*
 * Class that contains methods which allow the user to traverse the schedule.
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Schedule {
  private Room[] rooms; // an array of the Room objects available for exams
  private Course[] courses; // an array of the Course objects which require exam rooms
  private int[] assignments; // an array where the integer at index N is the index of the room that
                             // course[N] has been assigned to

  /**
   * This constructor intializes the rooms and courses arrays to the provided values, and creates
   * and assignments array of the correct length where all values are -1, indicating that the
   * corresponding course has not yet been assigned a room.
   * 
   * @param arrayOfRooms   an array of rooms which includes the rooms for each course to be assigned
   *                       to
   * @param arrayOfCourses an array of courses which will be intialized to -1 to indicate that the
   *                       course has not been assigned a room
   */
  public Schedule(Room[] arrayOfRooms, Course[] arrayOfCourses) {
    this.rooms = arrayOfRooms;
    this.courses = arrayOfCourses;
    this.assignments = new int[arrayOfCourses.length];
    for (int i = 0; i < assignments.length; i++) {
      this.assignments[i] = -1;
    }
  }

  /**
   * This private constructor initializes the rooms and courses arrays to the provided values and
   * assignments to the provided assignments array. We assume the assignments array is the correct
   * length
   * 
   * @param arrayOfRooms       an array of rooms which the rooms for each course tobe assigned to
   * @param arrayOfCourses     an array of courses which will later on be assigned to their rooms
   * @param arrayOfAssignments an array of assignments which will indicate which course is assigned
   *                           to which room
   */
  private Schedule(Room[] arrayOfRooms, Course[] arrayOfCourses, int[] arrayOfAssignments) {
    this.rooms = arrayOfRooms;
    this.courses = arrayOfCourses;
    this.assignments = arrayOfAssignments;
  }

  /**
   * This method provides the number of rooms available in this schedule.
   * 
   * @return the number of rooms available in this schedule
   */
  public int getNumRooms() {
    return this.rooms.length;
  }

  /**
   * This method returns the room object at the given index in the rooms array by checking if the
   * given index is valid before returning the object.
   * 
   * @param roomIndex the index of the room to be found
   * @return the Room object at the given index in the rooms array
   * @throws IndexOutOfBoundsException if the given index is less than zero or greater than the room
   *                                   length with a descriptive error message
   */
  public Room getRoom(int roomIndex) throws IndexOutOfBoundsException {
    if (!(roomIndex < 0 || roomIndex >= rooms.length)) {
      Room r = this.rooms[roomIndex];
      return r;
    } else {
      throw new IndexOutOfBoundsException("Error! Room index is invalid!");
    }
  }

  /**
   * This method provides the number of courses in this schedule.
   * 
   * @return the number of courses in this schedule
   */
  public int getNumCourses() {
    return this.courses.length;
  }

  /**
   * This method gets the course object at the given index in the courses array by checking if the
   * given index is valid before returning the object.
   * 
   * @param courseIndex the index of the course to be found
   * @return the Course object at the given index in the courses array
   * @throws IndexOutOfBoundsException if the given index is less than zero or greater than the
   *                                   course length with a descriptive error message
   */
  public Course getCourse(int courseIndex) throws IndexOutOfBoundsException {
    if (!(courseIndex < 0 || courseIndex >= courses.length)) {
      Course c = this.courses[courseIndex];
      return c;
    } else {
      throw new IndexOutOfBoundsException("Error! Course index is invalid!");
    }
  }

  /**
   * This method checks if the course at the given index has been assigned a room and if so, will
   * not return -1.
   * 
   * @param courseAssigned course used to check if the specific course has been assigned
   * @return true if and only if the course at the given index has been assigned a room; false
   *         otherwise
   */
  public boolean isAssigned(int courseAssigned) {
    return (this.assignments[courseAssigned] != -1);
  }

  /**
   * This method gets the room object assigned to the course at the given index by checking if the
   * course has been assigned a room.
   * 
   * @param courseIndex used to compare and see if course has been assigned a room or is valid
   * @return the Room object assigned to the course at the given index
   * @throws IllegalArgumentException  if the course has not been assigned a room
   * @throws IndexOutOfBoundsException if the given course index is invalid
   */
  public Room getAssignment(int courseIndex)
      throws IllegalArgumentException, IndexOutOfBoundsException {
    try {
      if (this.assignments[courseIndex] == -1) {
        throw new IllegalArgumentException("Error! The course does not have a room!");
      }
      return this.rooms[this.assignments[courseIndex]];
    } catch (IndexOutOfBoundsException e) {
      throw new IndexOutOfBoundsException("Error! Course index is invalid!");
    }
  }

  /**
   * This method checks if all the courses have been assigned a room using a for loop and going
   * through all the courses and if so, will return true.
   * 
   * @return true if and only if all courses have been assigned to rooms; false otherwise
   */
  public boolean isComplete() {
    for (int i = 0; i < assignments.length; i++) {
      if (this.assignments[i] == -1) {
        return false;
      }
    }
    return true;
  }

  /**
   * This method obtains a new schedule object with the course at the first argument index assigned
   * to the room at the second argument index.
   * 
   * @param nCourse the course to be assigned to the room
   * @param nRoom   the room to be assigned
   * @return a new Schedule object with the course at the first argument index assigned to the room
   *         at the second argument index
   * @throws IllegalArgumentException  if the given course has already been assigned a room, or if
   *                                   the room does not have sufficient capacity.
   * @throws IndexOutOfBoundsException if the given course or room index is invalid
   */
  public Schedule assignCourse(int nCourse, int nRoom)
      throws IllegalArgumentException, IndexOutOfBoundsException {
    if (courses.length - 1 < nCourse || rooms.length - 1 < nRoom || nCourse < 0 || nRoom < 0) {
      throw new IndexOutOfBoundsException();
    }
    if (!(assignments[nCourse] == -1)) {
      throw new IllegalArgumentException();
    }
    Room[] nRoomsIndex = Arrays.copyOf(rooms, rooms.length);
    int[] nAssignmentsIndex = Arrays.copyOf(assignments, assignments.length);
    Room nRoomIndex = rooms[nRoom].reduceCapacity(courses[nCourse].getNumStudents());
    nRoomsIndex[nRoom] = nRoomIndex;
    nAssignmentsIndex[nCourse] = nRoom;
    return new Schedule(nRoomsIndex, courses, nAssignmentsIndex);
  }

  /**
   * This method is overidden to create a String representation where the courses and the rooms are
   * formatted correctly.
   * 
   * @return the format of the string including the name of the courses and the location of the
   *         rooms
   */
  @Override
  public String toString() {
    String format = "{";
    for (int i = 0; i < courses.length; i++) {
      if (isAssigned(i) == true) {
        format = format + this.courses[i].getName() + ": Unassigned, ";
      } else {
        format = format + this.courses[i].getName() + ": "
            + this.rooms[assignments[i]].getLocation() + ", ";
      }
    }
    format = format.substring(0, format.lastIndexOf(", "));
    return format + "}";
  }
}


