/*
    Introduction to OOP with Java 4th Ed, McGraw-Hill

    Wu/Otani

    Chapter 14 Sample Program: Event listener for button click events

    File: ButtonHandler.java

*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A sample handler for processing action events of buttons.
 */
class ButtonHandler implements ActionListener {



//----------------------------------
//    Constructors
//----------------------------------

    /**
     * Default constructor
     */
    public ButtonHandler() {

    }

//-------------------------------------------------
//      Public Methods:
//
//          void    actionPerformed   (   ActionEvent        )
//
//------------------------------------------------

    /**
     * Standard method to respond the action event.
     *
     * @param event the ActionEvent object
     *
     */
    public void actionPerformed(ActionEvent event) {

        JButton clickedButton = (JButton) event.getSource();

        JRootPane rootPane = clickedButton.getRootPane( );
        Frame     frame    = (JFrame) rootPane.getParent();

        // JFrame frame = (JFrame) clickedButton.getRootPane().getParent();

        String  buttonText = clickedButton.getText();

        frame.setTitle("You clicked " + buttonText);
    }

}
