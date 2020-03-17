/*
    Introduction to OOP with Java 4th Ed, McGraw-Hill

    Wu/Otani

    Chapter 14 Sample Program: Displays a frame with two buttons,
                              and one textfield

    File: Ch14TextFrame2.java

*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *  Ch14TextFrame1 class
 *
 * <p>
 * A sample frame to illustrate the placing of GUI objects and event handling
 * with the Swing JFrame.
 */
class Ch14TextFrame2 extends JFrame implements ActionListener {

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

    /**
     * Default width for buttons
     */
    private static final int BUTTON_WIDTH  = 80;

    /**
     * Default height for buttons
     */
    private static final int BUTTON_HEIGHT = 30;

    /**
     * The Swing button for Cancel
     */
    private JButton cancelButton;


    /**
     * The Swing button for OK
     */
    private JButton okButton;

    /**
     * The JTextField for the user to enter a text
     */
    private JTextField inputLine;
    
    /**
     * The JLabel for prompting the user
     */
    private JLabel prompt;

    /**
     * The JLabel for an image
     */
    private JLabel image;



//----------------------------------
//      Main method
//----------------------------------
    public static void main(String[] args) {
        Ch14TextFrame2 frame = new Ch14TextFrame2();
        frame.setVisible(true);
    }


//----------------------------------
//    Constructors
//----------------------------------

    /**
     * Default constructor
     */
    public Ch14TextFrame2() {
        Container contentPane;

        //set the frame properties
        setSize      (FRAME_WIDTH, FRAME_HEIGHT);
        setResizable (false);
        setTitle     ("Program Ch14TextFrame2");
        setLocation  (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);

        contentPane = getContentPane( );
        contentPane.setLayout(new FlowLayout());
        
        //add two JLabel objects
        image = new JLabel(new ImageIcon("cat.gif"));
        image.setSize(50, 50);
        contentPane.add(image);
        
        prompt = new JLabel( );
        prompt.setText("Please enter your name");
        //alternative way to create the prompt
        //  prompt = new JLabel( "Please enter your name");
        prompt.setSize(150, 25);
        contentPane.add(prompt);

        
        //add the text field
        inputLine = new JTextField();
        inputLine.setColumns(22);
        //inputLine.setFont(new Font("Courier", Font.PLAIN, 14));
        contentPane.add(inputLine);

        inputLine.addActionListener(this);
        
        
        //create and place two buttons on the frame
        okButton = new JButton("OK");
        okButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        contentPane.add(okButton);

        cancelButton = new JButton("CANCEL");
        cancelButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        contentPane.add(cancelButton);

        //register this frame as an action listener of the two buttons
        cancelButton.addActionListener(this);
        okButton.addActionListener(this);

     


        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation( EXIT_ON_CLOSE );
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

        if (event.getSource() instanceof JButton) {
            JButton clickedButton = (JButton) event.getSource();

            String  buttonText = clickedButton.getText();

            setTitle("You clicked " + buttonText);

        } else { //the event source is inputLine
            setTitle("You entered '" + inputLine.getText() + "'");
        }
    }

}