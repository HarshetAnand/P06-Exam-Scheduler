//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P06 Exam Scheduler: ExamScheduler Class
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
 * This is a class that contains methods to find the ideal schedule for exams.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class ExamScheduler {

  /**
   * This method obtains a valid schedule for the given set of rooms and courses. The method
   * contains a call to the helper method, providing an empty starting schedule.
   * 
   * @param allRooms   the set of rooms used within the schedule
   * @param allCourses the set of courses to be assigned within the schedule
   * @return a valid schedule for the given set of rooms and courses
   * @throws IllegalStateException if no such schedule exists
   */
  public static Schedule findSchedule(Room[] allRooms, Course[] allCourses)
      throws IllegalStateException {
    Schedule sch = new Schedule(allRooms, allCourses);
    return findScheduleHelper(sch, 0);
  }

  /**
   * This private recursive method assigns all unassigned courses in a schedule beginning from the
   * index provided as an argument.
   * 
   * @param schedule the schedule on which the method operates
   * @param sIndex   the index of the course to be checked agains the schedule
   * @return schedule if the provided index is equal to the number of courses and is complete. If
   *         the provided index corresponds to a course that has already been assigned to a room and
   *         recursively assign the courses at the following indexes, returns resulting schedule. If
   *         the course has not already been assigned to a room, it iterates through the loop and
   *         will be assigned to a valid room at the following indexes.
   * @throws IllegalStateException if schedule is invalid with descriptive error message
   */
  private static Schedule findScheduleHelper(Schedule schedule, int sIndex)
      throws IllegalStateException {
    if (sIndex == schedule.getNumCourses()) {
      if (schedule.isComplete()) {
        return schedule;
      }
      throw new IllegalStateException("Error! The schedule is not valid!");
    }
    if (schedule.isAssigned(sIndex)) {
      return findScheduleHelper(schedule, sIndex + 1);
    } else {
      for (int i = 0; i < schedule.getNumRooms(); i++) {
        try {
          Schedule createSchedule = schedule.assignCourse(sIndex, i);
          return findScheduleHelper(createSchedule, sIndex + 1);
        } catch (Exception e) {
          System.out.println(e);
        }
      }
      throw new IllegalStateException("Error! The schedules is not valid!");
    }
  }

  /**
   * This method contains an ArrayList which contains all the possible schedules for the given set
   * of rooms and courses where if none can be created, the ArrayList is empty. This method contains
   * a call to the helper method, providing an empty starting schedule.
   * 
   * @param arrayOfRooms   all rooms that can be used within the schedule in the ArrayList
   * @param arrayOfCourses all courses that can be assigned a room within the schedule in the
   *                       ArrayList
   * @return an ArrayList containing all possible Schedules for the given set of rooms and courses
   */
  public static ArrayList<Schedule> findAllSchedules(Room[] arrayOfRooms, Course[] arrayOfCourses) {
    Schedule sch = new Schedule(arrayOfRooms, arrayOfCourses);
    return findAllSchedulesHelper(sch, 0);
  }

  /**
   * This private recursive method assigns all unassigned courses in a schedule in every possible
   * way, beginning from the inex provided as an argument.
   * 
   * @param schedule the schedule on which the method operates
   * @param sIndex   the index of the course to be checked agains the schedule
   * @return ArrayList (sch) if the provided index is equal to the number of courses and schedule is
   *         complete. If the provided index corresponds to a course that has already been assigned
   *         to a room, recursively add all possible valid schedules to an ArrayList of Schedules
   *         and returns this ArrayList. If the provided index corresponds to a course that has not
   *         already been assigned to a room, iteratively try to assign it to each possible valid
   *         Room and returns this ArrayList.
   */
  private static ArrayList<Schedule> findAllSchedulesHelper(Schedule schedule, int sIndex) {
    ArrayList<Schedule> sch = new ArrayList<Schedule>();
    if (sIndex == schedule.getNumCourses()) {
      if (schedule.isComplete()) {
        sch.add(schedule);
        return sch;
      }
    }
    if (schedule.isAssigned(sIndex)) {
      sch.addAll(findAllSchedulesHelper(schedule, sIndex + 1));
      return sch;
    } else {
      for (int i = 0; i < schedule.getNumRooms(); i++) {
        try {
          Schedule newSchedule = schedule.assignCourse(sIndex, i);
          sch.addAll(findAllSchedulesHelper(newSchedule, sIndex + 1));
        } catch (Exception e) {
          System.out.println(e);
        }
      }
      return sch;
    }
  }
}

