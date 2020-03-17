/*
     Introduction to OOP with Java (Comprehensive Version 1st Ed), McGraw-Hill
    
     Wu/Otani
    
     Chapter 16 Sample Program: Create a Linked List using Variation 3
                                Creating a linked list of N nodes
                                using a temporary dummy first node
    
     File: CreateListVariation3.java
 */

import java.util.*;

class CreateListVariation3 {
    
    private Scanner scanner;
    
    private Node start;
    
    public CreateListVariation3( ) {
        scanner = new Scanner(System.in);
    }
       
    public static void main(String[] args) {
        
        CreateListVariation3 program = new CreateListVariation3();
        program.start();
    }
        
    public void start( ) {
        
        buildList();
        
        printoutList();
    }
    
    /*
     * This method builds a new linked list of integers using
     * three pointers start and tail
     */
    private void buildList() {

        Node tail;

        start = new Node(0, null); //create a dummy first node
        tail = start;

        // input numbers
        while (true) {
            
            System.out.print("Number: ");
            int number = scanner.nextInt();

            if (number <= 0) break;

            tail.setNext(new Node(number, null)); 
                                //create a new node and link it
                                //the current last node

            tail = tail.getNext(); //move 'tail' the new last node  
        }

        start = start.getNext(); //make 'start' point to the real
                                 //first node
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
