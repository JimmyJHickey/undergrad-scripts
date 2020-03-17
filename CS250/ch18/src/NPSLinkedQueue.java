/*
     Introduction to OOP with Java (Comprehensive Version 1st Ed), McGraw-Hill
    
     Wu/Otani
    
     Chapter 20 Sample Program: The linked-list implementation of the
                                Queue ADT
    
     File: edu/nps/util/NPSLinkedQueue.java
*/

//package edu.nps.util;


public class NPSLinkedQueue<E> implements NPSQueue<E> {
    
//----------------------------------
//  Data Members
//----------------------------------

  /** The pointer to the first node in the queue */
  private QueueNode front;

  /** The pointer to the last node in the queue */
  private QueueNode tail;

  /** The number of elements in the list */
  private int count;

//----------------------------------
//  Constructors
//----------------------------------

  /**
   * Default constructor
   */
  public NPSLinkedQueue(  ) {
      
      clear( );
  }

  /**
   * Adds an element to the queue. Newly added element
   * becomes the last element
   *
   */
  public void add(E item){

      QueueNode newNode = new QueueNode(item);

      if (isEmpty()) {

          front = tail = newNode;
      
      } else {

          tail.next = newNode;
          tail = newNode;
      }

      count++;
  }
  

  /**
   * Removes all elements from the stack.
   *
   */
  public void clear( ) {
      
      front = tail = null;

      count = 0;
  }


  /**
   * Determines whether the queue is empty or not.
   *
   * @return true if the queue is empty; false otherwise.
   */
  public boolean isEmpty( ) {
      
      return (count == 0);
  }


  /**
   * Returns the first element without removing
   * it from the queue.
   *
   * @return the first element without removing
   *         it from the queue.
   *
   * @exception NPSEmptyStructureException thrown when the queue is empty
   */
  public E peek( ) throws NPSQueueEmptyException {
      
      if (isEmpty()) {
          
          throw new NPSQueueEmptyException();

      } else {
          
          return front.item;
      }
  }


  /**
   * Removes the first element in the queue.
   *
   * @return the first element in the queue
   *
   * @exception NPSEmptyStructureException thrown when the queue is empty
   */
  public E remove( ) throws NPSQueueEmptyException {
      
      E item;

      if (isEmpty()) {
          
          throw new NPSQueueEmptyException();
          
      } else {
          
          item = front.item;
          front = front.next;
          count--;
      }

      return item;
  }


  /**
   * Returns the number of elements in the stack
   *
   * @return the number of elements in the stack
   */
  public int size( ) {
      return count;
  }

//-------------------------------------------------
//
//   Inner Class: QueueNode
//
//------------------------------------------------

  class QueueNode {

      private E    item;

      private QueueNode  next;

      public  QueueNode(E item) {
          this.item = item;
          this.next = null;
      }
  }

}
