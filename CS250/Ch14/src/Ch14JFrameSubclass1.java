/*
    Introduction to OOP with Java 4th Ed, McGraw-Hill

    Wu/Otani

    Chapter 14 Sample Program: A simple subclass of JFrame

    File: Ch14JFrameSubclass1.java

*/

import javax.swing.*;

/**
 * A sample frame to illustrate the inheritance mechanism of Java.
 */
class Ch14JFrameSubclass1 extends JFrame {

//----------------------------------
//    Data Members
//----------------------------------

    /**
     * Default frame width
     */
    private static final int FRAME_WIDTH    = 300;

    /**
     * Default frame height
     */
    private static final int FRAME_HEIGHT   = 200;

    /**
     * X coordinate of the frame default origin point
     */
    private static final int FRAME_X_ORIGIN = 150;

    /**
     * Y coordinate of the frame default origin point
     */
    private static final int FRAME_Y_ORIGIN = 250;


//----------------------------------
//    Constructors
//----------------------------------

    /**
     * Default constructor
     */
    public Ch14JFrameSubclass1( ) {

        //set the frame default properties
        setTitle     ( "My First Subclass" );
        setSize      ( FRAME_WIDTH, FRAME_HEIGHT );
        setLocation  ( FRAME_X_ORIGIN, FRAME_Y_ORIGIN );

        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation( EXIT_ON_CLOSE );

   }

}