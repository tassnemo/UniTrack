/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

/**
 *
 * @author User
 */
public class Doctor extends Staff {
     public String specialization;
    public  Doublelinkedlist teachingCourses; 

    public Doctor() { // to ensure everything is initialized properly , especially linkedlist
        super();
        teachingCourses = new Doublelinkedlist();
    }

    public Doctor(String id, String name, String email, String password,
                  String staffId, String position, String department,
                  String specialization) {

        super(id, name, email, password, staffId, position, department);
        this.specialization = specialization;
        this.teachingCourses = new Doublelinkedlist();
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    
    public void addCourse(course c) { //adding a course by adding a node to the list
    if (teachingCourses.addNode(c)) {
        System.out.println("Course " + c.getCourseID() + " added to Doctor " + name);
    }
}


  
  public void removeCourse(course c) { // remove course at found index
    Node t = teachingCourses.head;
    int index = 0;

    while (t != null) {
        if (t.data.equals(c)) {
            teachingCourses.deleteNodeAtPosition(index);
            System.out.println("Course " + c.getCourseID() + " removed.");
            return;
        }
        t = t.next;
        index++;
    }

    System.out.println("Course not found.");
}

    
    public void printCourses() { // like a dashboard 
        System.out.println("Doctor " + name + " Courses:");
        Node t = teachingCourses.head;

        if (t == null) {
            System.out.println("No Courses Assigned.");
            return;
        }

        while (t != null) {
            System.out.println("Course ID: " + t.data);
            t = t.next;
        }
    }

    public void updateInfo(String specialization) {
        this.specialization = specialization;
        System.out.println("Doctor info updated.");
    }

}
