/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

/**
 *
 * @author User
 */
public class Doublelinkedlist {
    Node head;
    Node tail;

    public boolean addNode(Object d){ // add at end , used for add buttons
        boolean added = false;
        Node nd = new Node(d);
        
        if(nd != null){
            if(head == null){
                head = nd;
                tail = nd;
            } else {
                tail.next = nd;
                nd.prev = tail;
                tail = nd;
            }
            added = true;
        }
        return added; 
    }

    public boolean insertNode(Object d, int loc){ // insert at index
        boolean inserted = false;
        Node nd = new Node(d);
        
        if(nd != null){ 
            inserted = true;
            
            if(head == null){
                head = tail = nd;
            }
            else{
                if(loc == 0){
                    nd.next = head;
                    head.prev = nd;
                    head = nd;
                }
                else{
                    Node temp = head;
                    for(int i = 0; i < loc - 1 && temp != null; i++){
                        temp = temp.next;
                    }
                    if(temp == tail || temp == null){
                        tail.next = nd;
                        nd.prev = tail;
                        tail = nd;
                    }
                    else{
                        temp.next.prev = nd;
                        nd.next = temp.next;
                        nd.prev = temp;
                        temp.next = nd;
                    }
                }
            }
        }
        return inserted;
    }

    public int count() {
        int c = 0;
        Node t = head;
        while (t != null) {
            c++;
            t = t.next;
        }
        return c;
    }

    void deleteNodeAtPosition(int pos) { 
        if (head == null) return;

        if (pos < 0 || pos >= count()) {
            System.out.println("invalid pos");
            return;
        }

        if (pos == 0) {
            head = head.next;
            if (head == null) {
                tail = null;
                return;
            }
            head.prev = null;
            return;
        }

        if (pos == count() - 1) {
            tail = tail.prev;
            if(tail != null)
                tail.next = null;
            return;
        }

        int i = 0;
        Node t = head;
        while (i < pos) {
            t = t.next;
            i++;
        }
        Node s = t.prev;
        Node p = t.next;
        s.next = p;
        p.prev = s;
    }

    public boolean search(Object x) { // check if exist
        Node t = head;
        while (t != null) {
        
            if (t.data.equals(x)) {
                return true;
            }

            t = t.next;
        }
        return false;
    }
    public boolean isEmpty() {
    return head == null;
}

}
