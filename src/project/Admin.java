/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

/**
 *
 * @author User
 */
public class Admin extends  Staff { // manages all users
    public Doublelinkedlist userList;

    public Admin(Doublelinkedlist list) {
        this.userList = list;
    }

    public void addUser(User u) {
        userList.addNode(u);
        System.out.println("User added successfully!");
    }

    
    public User searchUser(String id) { // very important for search , for GUI search bar 
        Node temp = userList.head; // start at head 

        while (temp != null) { // traverse till end 
            if (temp.data instanceof User) { //make sure node actually contains a userr
                User usr = (User) temp.data; // cast obj to user

                if (usr.getId().equals(id)) { // check if id matches the search bar id ( entered in text fields in GUI )
                    return usr;
                }
            }
            temp = temp.next;
        }

        return null;
    }

  
    public boolean deleteUser(String id) { // use index based  , like what was done in search , search then use delte node for delte 
        Node temp = userList.head;
        int index = 0;

        while (temp != null) {
            if (temp.data instanceof User) {
                User usr = (User) temp.data;

                if (usr.getId().equals(id)) {
                    userList.deleteNodeAtPosition(index);
                    System.out.println("User deleted!");
                    return true;
                }
            }

            temp = temp.next;
            index++;
        }

        System.out.println("User not found!");
        return false;
    }

  
    public boolean updateUser(String id, String newName, String newEmail, String newPassword) { // update info 

        User usr = searchUser(id); // find user by id 

        if (usr != null) { // if exist 
            if (newName != null && !newName.isEmpty()) usr.setName(newName); // set as new name entered and so on 
            if (newEmail != null && !newEmail.isEmpty()) usr.setEmail(newEmail);
            if (newPassword != null && !newPassword.isEmpty()) usr.setPassword(newPassword);

            System.out.println("User updated!");
            return true;
        }

        System.out.println("User not found!");
        return false;
    }
}
