# P06 Exam Scheduler
Whether you like them or not, evening exams are a reality of the student experience. As you may have noticed, they’re rarely held in the same room as the lecture - scheduling exams is a whole different problem for the administration. I’m not sure if they still do it by hand and call it an art form or whether they’ve got it automated at least a little, but in this project we explored a design for recursively matching courses needing exam rooms with available rooms.
In this program, we created four classes:

● Course, a container for course-related information

● Room, a container for room-related information

● Schedule, an object to maintain the current draft schedule

● ExamScheduler, a collection of static recursive utility methods to help create the Schedule
