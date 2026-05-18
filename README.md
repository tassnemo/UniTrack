# UniTrack 
A Java-based university management system built with NetBeans and Java Swing.

## About
A desktop application that manages students, doctors, and courses within a university.
The system supports three types of users each with their own dashboard and permissions.

## Student
- Register for courses by Course ID
- Drop courses
- View personal schedule (all registered courses)
- Undo last action (register or drop) using a Stack
- Logout

##  Doctor
- View all assigned courses with enrollment count
- View list of students enrolled in a specific course
- Logout

##  Admin
- Add new users and courses
- Update existing users and courses
- Delete users
- View every user and info(students, doctors,courses,admins)
- Search for users and courses
- Logout

##  System Features
- Role-based login that directs each user to their own dashboard
- Duplicate ID checking on registration
- Course capacity enforcement
- Undo functionality powered by a custom Stack

##  Data Structures Used
- Double Linked List : stores users, courses, and enrolled students
- Stack : used for undo functionality in student actions

##  How to Run
- Make sure you have NetBeans IDE and Java JDK installed
- Clone or download the repo
- Open the project in NetBeans
- Run `Project.java` it launches the main application window
- use "A001" and "admin123" as admin ID and Password
