/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

/**
 *
 * @author User
 */
public class Stack {

    Node tail = null;

    public boolean push(Object d) { // can push anything 
        Node nd = new Node(d);
        if (nd != null) {
            nd.prev = tail;
            tail = nd;
            return true;
        }
        return false;
    }

    public Node pop() {
        Node nd = tail;
        if (tail != null) {
            tail = tail.prev;
        }
        return nd;
    }

    public boolean IsEmpty() {
        return (tail == null);
    }
}
