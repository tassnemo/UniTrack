/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

/**
 *
 * @author User
 */
public class course {
    
    private String CourseID ,CourseName ;
    private Doctor doctor ;
    private int maxStudent;
    private Doublelinkedlist enrolledStudents ;
    public course(){
        this.enrolledStudents = new Doublelinkedlist();
    }
    public course (String CourseID , String CourseName , Doctor doctor , int maxStudent){
        this(); // calls the empty constructor 
        this.CourseID = CourseID ;
        this.CourseName = CourseName ;
        this.doctor = doctor;
        this.maxStudent = maxStudent ;
    }
//setters and getters
    public void setCourseID(String CourseID) {
        this.CourseID = CourseID;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setMaxStudent(int maxStudent) {
        this.maxStudent = maxStudent;
    }

    public String getCourseID() {
        return CourseID;
    }

    public String getCourseName() {
        return CourseName;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public int getMaxStudent() {
        return maxStudent;
    }

    public Doublelinkedlist getEnrolledStudents() { //print students
        return enrolledStudents;
    }
    
    public boolean addStudent(Student s){ // capacity check 
        if( enrolledStudents.count()< maxStudent){
            enrolledStudents.addNode(s);
            return true;//added
        }
       else {
           return false;// course full
       }
    }
    
    public boolean removeStudent(Student s){ // searches then deletes
        Node n = enrolledStudents.head;
        int pos = 0;
        while (n!= null){
            if(n.data.equals(s)){
                enrolledStudents.deleteNodeAtPosition(pos);
                return true;
            }
            n = n.next;
            pos++;   
        }
        return false;
    }
    
    public boolean updateCourse(String name, Doctor Doctor, int max) {
        if (maxStudent >= enrolledStudents.count()) { 
            this.CourseName = name;
            this.doctor = Doctor;
            this.maxStudent = max;
            return true;
        } 
        return false; 
    }
}
