/*
     Introduction to OOP with Java (Comprehensive Version 1st Ed), McGraw-Hill
    
     Wu/Otani
    
     Chapter 16 Sample Program: Removes a node from a list of integers
    
     File: RemoveNodeFromList.java
 */

import java.util.Scanner;

class RemoveNodeFromList {
    
    private Scanner scanner;
    
    private Node start;
    
    public RemoveNodeFromList( ) {
        scanner = new Scanner(System.in);
    }
       
    public static void main(String[] args) {
        
        RemoveNodeFromList program = new RemoveNodeFromList();
        program.start();
    }
        
    public void start( ) {
        
        buildList();
        
        searchList(); //make sure node X is in the list
        
        removeNode(); //delete node X
        
        searchList(); //seach again for X and verify it is not there anymore
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

        System.out.print("Search for: ");
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
    
    private void removeNode() {
        
        
        Node prev, del;  //del points to the node to remove
                          //prev points to the previous node                

        System.out.print("Number to remove: ");
        int number = scanner.nextInt();

        del = start;                //we assume start points to a linked list
        prev = null;

        while (del != null && number != del.getItem()) {

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
