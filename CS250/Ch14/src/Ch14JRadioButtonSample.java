/*
    Introduction to OOP with Java 4th Ed, McGraw-Hill

    Wu/Otani

    Chapter 14 Sample Program: Illustrates the use of JRadioButton

    File: Ch14JRadioButtonSample.java

*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *  Ch14JRadioButton class
 *
 * <p>
 * A sample frame to illustrate the use of radio buttons.
 */
class Ch14JRadioButtonSample extends JFrame
                           implements ActionListener,
                                      ItemListener    {

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
     * An array of JCheckBox objects
     */
    private JRadioButton[] radioButton;



//----------------------------------
//      Main method
//----------------------------------
    public static void main(String[] args) {
        Ch14JRadioButtonSample frame = new Ch14JRadioButtonSample();
        frame.setVisible(true);
    }


//----------------------------------
//    Constructors
//----------------------------------

    /**
     * Default constructor
     */
    public Ch14JRadioButtonSample() {
        Container   contentPane;
        JPanel      radioPanel, okPanel;
        ButtonGroup languageGroup;

        JButton     okButton;
        String[]    btnText = {"Java", "C++", "Smalltalk", "Ada"};

        //set the frame properties
        setSize      (FRAME_WIDTH, FRAME_HEIGHT);
        setTitle     ("Program Ch14JRadioButton");
        setLocation  (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);

        contentPane = getContentPane( );
        contentPane.setBackground(Color.white);
        contentPane.setLayout(new BorderLayout());

        //create and place four radio buttons
        radioPanel = new JPanel(new GridLayout(0,1));
        radioPanel.setBorder(BorderFactory.createTitledBorder("Pick your favorite"));

        languageGroup = new ButtonGroup();
        radioButton = new JRadioButton[btnText.length];

        for (int i = 0; i < radioButton.length; i++) {
            radioButton[i] = new JRadioButton(btnText[i]);
            radioButton[i].addItemListener(this);
            languageGroup.add(radioButton[i]);
            radioPanel.add(radioButton[i]);
        }

        radioButton[0].setSelected(true);

        //create and place the OK button
        okPanel = new JPanel(new FlowLayout());
        okButton = new JButton("OK");
        okButton.addActionListener(this);
        okPanel.add(okButton);

        contentPane.add(radioPanel, BorderLayout.CENTER);
        contentPane.add(okPanel, BorderLayout.SOUTH);

        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation( EXIT_ON_CLOSE );
    }

    public void actionPerformed(ActionEvent event) {

        String favorite = null;

        int i = 0;
        while (favorite == null) {
            if (radioButton[i].isSelected()) {
                favorite = radioButton[i].getText();
            }

            i++;
        }

        JOptionPane.showMessageDialog(this, "Your favorite language is " + favorite);
    }

    public void itemStateChanged(ItemEvent event) {

        JRadioButton source = (JRadioButton) event.getSource();

        String state;

        if (event.getStateChange() == ItemEvent.SELECTED) {
            state = "is selected";
        } else {
            state = "is deselected";
        }

        JOptionPane.showMessageDialog(this, "JRadioButton '" +
                                            source.getText() +
                                            "' " + state);
    }
}