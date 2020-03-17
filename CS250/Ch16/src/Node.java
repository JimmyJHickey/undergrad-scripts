/*
    Introduction to OOP with Java (Comprehensive Version 1st Ed), McGraw-Hill

    Wu/Otani

    Chapter 16 Sample Program: Linked List Node

    File: Node.java
*/

class Node {

    private int item;

    private Node next;

    public Node( ) {
        this(0, null);
    }

    public Node(int data, Node node) {
        setItem(data);
        setNext(node);
    }

    public int getItem( ) {
        return item;
    }

    public Node getNext( ) {
        return next;
    }

    public void setItem(int data) {
        item = data;
    }

    public void setNext(Node node) {
        next = node;
    }
}