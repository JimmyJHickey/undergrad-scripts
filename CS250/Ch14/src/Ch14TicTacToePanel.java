/*
    Introduction to OOP with Java 4th Ed, McGraw-Hill

    Wu/Otani

    Chapter 7 Sample Program: Tic Tac Toe Board

    File: Ch14TicTacToePanel.java

*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * This class handles the visual display of the Tic-Tac-Toe game.
 *
 * @author Dr. Caffeine
 */
public class Ch14TicTacToePanel extends JPanel implements MouseListener {

//-----------------------------------------
//
//    Data Members:
//
//-----------------------------------------

    /** Keeps track of player turn; true if circle's turn */
    private boolean circle;

//-----------------------------------------
//
//    Constructors:
//
//-----------------------------------------

    /**
     * Default constructor.
     */
    public Ch14TicTacToePanel() {
        this(3);
    }

    /**
     * Creates a panel of N by N cells
     *
     *@param size the dimension of the rows and cols
     */
    public Ch14TicTacToePanel(int size) {

        Ch14TicTacToeCell cell;

        setLayout(new GridLayout(size, size));

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                cell = new Ch14TicTacToeCell( );

                cell.addMouseListener(this);
                add(cell);
            }
        }

        circle = true;
    }


//-----------------------------------------------
//
// Mouse Listener Methods
//
//-----------------------------------------------

    public void mouseClicked(MouseEvent event) {

        Ch14TicTacToeCell cell = (Ch14TicTacToeCell) event.getSource();

        if (circle) {
            cell.setContent(Ch14TicTacToeCell.CIRCLE);
        } else {
            cell.setContent(Ch14TicTacToeCell.CROSS);
        }

        circle = !circle;
    }

    public void mouseEntered   ( MouseEvent event ) { }
    public void mouseExited    ( MouseEvent event ) { }
    public void mousePressed   ( MouseEvent event ) { }
    public void mouseReleased  ( MouseEvent event ) { }


}