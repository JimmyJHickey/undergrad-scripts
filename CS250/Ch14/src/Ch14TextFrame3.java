/*
    Introduction to OOP with Java 4th Ed, McGraw-Hill

    Wu/Otani

    Chapter 14 Sample Program: Displays a frame with two buttons,
                              one textfield, and one text area.

    File: Ch14TextFrame3.java

*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *  Ch14TextFrame3 class
 *
 * <p>
 * A sample frame to illustrate the placing of GUI objects and event handling
 * with the Swing JFrame.
 */
class Ch14TextFrame3 extends JFrame implements ActionListener {

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
    private static final int FRAME_HEIGHT   = 250;

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
     * Constant for empty string
     */
    private static final String EMPTY_STRING = "";

    /**
     * Constant for platform specific newline
     */
    private static final String NEWLINE = System.getProperty("line.separator");

    /**
     * The Swing button for Cancel
     */
    private JButton clearButton;

    /**
     * The Swing button for OK
     */
    private JButton addButton;

    /**
     * The JTextField for the user to enter a text
     */
    private JTextField inputLine;

    /**
     * The JTextArea for displaying the entered text
     */
    private JTextArea  textArea;



//----------------------------------
//      Main method
//----------------------------------
    public static void main(String[] args) {
        Ch14TextFrame3 frame = new Ch14TextFrame3();
        frame.setVisible(true);
    }


//----------------------------------
//    Constructors
//----------------------------------

    /**
     * Constructor
     */
    public Ch14TextFrame3() {
        Container contentPane;

        //set the frame properties
        setSize      (FRAME_WIDTH, FRAME_HEIGHT);
        setResizable (false);
        setTitle     ("Program Ch14TextFrame3");
        setLocation  (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);

        contentPane = getContentPane( );
        contentPane.setLayout(new FlowLayout());

        
        textArea = new JTextArea();
        textArea.setColumns(22);
        textArea.setRows(8);
        textArea.setBorder(BorderFactory.createLineBorder(Color.red));
        
//---------------------------------------
//  Different types of borders; some borders effective if background color is changed
//
//        textArea.setBorder(BorderFactory.createEtchedBorder(Color.blue, Color.gray));
//        textArea.setBorder(BorderFactory.createLoweredBevelBorder());
//        textArea.setBorder(BorderFactory.createRaisedBevelBorder());
//        textArea.setBorder(BorderFactory.createTitledBorder("JTextArea"));
//
//-------------------------------------

        textArea.setEditable(false);
        contentPane.add(textArea);

//----------------------------------------------------
//      To add scroll bars to the text area
/*
        textArea = new JTextArea();
        textArea.setColumns(22);
        textArea.setRows(8);
        textArea.setEditable(false);
        
        JScrollPane scrollText= new JScrollPane(textArea);
        scrollText.setSize(200, 135);
        scrollText.setBorder(BorderFactory.createLineBorder(Color.red));
        contentPane.add(scrollText);
*/
//------------------------------------------------------
        
        inputLine = new JTextField();
        inputLine.setColumns(22);
        contentPane.add(inputLine);
        inputLine.addActionListener(this);
        
        //create and place two buttons on the frame
        addButton = new JButton("ADD");
        addButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        contentPane.add(addButton);
        addButton.addActionListener(this);
        
        clearButton = new JButton("CLEAR");
        clearButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        contentPane.add(clearButton);
        clearButton.addActionListener(this);
        

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

            if (clickedButton == addButton) {
                addText(inputLine.getText());
            } else {
                clearText( );
            }

        } else { //the event source is inputLine
            addText(inputLine.getText());
        }
    }

    private void addText(String newline) {
        textArea.append(newline + NEWLINE);
        inputLine.setText("");
    }

    private void clearText( ) {
        textArea.setText(EMPTY_STRING);
        inputLine.setText(EMPTY_STRING);
    }

}