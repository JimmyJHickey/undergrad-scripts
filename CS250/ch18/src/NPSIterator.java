/*
     Introduction to OOP with Java (Comprehensive Version 1st Ed), McGraw-Hill
    
     Wu/Otani
    
     Chapter 18 Sample Program: Java Interface for the Iterator pattern
    
     File: edu/nps/util/NPSIterator.java
*/

//package edu.nps.util;

public interface NPSIterator<E> {
    
    public boolean hasNext();
    
    public E next() throws NPSNoSuchElementException;

}
