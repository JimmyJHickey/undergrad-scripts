/*
     Introduction to OOP with Java (Comprehensive Version 1st Ed), McGraw-Hill
    
     Wu/Otani
    
     Chapter 16 Sample Program: Sample class for creating a linked list of objects
    
     File: Bicycle.java
 */
class Bicycle {

    private String ownerName;

    public Bicycle(String name) {
        setOwnerName(name);
    }

    public String getOwnerName( ) {
        return ownerName;
    }

    public void setOwnerName(String name) {
        ownerName = name;
    }
}
