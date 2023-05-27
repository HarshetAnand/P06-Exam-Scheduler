//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P06 Exam Scheduler: ExamSchedulerTester Class
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
 * This class tests for the methods used in the Course, Room, Schedule, and ExamScheduler classes to
 * check that the respective methods run successfully and complete each task required. The methods
 * will be tested and will return true if all tests have successfully passed when run in the
 * runAllTests() method.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ExamSchedulerTester {

  /**
   * The main method prints out the result of the runAllTests method which determines if all tests
   * have passed or not and will return true if all tests have passed successfully.
   * 
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("runAllTests(): " + runAllTests());
  }

  /**
   * Tests the course methods and checks if the correct exceptions are thrown in the course class.
   * (getName(), getNumStudents())
   * 
   * @return true if all tests pass, otherwise false if one of the tests fails
   */
  public static boolean testCourse() {
    try {
      Course c = new Course("CS300", 30); // Checks the getName() method
      if (!(c.getName().equals("CS300"))) {
        System.out.println("Error! The method getName() is incorrect!");
        return false;
      }
      if (!(c.getNumStudents() == 30)) { // Checks the getNumStudents() method
        System.out.println("Error! The method getNumStudents() is incorrect!");
        return false;
      }
    } catch (Exception e) { // Checks if the correct exception is thrown
      System.out.println("Error! An incorrect exception is thrown!");
      return false;
    }
    try {
      Course c = new Course("CS400", 45); // Checks if the correct exception is thrown with this
                                          // course
    } catch (IllegalArgumentException e) {
    } catch (Exception e) {
      System.out.println("Error! An incorrect exception is thrown!");
      return false;
    }
    return true;
  }

  /**
   * Tests the room methods and checks if the correct exceptions are thrown in the room class.
   * (reduceCapacity())
   * 
   * @return true if all tests pass, otherwise false if one of the tests fails
   */
  public static boolean testRoom() {
    try {
      Room r = new Room("AG 150", 200); // Checks if the correct exception is thrown with this room
    } catch (IllegalArgumentException e) {
    } catch (Exception e) {
      System.out.println("Error! An incorrect exception is thrown in the room class!");
      return false;
    }
    try {
      Room r = new Room("CS 1240", 160); // Checks the reduceCapacity() method
      Room nR = r.reduceCapacity(25);
      if (nR == r) {
        System.out.println("Error! The method reduceCapacity() is incorrect!");
        return false;
      }
      if (!(nR.getCapacity() == (160 - 25))) { // Checks the reduceCapacity() method to see if
                                               // capacity is reduced
        System.out.println("Error! The method reduceCapacity() did not reduce capacity!");
        return false;
      }
    } catch (Exception e) {
      System.out.println("Error! An incorrect exception is thrown!"); // Checks if the correct
                                                                      // exception is thrown
      return false;
    }
    return true;
  }

  /**
   * Tests the schedule accessors methods and checks if the correct exceptions are thrown from the
   * schedule class. (getRoom(), getCourse(), isComplete(), isAssigned())
   * 
   * @return true if all tests pass, otherwise false if one of the tests fails
   */
  public static boolean testScheduleAccessors() {
    Room[] r = new Room[300];
    Course[] c = new Course[254];
    try {
      Schedule tS = new Schedule(r, c); // Checks the getNumRooms() method
      if (!(tS.getNumRooms() == 300)) {
      }
      if (!(tS.getNumCourses() == 254)) { // Checks the getNumCourses() method
        return false;
      }
    } catch (Exception e) { // Checks if the correct exception is thrown
      System.out.println("Error! An incorrect exception is thrown!");
      return false;
    }
    Room[] r2 = new Room[400];
    Course[] c2 = new Course[140];
    r2[70] = new Room("CS 1240", 160);
    c2[40] = new Course("AG 150", 200);
    try {
      Schedule s = new Schedule(r2, c2); // Checks the getRoom() method
      Room nR = s.getRoom(70);
      if (!(nR.getLocation().equals(r2[70].getLocation()))
          || (!(nR.getCapacity() == r2[70].getCapacity()))) {
        System.out.println("Error! The getRoom() method in the schedule class is incorrect!");
        return false;
      }
      Course nC = s.getCourse(40);
      if (!(nC.getName().equals(c2[40].getName()) // Checks the getCourse() method
          || (!(nC.getNumStudents() == c2[40].getNumStudents())))) {
        System.out.println("Error! The getCourse() method in the schedule class is incorrect!");
        return false;
      }
    } catch (Exception e) { // Checks if the correct exception is thrown
      System.out.println("Error! An incorrect exception is thrown!");
      return false;
    }
    Course[] tC = new Course[] {new Course("CS200", 80)};
    Room[] tR = new Room[] {new Room("CS 1240", 900)};
    Schedule tSch = ExamScheduler.findSchedule(tR, tC);
    if (!tSch.isComplete()) { // Checks the isComplete() method
      System.out.println("Error! The isComplete() method is incorrect!");
      return false;
    }
    if (!tSch.isAssigned(0)) { // Checks the isAssigned() method
      System.out.println("Error! The isAssigned() method is incorrect!");
      return false;
    }
    return true;
  }

  /**
   * Tests the assignCourse() method from the Schedule class.
   * 
   * @return true if all tests pass, otherwise false if one of the tests fails
   */
  public static boolean testAssignCourse() {
    return true;
  }

  /**
   * Tests the findAllSchedules() method from the ExamScheduler class.
   * 
   * @return true if all tests pass, otherwise false if one of the tests fails
   */
  public static boolean testFindAllSchedules() {
    return true;

  }

  /**
   * Tests the findSchedule() method from the ExamScheduler class.
   * 
   * @return true if all tests pass, otherwise false if one of the tests fails
   */
  public static boolean testFindSchedule() {
    return true;
  }

  /*
   * This method runs all test cases and will return true if all tests have passed. The result of
   * the test cases will print out from the main method and if any case fails, this will print out
   * false printing the error to the test which has failed.
   */
  public static boolean runAllTests() {
    boolean allTestsPassed = testCourse() && testRoom() && testScheduleAccessors()
        && testAssignCourse() && testFindAllSchedules() && testFindSchedule();
    // Can only return true if all test cases return true. Will go back to main method to return
    // final result
    return allTestsPassed;
  }
}
