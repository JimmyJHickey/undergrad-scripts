/*
     Introduction to OOP with Java (Comprehensive Version 1st Ed), McGraw-Hill
    
     Wu/Otani
    
     Chapter 16 Sample Program: Remove a node from
                                a Linked List of Bicycle objects
    
     File: RemoveNodeFromBicycleList.java
 */

import java.util.Scanner;

class RemoveNodeFromBicycleList {
    
 private Scanner scanner;
    
    private BNode start;
    
    public RemoveNodeFromBicycleList( ) {
        scanner = new Scanner(System.in);
    }
       
    public static void main(String[] args) {
        
        RemoveNodeFromBicycleList program = new RemoveNodeFromBicycleList();
        program.start();
    }
        
    public void start( ) {
        
        buildList();
        
        searchList(); //make sure node X is in the list
        
        removeNode(); //delete node X
        
        searchList(); //seach again for X and verify it is not there anymore
    }
    
    /*
     * This method builds a new linked list of Bicycle objects using
     * three pointers start, tail, and next
     */
    private void buildList() {

        BNode tail, next;

        start = null;

        System.out.print("Owner name: ");
        String name = scanner.next();

        if (!name.equalsIgnoreCase("QUIT")) {

            start = new BNode(new Bicycle(name), null); 
                                                //create the first node

            tail = start;

            //get more names
            while (true) {
                
                System.out.print("Owner name: ");
                name = scanner.next();

                if (name.equalsIgnoreCase("QUIT")) break;

                next = new BNode(new Bicycle(name), null); 
                                                //create a new node

                tail.setNext(next); //link the node as the last node

                tail = next; //set tail point to the new last node
            }
        }
    }
    
    /**
     * This method prints out the content of a list
     * for verifing that the list was created correctly
     *
     */
    private void searchList() {
        
        BNode p;     

        System.out.print("\nSearch for: ");
        String searchName = scanner.next();

        p = start;              //we assume start points to a linked list

        while (p != null) {

            String name = p.getItem().getOwnerName();

            if (name.equals(searchName)) {  //found the node
                break;
            }

            p = p.getNext();    //move p to the next node
        }

        if (p != null) {

            System.out.println("Found");

        } else {

            System.out.println("Not Found"); 
        }      
    }
    
    private void removeNode( ) {
       

        BNode prev, del;     //del points to the node to remove
                          //prev points to the previous node                

        System.out.print("Owner name of the bicycle to remove: ");
        String searchName = scanner.next();

        del = start;                //we assume start points to a linked list
        prev = null;

        while (del != null) {
            
            if (del.getItem().getOwnerName().equals(searchName)) {
                break; //found the node
            }

            prev = del;                 //move the two pointers forward 

            del = del.getNext();    
        }

        if (del == null) {

            System.out.println("Delete Node Not Found");

        } else {

            if (del == start) { 

                start = start.getNext(); //remove the first node

            } else {

                prev.setNext(del.getNext()); 
                                //sets the next field of prev to
                             //the next field of del
            }        
        }      
    }
}
