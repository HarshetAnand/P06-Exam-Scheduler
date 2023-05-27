//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P06 Exam Scheduler: Course Class
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
 * This is a class that contains methods to operate on the Course type.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Course {

  private String name; // name of the course
  private int numStudents; // number of students enrolled in the course

  /**
   * This constructor initializes the data fields to the values of the arguments.
   * 
   * @param nameOfCourse  the name of the course
   * @param numOfStudents the number of students in the course
   * @throws IllegalArgumentException if provided integer is negative (<0) with a descriptive error
   *                                  message
   */
  public Course(String nameOfCourse, int numOfStudents) throws IllegalArgumentException {
    if (!(numOfStudents < 0)) {
      this.name = nameOfCourse;
      this.numStudents = numOfStudents;
    } else {
      throw new IllegalArgumentException("Error! Number of students is less than 0!");
    }
  }

  /**
   * This method gets the name of the specific course.
   * 
   * @return the name of this course
   */
  public String getName() {
    return this.name;
  }

  /**
   * This method obtains the number of students enrolled in the specific course.
   * 
   * @return the number of students enrolled in this course
   */
  public int getNumStudents() {
    return this.numStudents;
  }
}
