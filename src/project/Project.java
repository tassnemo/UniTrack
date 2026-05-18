/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project;

/**
 *
 * @author User
 */
public class Project {
public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame(); // opening frame 
            frame.setTitle("University Management System"); // setting a title 
            frame.setSize(500, 720); // setting size 
            frame.setLocationRelativeTo(null); // center on screen
            frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
    

