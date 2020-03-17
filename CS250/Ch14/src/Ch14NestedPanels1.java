/*
    Introduction to OOP with Java 4th Ed, McGraw-Hill

    Wu/Otani

    Chapter 14 Sample Program: Illustrates the use of
                              nested panels

    File: Ch14NestedPanels1.java

*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A sample frame to illustrate the placing of nested panels.
 * This class illustrates the building of user interface only,
 * logic control for actually playing the game is NOT included.
 */
class Ch14NestedPanels1 extends JFrame {

//----------------------------------
//    Data Members
//----------------------------------

    /**
     * Default frame width
     */
    private static final int FRAME_WIDTH    = 500;

    /**
     * Default frame height
     */
    private static final int FRAME_HEIGHT   = 350;

    /**
     * X coordinate of the frame default origin point
     */
    private static final int FRAME_X_ORIGIN = 150;

    /**
     * Y coordinate of the frame default origin point
     */
    private static final int FRAME_Y_ORIGIN = 250;


//----------------------------------
//      Main method
//----------------------------------
    public static void main(String[] args) {
        Ch14NestedPanels1 frame = new Ch14NestedPanels1();
        frame.setVisible(true);
    }


//----------------------------------
//    Constructors
//----------------------------------

    /**
     * Default constructor
     */
    public Ch14NestedPanels1() {
        Container         contentPane;
        Ch14TicTacToePanel gamePanel;
        JPanel            controlPanel;
        JPanel            scorePanel;

        //set the frame properties
        setSize      (FRAME_WIDTH, FRAME_HEIGHT);
        setTitle     ("Program Ch14NestedPanels1");
        setLocation  (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);

        contentPane = getContentPane( );
        contentPane.setLayout(new BorderLayout(10, 0));

        gamePanel = new Ch14TicTacToePanel();
        gamePanel.setBorder(BorderFactory.createLoweredBevelBorder());
        controlPanel = new JPanel();
        controlPanel.setLayout(new BorderLayout( ));

        contentPane.add(gamePanel, BorderLayout.CENTER);
        contentPane.add(controlPanel, BorderLayout.EAST);

        scorePanel = new JPanel();
        scorePanel.setBorder( BorderFactory.createTitledBorder("Scores:"));
        scorePanel.setLayout(new GridLayout(2, 2));
        scorePanel.add(new JLabel("Player 1:"));
        scorePanel.add(new JLabel("     0"));
        scorePanel.add(new JLabel("Player 2:"));
        scorePanel.add(new JLabel("     0"));

        controlPanel.add(scorePanel,BorderLayout.NORTH);
        controlPanel.add(new JButton("New Game"), BorderLayout.SOUTH);

        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation( EXIT_ON_CLOSE );
    }

}