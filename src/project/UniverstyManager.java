/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

/**
 *
 * @author User
 */
public class UniverstyManager { // the channel with GUI 
      private final Doublelinkedlist students;   
      private final Doublelinkedlist doctors;    
      private final  Doublelinkedlist courses;   
      private final Doublelinkedlist staff;     //we made them private to make data more secure 
      
public UniverstyManager() { //constructor
        students = new Doublelinkedlist();  //create a new double linked list instance and name it student to store student data
        doctors = new Doublelinkedlist();
        courses = new Doublelinkedlist();
        staff = new Doublelinkedlist();
    }
//getters
    public Doublelinkedlist getStudents() {
        return students;
    }
    public Doublelinkedlist getDoctors() {
        return doctors;
    }
    public Doublelinkedlist getCourses() {
        return courses;
    }
    public Doublelinkedlist getStaff() {
        return staff;
    }

//add methods
 public void addStudent(Student s) {
        students.addNode(s);
        System.out.println("Student added successfully!");
    }

    public void addDoctor(Doctor d) {
        doctors.addNode(d);
        System.out.println("Doctor added successfully!");
    }

    public void addCourse(course c) {
        courses.addNode(c);
        System.out.println("Course added successfully!");
    }

    public void addStaff(Staff s) {
        staff.addNode(s);
        System.out.println("Staff added successfully!");
    }
    //delete methods
    public boolean deleteStudent(String id) {
    Node temp = students.head;
    int pos = 0;

    while (temp != null) { // iterates thru list searches then deletes 
        Student s = (Student) temp.data; //casting
        if (s.getId().equals(id)) {
            students.deleteNodeAtPosition(pos);
            System.out.println("Student deleted!");
            return true;
        }
        temp = temp.next;
        pos++;
    }
    System.out.println("Student not found!");
    return false;
}

public boolean deleteDoctor(String id) { // same as with student 
    Node temp = doctors.head;
    int pos = 0;

    while (temp != null) {
        Doctor d = (Doctor) temp.data;
        if (d.getId().equals(id)) {
            doctors.deleteNodeAtPosition(pos);
            System.out.println("Doctor deleted!");
            return true;
        }
        temp = temp.next;
        pos++;
    }
    System.out.println("Doctor not found!");
    return false;
}

public boolean deleteCourse(String id) {
    Node temp = courses.head;
    int pos = 0;

    while (temp != null) {
        course c = (course) temp.data;
        if (c.getCourseID().equals(id)) {
            courses.deleteNodeAtPosition(pos);
            System.out.println("Course deleted!");
            return true;
        }
        temp = temp.next;
        pos++;
    }
    System.out.println("Course not found!");
    return false;
}

public boolean deleteStaff(String id) {
    Node temp = staff.head;
    int pos = 0;

    while (temp != null) {
        Staff s = (Staff) temp.data;
        if (s.getStaffId().equals(id)) {
            staff.deleteNodeAtPosition(pos);
            System.out.println("Staff deleted!");
            return true;
        }
        temp = temp.next;
        pos++;
    }
    System.out.println("Staff not found!");
    return false;
}
//search methods
public Student searchStudent(String id) {
    Node temp = students.head;
    while (temp != null) {
        Student s = (Student) temp.data;
        if (s.getId().equals(id)) return s;  // Use .equals() for Strings becuase it checks the actual string inside 
        temp = temp.next;
    }
    return null;
}

public Doctor searchDoctor(String id) {
    Node temp = doctors.head;
    while (temp != null) {
        Doctor d = (Doctor) temp.data;
        if (id.equals(d.getId())) return d;
        temp = temp.next;
    }
    return null;
}


public course searchCourse(String id) {
    Node temp = courses.head;
    while (temp != null) {
        course c = (course) temp.data;
        if (c.getCourseID().equals(id)) return c;
        temp = temp.next;
    }
    return null;
}

public Staff searchStaff(String id) {
    Node temp = staff.head;
    while (temp != null) {
        Staff s = (Staff) temp.data;
        if (id.equals(s.getStaffId())) {  
            return s;
        }
        temp = temp.next;
    }
    return null;
}

//update methods
public boolean updateStudent(String id, String level, String department, double GPA) {
    Student s = searchStudent(id);
    if (s != null) { // srudent found by id 
        s.updateInfo(level, department, GPA);
        return true;
    }
    System.out.println("Student not found!");
    return false;
}

public boolean updateDoctorSpecialization(String id, String specialization) {
    Doctor d = searchDoctor(id);
    if (d != null) {
        d.updateInfo(specialization);
        return true;
    }
    System.out.println("Doctor not found!");
    return false;
}

public boolean updateCourse(String id, String name, Doctor doctor, int max) {
    course c = searchCourse(id);
    if (c != null) {
        boolean updated = c.updateCourse(name, doctor, max);
        if (updated) System.out.println("Course updated!");
        else System.out.println("Cannot update course, max students exceeded!");
        return updated;
    }
    System.out.println("Course not found!");
    return false;
}
//display methods
public void displayAllStudents() { // basically iterates thru lists 
        Node temp = students.head;
        System.out.println("\n--- All Students ---");
        while (temp != null) {
            Student s = (Student) temp.data;
            s.displayInfo();
            temp = temp.next;
        }
    }

    public void displayAllDoctors() {
        Node temp = doctors.head;
        System.out.println("\n--- All Doctors ---");
        while (temp != null) {
            Doctor d = (Doctor) temp.data;
            d.displayInfo();
            temp = temp.next;
        }
    }

    public void displayAllCourses() {
        Node temp = courses.head;
        System.out.println("\n--- All Courses ---");
        while (temp != null) {
            course c = (course) temp.data;
            System.out.println(c.getCourseID() + " - " + c.getCourseName());
            temp = temp.next;
        }
    }

    public void displayAllStaff() {
        Node temp = staff.head;
        System.out.println("\n--- All Staff ---");
        while (temp != null) {
            Staff s = (Staff) temp.data;
            s.displayInfo();
            temp = temp.next;
        }
    }  
}
