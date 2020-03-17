//package edu.nps.util;

public class NPSArrayQueue<E> implements NPSQueue<E> {

//  ----------------------------------
//  Data Members
//----------------------------------

  /** Default size of the item array */
  private static final int DEFAULT_SIZE = 25;

  /** The array index to the front item in the queue */
  private int front;

  /** The array index to the tail item in the queue */
  private int tail;

  /** The number of elements in the list */
  private int count;

  /** The "circular" array to store queue items */
  private E[] element;

  /**
   * Default constructor
   */
  public NPSArrayQueue(  ) {
      
      this(DEFAULT_SIZE);
  }

  /**
   * Creates a new ArrayQueue with the give size
   *
   * @param size the initial size of the item array
   */
  public NPSArrayQueue(int size) {
      
      if (size <= 0) {
          throw new IllegalArgumentException( 
                     "Initial capacity must be positive");
      }
      
      element = (E[]) new Object[size];

      clear();
  }

  /**
   * Adds an element to the queue. Newly added element
   * becomes the last element
   *
   * @param element an element to add
   *
   */
  public void add(E item) {

      //check if full
      if (count == element.length) {
          expand( );
      }

      element[tail] = item;
      
      tail = (tail + 1) % element.length;
      
      count++;
  }
  
  /**
   * Removes all elements from the queue.
   *
   * Resets the queue to be an empty state.
   */
  public void clear( ) {
      
      for (int i = 0; i < count; i++) { //clears all remaining items
        element[i] = null;
      }
      
      front = tail = count = 0;
  }


  /**
   * Determines whether the queue is empty or not.
   *
   * @return true if the queue is empty; false otherwise.
   */
  public boolean isEmpty(  ) {
      
      return (count == 0);
  }


  /**
   * Returns the first element without removing
   * it from the queue.
   *
   * @return the first element without removing
   *         it from the queue.
   *
   * @exception NPSQueueEmptyException thrown when the queue is empty
   */
  public E peek( ) throws NPSQueueEmptyException {

      if (isEmpty()) {
          
          throw new NPSQueueEmptyException();

      } else {
          
          return element[front];
      }
  }

  /**
   * Removes the first element in the queue.
   *
   * @return the first element in the queue
   *
   * @exception NPSQueueEmptyException thrown when the queue is empty
   */
  public E remove( )  throws NPSQueueEmptyException {

      E item;

      if (isEmpty()) {
          
          throw new NPSQueueEmptyException();
          
      } else {
          
          item = element[front];
          element[front] = null;
          front = (front + 1) % element.length;
          count--;
      }

      return item;
  }

  /**
   * Returns the number of elements in the queue
   *
   * @return the number of elements in the queue
   */
  public int size(   ) {
      return count;
  }


  /**
   * Expands if the item array to handle the
   * overflow condition
   *
   */
  private void expand( ) {
      
      E[] temp = (E[]) new Object[(int) (element.length * 1.5)];
      
      int e_idx = front;
      int t_idx = front;
      
      for (int i = 0; i < count; i++) {
          
          temp[t_idx] = element[e_idx];
          
          t_idx = (t_idx + 1) % temp.length;
          e_idx = (e_idx + 1) % element.length;          
      }
      
      tail = t_idx;
      
      element = temp;
  }
}
