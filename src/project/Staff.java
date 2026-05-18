/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

/**
 *
 * @author User
 */
public class Staff extends User { // for staff profile screen  , extenduser , take email/name etc 
      private String staffId;
    private String position;   // doctor or admin
    private String department;

    public Staff() {
        
    }
    
    public Staff(String id, String name, String email, String password,
                 String staffId, String position, String department) {
        super(id, name, email, password);  
        this.staffId = staffId;
        this.position = position;
        this.department = department;
    }
//setters and getters
    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void assignTask(String task) { 
        System.out.println("Task '" + task + "' assigned to " + name);
    }

    public void updateSchedule(String schedule) {
        System.out.println(name + "'s schedule updated to: " + schedule);
    }

    @Override
    public void displayInfo() { // override display info to match staff info thast different from normal studets 
        super.displayInfo(); 
        System.out.println("Staff ID: " + staffId);
        System.out.println("Position: " + position);
        System.out.println("Department: " + department);
        System.out.println("----------------------------");
    }
}
