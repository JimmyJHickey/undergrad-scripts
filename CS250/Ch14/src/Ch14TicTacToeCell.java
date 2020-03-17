/*
    Introduction to OOP with Java 4th Ed, McGraw-Hill

    Wu/Otani

    Chapter 14 Sample Program: Tic Tac Toe

    File: Ch14TicTacToeCell.java

*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class handles the interface portion of the Tic-Tac-Toe game.
 *
 * @author Dr. Caffeine
 */
public class Ch14TicTacToeCell extends JPanel  {

//-----------------------------------------
//
//    Data Members:
//
//-----------------------------------------

    /** Constant for the empty cell */
    public static final int BLANK  = 0;

    /** Constant for Cirle occupying the cell */
    public static final int CIRCLE = 1;

    /** Constant for Cross occupying the cell */
    public static final int CROSS  = 2;

    /** The image file of the cross */
    private static final String CROSS_IMAGE_FILE = "cross.gif";

    /** The image file of the circle */
    private static final String CIRCLE_IMAGE_FILE = "circle.gif";

    /** The image file of a blank */
    private static final String BLANK_IMAGE_FILE  = "blank.gif";

    /** Label object occuping this JPanel */
    private JLabel content;

    /** Location of this cell in the board */
    private Point location;


//-----------------------------------------
//
//    Constructors:
//
//-----------------------------------------

    /**
     * Default constructor.
     */
    public Ch14TicTacToeCell( ) {
        this(null);
    }

    /**
     * Construct a cell with a given position
     *
     * @param pt the position of this cell on the board
     */
    public Ch14TicTacToeCell(Point pt ) {

        ImageIcon initImage = new ImageIcon("blank.gif");

        setLayout(new BorderLayout());
        setBackground(Color.white);
        setBorder(BorderFactory.createLineBorder(Color.black));

        content = new JLabel(initImage);
        add(content);

        location = pt;
    }

    /**
     * Returns its location.
     *
     * @return this cell's location in the board
     */
    public Point getPosition( ) {
        return location;
    }

    /**
     * Changes the content to the designated image
     *
     * @param image the shape to occupy the content
     */
    public void setContent(int image) {

        switch (image) {

            case CIRCLE: content.setIcon(new ImageIcon(CIRCLE_IMAGE_FILE));
                         break;

            case CROSS:  content.setIcon(new ImageIcon(CROSS_IMAGE_FILE));
                         break;

            default:     //do nothing
                         break;
        }
    }
}