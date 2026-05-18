/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

/**
 *
 * @author User
 */
public class Student extends User {
private boolean isUndoing = false;
    private String level;
    private String department;
    private double GPA;

    // undo actions history
    private final Stack actionsHistory; // final prevents accidental reassignment 

    // registered courses list
    private final  Doublelinkedlist registeredCourses;

    public Student() {
        super();
        actionsHistory = new Stack();
        registeredCourses = new Doublelinkedlist();
    }

    public Student(String id, String name, String email, String password,
                   String level, String department, double GPA) {

        super(id, name, email, password);

        this.level = level;
        this.department = department;
        this.GPA = GPA;

        this.actionsHistory = new Stack();
        this.registeredCourses = new Doublelinkedlist();
    }

    // ------------ Getters and Setters --------------
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }


  
   public boolean registerCourse(course c) {

    if (registeredCourses.search(c)) {
        System.out.println("You are already registered in this course.");
        return false;
    }

    boolean added = c.addStudent(this);

    if (added) {
        registeredCourses.addNode(c);

        //  save action if not undoing
        if (!isUndoing)
            actionsHistory.push("register:" + c.getCourseID());

        System.out.println("Course registered successfully: " + c.getCourseName());
        return true;
    }
    return false;
}


  public boolean dropCourse(course c) {

    if (!registeredCourses.search(c)) {
        System.out.println("You are not registered in this course.");
        return false;
    }

    boolean removed = c.removeStudent(this);

    if (removed) {

        Node t = registeredCourses.head;
        int index = 0;

        while (t != null) {
            if (t.data.equals(c)) {
                registeredCourses.deleteNodeAtPosition(index);
                break;
            }
            t = t.next;
            index++;
        }

        //  save action if not undoing
        if (!isUndoing)
            actionsHistory.push("drop:" + c.getCourseID());

        System.out.println("Course dropped successfully.");
        return true;
    }
    return false;
}


   
    public void viewSchedule() {
        System.out.println("Your Registered Courses:");

        Node t = registeredCourses.head;

        if (t == null) {
            System.out.println("No courses registered.");
            return;
        }

        while (t != null) {
            course c = (course) t.data;
            System.out.println("- " + c.getCourseID() + " | " + c.getCourseName());
            t = t.next;
        }
    }

public String getScheduleString() { // easier usage for Gui/Optionpane
    if (registeredCourses == null || registeredCourses.isEmpty()) {
        return "";
    }

    StringBuilder sb = new StringBuilder();
    Node current = registeredCourses.head;

    while (current != null) {
        course c = (course) current.data;
        sb.append("• ")
          .append(c.getCourseID())
          .append(" - ")
          .append(c.getCourseName())
          .append("\n");
        current = current.next;
    }

    return sb.toString();
}

        public void undoLastAction() {

    if (actionsHistory.IsEmpty()) {
        System.out.println("No actions to undo.");
        return;
    }

    Node popped = actionsHistory.pop();
    String action = (String) popped.data;

    String[] parts = action.split(":");
    String type = parts[0];
    String courseId = parts[1];

    course target = null;
    Node t = registeredCourses.head;

    while (t != null) {
        course c = (course) t.data;
        if (c.getCourseID().equals(courseId)) {
            target = c;
            break;
        }
        t = t.next;
    }

    isUndoing = true;   //  disable history recording

    if (type.equals("register") && target != null) {
        dropCourse(target);
        System.out.println("Undo done: registration removed.");
    }
    else if (type.equals("drop") && target != null) {
        registerCourse(target);
        System.out.println("Undo done: course added back.");
    }

    isUndoing = false;  //  enable history recording
}
 public void updateInfo(String level, String department, double GPA) { // used by admin not student
        this.level = level;
        this.department = department;
        this.GPA = GPA;
        System.out.println("Student info updated successfully.");
    }
 public boolean hasUndoableActions() { // helper method to avoid touching undo from outside class /encapsulation
    return !actionsHistory.IsEmpty();
}

}