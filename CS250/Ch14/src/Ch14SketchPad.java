/*
    Introduction to OOP with Java 4th Ed, McGraw-Hill

    Wu/Otani

    Chapter 14 Sample Program: My SketchPad

    File: Ch14SketchPad.java

*/

/**
 *  Ch14SketchPad
 *
 *  This class implements the SketchPad class from Chapter 2.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Ch14SketchPad extends JFrame
                        implements MouseListener, MouseMotionListener {

//----------------------------------
//    Data Members
//----------------------------------

    /**
     * Default frame width
     */
    private static final int FRAME_WIDTH    = 450;

    /**
     * Default frame height
     */
    private static final int FRAME_HEIGHT   = 300;

    /**
     * X coordinate of the frame default origin point
     */
    private static final int FRAME_X_ORIGIN = 150;

    /**
     * Y coordinate of the frame default origin point
     */
    private static final int FRAME_Y_ORIGIN = 250;

    /**
     * Last x position of the mouse dragging
     */
    private int last_x;

    /**
     * Last y position of the mouse dragging
     */
    private int last_y;


//----------------------------------
//      Main method
//----------------------------------
    public static void main(String[] args) {
        Ch14SketchPad frame = new Ch14SketchPad();
        frame.setVisible(true);
    }

//--------------------------------
//  Constructor
//--------------------------------
    public Ch14SketchPad( ) {
        //set frame properties
        setTitle    ("Chapter 14 SketchPad");
        setSize     ( FRAME_WIDTH, FRAME_HEIGHT );
        setResizable( false );
        setLocation ( FRAME_X_ORIGIN, FRAME_Y_ORIGIN );

        //to change the background color, do
        //
        // ((JPanel)getContentPane()).setBackground(Color.white);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        last_x = last_y = 0;

        addMouseListener( this );       //adds itself as mouse and
        addMouseMotionListener( this ); //mouse motion listener
    }

//--------------------------------
//  Mouse Event Handling
//--------------------------------

    public void mousePressed( MouseEvent event ) {
        int x = event.getX();
        int y = event.getY();

        if ( event.isMetaDown() ) {
            //the right mouse button is pressed, so erase the contents
            Graphics    g = getGraphics();
            Rectangle   r = getBounds();
            g.clearRect(0, 0, r.width, r.height);
            g.dispose();
        } else {
            //the left mouse button is pressed,
            //remember the starting point of a new mouse drag
            last_x = x;
            last_y = y;
        }
    }

    public void mouseClicked ( MouseEvent event ) { }
    public void mouseEntered ( MouseEvent event ) { }
    public void mouseExited  ( MouseEvent event ) { }
    public void mouseReleased( MouseEvent event ) { }


//--------------------------------
//  Mouse Motion Event Handling
//--------------------------------

    public void mouseDragged( MouseEvent event ) {
        int x = event.getX();
        int y = event.getY();

        if ( !event.isMetaDown() ) {
            //don’t process the right button drag
            Graphics g = getGraphics();

            g.drawLine(last_x, last_y, x, y);
            g.dispose();

            last_x = x;
            last_y = y;
        }
    }

    public void mouseMoved ( MouseEvent event ) { }
}