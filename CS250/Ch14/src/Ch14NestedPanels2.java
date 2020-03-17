/*
    Introduction to OOP with Java 4th Ed, McGraw-Hill

    Wu/Otani

    Chapter 14 Sample Program: Illustration of Nested Panels

    File: Ch14NestedPanels2.java
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Sample interface for the HiLo game using nested panels.
 * This class illustrates the building of user interface only,
 * logic control for actually playing the game is NOT included.
 */
class Ch14NestedPanels2 extends JFrame {

//----------------------------------
//    Data Members
//----------------------------------
    /** Default frame width */
    private static final int FRAME_WIDTH    = 250;

    /** Default frame height */
    private static final int FRAME_HEIGHT   = 270;

    /** X coordinate of the frame default origin point */
    private static final int FRAME_X_ORIGIN = 150;

    /** Y coordinate of the frame default origin point */
    private static final int FRAME_Y_ORIGIN = 250;

    /** Label for the Enter button */
    private final String ENTER = "Enter";

    /** Label for the Cancel button */
    private final String CANCEL = "Cancel";

    /** Constnat for blank string */
    private final String BLANK = "";

    /** Text field for guess entry */
    private JTextField guessEntry;

    /** Label for displying the hint */
    private JLabel     hint;

//----------------------------------
//      Main method
//----------------------------------
    public static void main(String[] args) {
        Ch14NestedPanels2 frame = new Ch14NestedPanels2();
        frame.setVisible(true);
    }

//----------------------------------
//    Constructors
//----------------------------------

    /**
     * Default constructor
     */
    public Ch14NestedPanels2( ) {
        JPanel  guessPanel, hintPanel,
                controlPanel, buttonPanel;

        JButton enterBtn, cancelBtn;

        Container contentPane;

        //set the frame properties
        setSize      (FRAME_WIDTH, FRAME_HEIGHT);
        setTitle     ("Program Ch14NestedPanels2");
        setLocation  (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);

        contentPane = getContentPane( );

        contentPane.setLayout(new GridLayout(3, 1));

        guessPanel = new JPanel();
        guessPanel.setBorder(BorderFactory.createTitledBorder("Your Guess"));
        guessPanel.add(guessEntry = new JTextField(10));

        hintPanel = new JPanel();
        hintPanel.setBorder(BorderFactory.createTitledBorder("Hint"));
        hintPanel.add(hint = new JLabel("Let's Play HiLo"));

        controlPanel = new JPanel(new BorderLayout());
        buttonPanel  = new JPanel();
        buttonPanel.add(enterBtn = new JButton(ENTER));
        buttonPanel.add(cancelBtn = new JButton(CANCEL));
        controlPanel.add(buttonPanel, BorderLayout.SOUTH);

        contentPane.add(guessPanel);
        contentPane.add(hintPanel);
        contentPane.add(controlPanel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}