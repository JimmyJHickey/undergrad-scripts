/*
     Introduction to OOP with Java (Comprehensive Version 1st Ed), McGraw-Hill
    
     Wu/Otani
    
     Chapter 16 Sample Program: Create a Linked List of Bicycle objects
                                 Use three variables 'start', 'tail', and 'next'
    
     File: CreateBicycleList.java
 */

import java.util.Scanner;

public class CreateBicycleList {
    
 private Scanner scanner;
    
    private BNode start;
    
    public CreateBicycleList( ) {
        scanner = new Scanner(System.in);
    }
       
    public static void main(String[] args) {
        
        CreateBicycleList program = new CreateBicycleList();
        program.start();
    }
        
    public void start( ) {
        
        buildList();
        
        printoutList();
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
    private void printoutList() {
        
        BNode p = start;
        
        while (p != null) {
            
            Bicycle b = p.getItem();
            
            System.out.println(b.getOwnerName());
            
            p = p.getNext();
        }       
    }

}
