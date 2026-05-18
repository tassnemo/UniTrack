/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

/**
 *
 * @author User
 */
public class Node { // building block for the data structures (stack,dll)
    public Object data;    
    public Node next;    
    public Node prev;    

    public Node(Object data) { // because system stores different types 
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
