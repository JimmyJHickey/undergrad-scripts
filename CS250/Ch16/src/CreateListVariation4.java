/*
     Introduction to OOP with Java (Comprehensive Version 1st Ed), McGraw-Hill
    
     Wu/Otani
    
     Chapter 16 Sample Program: Create a Linked List using Variation 4
                                Creating a linked list of N nodes
                                by adding new nodes to the front of the list
    
     File: CreateListVariation4.java
 */

import java.util.*;

class CreateListVariation4 {
    
    private Scanner scanner;
    
    private Node start;
    private Node start2;
    
    public CreateListVariation4( ) {
        scanner = new Scanner(System.in);
    }
       
    public static void main(String[] args) {
        
        CreateListVariation4 program = new CreateListVariation4();
        program.start();
    }
        
    public void start( ) {
        
        buildList();
        reverse();
        printoutList();
    }
    
    /*
     * This method builds a new linked list of integers using
     * three pointers start and tail
     */
    private void buildList() {

        Node temp;

        start = null;

        // input numbers
        while (true) {

            System.out.print("Number: ");
            int number = scanner.nextInt();

            if (number <= 0)
                break;

            temp = start; // remember the current front

            start = new Node(number, temp); // add the new front
                                            // node and set its link
                                            //point to the old front              
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
    
    private void reverse(){
    	int n;
    	Node temp, pointer;
    	start2 = null;
    	pointer = start;
    	
    	while(pointer!=null){
    		n=(pointer.getItem());
    		pointer=pointer.getNext();
    	if(pointer==null){
    		break;}
    	else{
    		temp=start2;
    		start2 = new Node(n, temp);
    	}
    	}
    	}
    }


