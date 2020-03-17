/*
     Introduction to OOP with Java (Comprehensive Version 1st Ed), McGraw-Hill
    
     Wu/Otani
    
     Chapter 16 Sample Program: Search a Linked List of Bicycle objects
    
     File: CreateBicycleList.java
 */

import java.util.Scanner;

public class SearchBicycleList {
    
 private Scanner scanner;
    
    private BNode start;
    
    public SearchBicycleList( ) {
        scanner = new Scanner(System.in);
    }
       
    public static void main(String[] args) {
        
        SearchBicycleList program = new SearchBicycleList();
        program.start();
    }
        
    public void start( ) {
        
        buildList();
        
        searchList();
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

}
