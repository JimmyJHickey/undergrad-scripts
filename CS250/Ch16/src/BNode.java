/*
     Introduction to OOP with Java (Comprehensive Version 1st Ed), McGraw-Hill
    
     Wu/Otani
    
     Chapter 16 Sample Program: A linked list node for storing a Bicycle object
    
     File: BNode.java
 */
class BNode {

    private Bicycle  item;

    private BNode  next;

    public BNode( ) {
        this(null, null);
    }

    public BNode(Bicycle data, BNode node) {
        setItem(data);
        setNext(node);
    }

    public Bicycle getItem( ) {
        return item;
    }

    public BNode getNext( ) {
        return next;
    }

    public void setItem(Bicycle data) {
        item = data;
    }

    public void setNext(BNode node) {
        next = node;
    }
}
