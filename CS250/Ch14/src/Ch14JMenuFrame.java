/*
    Introduction to OOP with Java 4th Ed, McGraw-Hill

    Wu/Otani

    Chapter 14 Sample Program: Displays a frame with two menus

    File: Ch14JMenuFrame.java

*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *   class Ch14JMenuFrame
 *
 *   This frame includes one MenuBar, two Menu objects File and Edit,
 *   and eight MenuItem objects. When a menu item is selected, a string
 *   showing which menu choice is selected will appear on the frame.
 *
 * @author Dr. Caffeine
 */

class Ch14JMenuFrame extends JFrame implements ActionListener
{

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
     * Text shown in response to the menu selection
     */
    private JLabel   response;

    /**
     * File menu group
     */
    private JMenu    fileMenu;

    /**
     * Edi menu group
     */
    private JMenu    editMenu;


//----------------------------------
//      Main method
//----------------------------------
    public static void main(String[] args) {
        Ch14JMenuFrame frame = new Ch14JMenuFrame();
        frame.setVisible(true);
    }

//----------------------------------
//    Constructors
//----------------------------------

    /**
     * Default constructor
     */
    public Ch14JMenuFrame() {
        
        Container contentPane;

        //set the frame properties
        setTitle     ("Ch14JMenuFrame");
        setSize      (FRAME_WIDTH, FRAME_HEIGHT);
        setResizable (false);
        setLocation  (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);


        contentPane = getContentPane( );
        contentPane.setLayout(new FlowLayout());


        //create two menus and their menu items
        createFileMenu();
        createEditMenu();

        //and add them to the menubar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        //create and position reponse label
        response = new JLabel("Hello, this is your menu tester." );
        response.setSize(250, 50);
        contentPane.add(response);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
        String  menuName;

        menuName = event.getActionCommand();

        if (menuName.equals("Quit")) {
           System.exit(0);

        } else {
           response.setText("Menu Item '" + menuName + "' is selected.");
        }
    }


//-------------------------------------------------
//      Private Methods:
//
//          void   createFileMenu   (           )
//          void   createEditMenu   (           )
//
//------------------------------------------------

    /**
     * Create File menu and its menu items
     *
     */
    private void createFileMenu( ) {
        JMenuItem    item;

        fileMenu = new JMenu("File");

        item = new JMenuItem("New");        //New
        item.addActionListener( this );
        fileMenu.add( item );

        item = new JMenuItem("Open...");    //Open...
        item.addActionListener( this );
        fileMenu.add( item );

        item = new JMenuItem("Save");       //Save
        item.addActionListener( this );
        fileMenu.add( item );

        item = new JMenuItem("Save As..."); //Save As...
        item.addActionListener( this );
        fileMenu.add( item );

        fileMenu.addSeparator();           //add a horizontal separator line

        item = new JMenuItem("Quit");       //Quit
        item.addActionListener( this );
        fileMenu.add( item );
    }

    /**
     * Create Edit menu and its menu items
     *
     */
    private void createEditMenu( ) {
        JMenuItem    item;

        editMenu = new JMenu("Edit");

        item = new JMenuItem("Cut");      //Cut
        item.addActionListener( this );
        editMenu.add( item );

        item = new JMenuItem("Copy");    //Copy
        item.addActionListener( this );
        editMenu.add( item );

        item = new JMenuItem("Paste");    //Paste
        item.addActionListener( this );
        editMenu.add( item );
    }

}
