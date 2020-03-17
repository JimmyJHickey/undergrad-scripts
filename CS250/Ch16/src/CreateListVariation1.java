/*
     Introduction to OOP with Java (Comprehensive Version 1st Ed), McGraw-Hill
    
     Wu/Otani
    
     Chapter 16 Sample Program: Create a Linked List using Variation 1
                                 Use three variables 'start', 'tail', and 'next'
    
     File: CreateListVariation1.java
 */

import java.util.*;

class CreateListVariation1 {
    
    private Scanner scanner;
    
    private Node start;
    
    public CreateListVariation1( ) {
        scanner = new Scanner(System.in);
    }
       
    public static void main(String[] args) {
        
        CreateListVariation1 program = new CreateListVariation1();
        program.start();
    }
        
    public void start( ) {
        
        buildList();
        
        printoutList();
    }
    
    /*
     * This method builds a new linked list of integers using
     * three pointers start, tail, and next
     */
    private void buildList() {

        Node tail, next;

        start = null;

        System.out.print("Number: ");
        
        int number = scanner.nextInt();

        if (number > 0) {

            start = new Node(number, null); // create the first node

            tail = start;

            // get more numbers
            while (true) {
                
                System.out.print("Number: ");
                number = scanner.nextInt();

                if (number <= 0)
                    break;

                next = new Node(number, null); // create a new node

                tail.setNext(next); // link the node as the last node

                tail = next; // set tail point to the new last node
            }
        }
    }
    
    /**
     * This method prints out the content of a list
     * for verifing that the list was created correctly
     *
     */
    private void printoutList() {
        
        Node p = start;
        
        while (p != null) {
            
            System.out.println(p.getItem());
            
            p = p.getNext();
        }       
    }

}
