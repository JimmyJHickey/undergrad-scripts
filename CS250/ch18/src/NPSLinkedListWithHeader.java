/*
     Introduction to OOP with Java (Comprehensive Version 1st Ed), McGraw-Hill
    
     Wu/Otani
    
     Chapter 18 Sample Program: Linked-list implementation of the List ADT
                                with a dummy header node
    
     File: edu/nps/util/NPSLinkedListWithHeader.java
*/
//package edu.nps.util;

public class NPSLinkedListWithHeader<E> implements NPSList<E> {
    
    
    public static final int NOT_FOUND = -1;

    private ListNode head;

    private ListNode tail;

    private int count;


    public NPSLinkedListWithHeader(  ) {
        
        ListNode headNode = new ListNode(null);

        head    = headNode;
        tail    = headNode;

        count   = 0;
    }


    public void add(E item) {
        
        //creates a new ListNode
        ListNode newNode = new ListNode(item);

        tail.next = newNode;
        tail = newNode;

        count++;
    }


    public void add(int index, E item) throws IndexOutOfBoundsException {
        
        checkInsertPosition(index);
        
        ListNode ptr = head;

        ListNode newNode = new ListNode(item);

        for (int i = 0; i < index; i++) {
            ptr = ptr.next;
        }

        newNode.next = ptr.next;
        ptr.next     = newNode;

        //adjust tail if the new node added is
        //the last node in the list
        if (index == count) {
            tail = newNode;
        }

        count++;
    }

    
    public void clear(  ) {
        
        head.next = null; //don’t remove the dummy head node
        tail = head;

        count = 0;
    }

    public boolean contains(E item) {
        
        boolean result = true;

        int loc  = indexOf(item);

        if (loc == NOT_FOUND) {
            result = false;
        }

        return result;
    }
    
    public E get(int index) {
        
        checkAccessPosition(index);
        
        ListNode ptr = head.next;

        for (int i = 0; i < index; i++) {
            ptr = ptr.next;
        }

        return ptr.item;
    }

    public int indexOf(E item) {
        
        int loc = 0;

        ListNode ptr = head.next;

        while ( loc < count && !ptr.item.equals( item ) ) {
            loc++;
            ptr = ptr.next;
        }

        if (loc == count) {
            loc = NOT_FOUND;
        }

        return loc;
    }

    public NPSIterator<E> iterator( ) {
        return new MyIterator();
    }
    
    
    public boolean isEmpty(  ) {
        
        return (count == 0);
    }

    public E remove(int index) throws IndexOutOfBoundsException {
        
        checkAccessPosition(index);

        ListNode deleteNode;
        
        ListNode trail = head;

        for (int i = 0; i <= index; i++) {
            trail = trail.next;
        }
       
        deleteNode = trail.next;
        trail.next = deleteNode.next;
       
        if (deleteNode.next == null) { //very last node was removed
            tail = trail;              //so set tail to the new last node
        }

        count--;
        
        return deleteNode.item;        
    }


    public boolean remove(E item) {
        
        boolean result = false;

        ListNode ptr   = head.next;
        ListNode trail = head;

        while (ptr != null && !ptr.item.equals(item)) {

            trail = ptr;
            ptr   = ptr.next;
        }

        if (ptr != null) {
            trail.next = ptr.next;
            
            if (trail.next == null){ //very last node was removed
                 tail = trail;       //we have a new last node
            }
            
            result = true;
            
            count--;
        }
        
        return result;
    }
    

    public E set( int index, E item  ) {
        
        checkAccessPosition(index);
        
        ListNode ptr = head.next;

        for (int i = 0; i < index; i++) {
            ptr = ptr.next;
        }
        
        E old = ptr.item;

        ptr.item = item;
        
        return old;
    }
    
    
    public int size(  ) {
        
        return count;
    }
    
    /**
     * Checks the passed index position is a valid index that refers
     * to a non-empty position
     *
     * @param index  value to check for valid position
     * 
     * @exception IndexOutOfBoundsException if the passed index
     *              is outside of the range of valid access positions
     */
    private void checkAccessPosition(int index) {

        if (size() == 0) {
            
            throw new IndexOutOfBoundsException(
                        "Index " + index + " is invalid. List is empty.");
                
        } else if (index < 0) {
            
            throw new IndexOutOfBoundsException(
                        "Negative index of " + index + " is invalid");    
                                                              
        } else if (index > size()-1) {
            
            throw new IndexOutOfBoundsException(index +  
                        " is larger than valid upper bound" + (size()-1));
        }
    }
    
    
    /**
     * Checks the passed index position is a valid insertion point in 
     * the array.
     *
     * @param index   value to check for insertion position
     *
     * @exception IndexOutOfBoundsException if the passed index
     *              is outside of the range of valid insertion positions
     */
    private void checkInsertPosition(int index) {

        if (index < 0) {
            
            throw new IndexOutOfBoundsException(
                        "Negative index of " + index + " is invalid");    
                                                              
        } else if (index > size()) {
            
            throw new IndexOutOfBoundsException(index +  
                        " is larger than valid upper bound" + size());
        }
    }   
    
//  Inner Class: ListNode

    class ListNode {

        private E  item;

        private ListNode next;

        public ListNode(E item) {
            this.item = item;
            this.next = null;
        }
    }
    
//  /---------- Inner Class :  MyIterator -------------////
    private class MyIterator implements NPSIterator<E> {
        
        private ListNode current;
        
        public MyIterator( ) {
            current = head.next;           
        }
        
        public boolean hasNext( ) {
            
            return (current != null);
        }
        
        public E next( ) throws NPSNoSuchElementException {
            
            if (current == null) {
                throw new NPSNoSuchElementException();
                
            } else {
                
                E item = current.item;
                current = current.next;
                
                return item;
            }           
        }
    }
}

