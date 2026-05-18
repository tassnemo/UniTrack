/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

/**
 *
 * @author User
 */
public class User {
    protected String id;
    protected String name;
    protected String email;
    protected String password;

    public User() { // empty 
        
    }
    
    public User(String id, String name, String email, String password) { // constructor with variables 
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
//setters and getters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean login(String email, String password) { // login  method 

    //if the email or passward is empty
    if(email == null || password == null || email.isEmpty() || password.isEmpty()){
        System.out.println("Please enter your email and password");
        return false;
    }

    //Matching the email and password with the user
    if(this.email.equals(email) && this.password.equals(password)){
        System.out.println("Welcome"+name+"you have successfully logged in!");
        return true;
    } 
    else {
        System.out.println("Incorrect email or password");
        return false;
    }
}


    public void logout() { // session out 
        System.out.println(name + " logged out successfully.");
    }

    public void displayInfo() {// for admin viwes
        System.out.println("User Information");
        System.out.println("ID:" + id);
        System.out.println("Name:" + name);
        System.out.println("Email:" + email);
        System.out.println("----------------------------");
    }
}
