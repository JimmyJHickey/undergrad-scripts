//package edu.nps.util;

public class NPSListQueue<E> implements NPSQueue<E> {
    
    private static final int FRONT = 0;
    
    private NPSList<E> list;
    
    public NPSListQueue( ) {
        
        list = new NPSLinkedList<E>();
    }

    public void add(E item) {
        
        list.add(list.size(), item);
    }

    public void clear() {

        list.clear();
    }

    public boolean isEmpty() {
        
        return list.isEmpty();
    }

    public E peek() throws NPSQueueEmptyException {
        
        if (isEmpty()) {
            
            throw new NPSQueueEmptyException();
            
        } else {
            
            return list.get(FRONT);
        }
    }

    public E remove() throws NPSQueueEmptyException {
        
        if (isEmpty()) {
            
            throw new NPSQueueEmptyException();
            
        } else {
            
            return list.remove(FRONT);
        }
    }

    public int size() {
        
        return list.size();
    }
}
