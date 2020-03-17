/*
     Introduction to OOP with Java (Comprehensive Version 1st Ed), McGraw-Hill
    
     Wu/Otani
    
     Chapter 16 Sample Program: Search a list of integers
    
     File: SearchList.java
 */

import java.util.Scanner;

class SearchList {
    
    private Scanner scanner;
    
    private Node start;
    
    public SearchList( ) {
        scanner = new Scanner(System.in);
    }
       
    public static void main(String[] args) {
        
        SearchList program = new SearchList();
        program.start();
    }
        
    public void start( ) {
        
        buildList();
        
        searchList();
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
     * Search the list for a designated number. Reply 'Found' if the
     * searched number is in the list. Otherwise, reply 'Not Found'
     *
     */
    private void searchList() {
        
        Node p;  

        System.out.print("Number to search: ");
        int number = scanner.nextInt();

        p = start;              //'start' points to a linked list

        while (p != null) {

            if (p.getItem() == number) {  //found the node
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
