/*
    Introduction to OOP with Java 4th Ed, McGraw-Hill

    Wu/Otani

    Chapter 14 Sample Program: Illustrates the use of JSlider

    File: Ch14JSliderSample.java

*/

import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *  Ch14JListSample class
 *
 * <p>
 * A sample frame to illustrate the use of JSlider.
 * This is a classic example of using three sliders
 * to set the RGB color value.
 */
class Ch14JSliderSample extends JFrame
                           implements ChangeListener {

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
    private static final int FRAME_HEIGHT   = 260;

    /**
     * X coordinate of the frame default origin point
     */
    private static final int FRAME_X_ORIGIN = 150;

    /**
     * Y coordinate of the frame default origin point
     */
    private static final int FRAME_Y_ORIGIN = 250;

    /**
     * Minimum RGB color value
     */
    private static final int MIN_COLOR = 0;

    /**
     * Maximum RGB color value
     */
    private static final int MAX_COLOR = 255;

    /**
     * A slider for the RGB red color
     */
    private JSlider redSlider;

    /**
     * A slider for the RGB green color
     */
    private JSlider greenSlider;

    /**
     * A slider for the RGB blue color
     */
    private JSlider blueSlider;

    /**
     * A panel to show the designated color
     */
    private JPanel colorPanel;

//----------------------------------
//      Main method
//----------------------------------
    public static void main(String[] args) {
        Ch14JSliderSample frame = new Ch14JSliderSample();
        frame.setVisible(true);
    }


//----------------------------------
//    Constructors
//----------------------------------

    /**
     * Default constructor
     */
    public Ch14JSliderSample() {
        Container   contentPane;
        JPanel      sliderPanel;

        //set the frame properties
        setSize      (FRAME_WIDTH, FRAME_HEIGHT);
        setTitle     ("Program Ch14JListSample");
        setLocation  (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);

        contentPane = getContentPane( );
        contentPane.setBackground(Color.white);
        contentPane.setLayout(new BorderLayout());

        //create and place a JList
        sliderPanel = new JPanel(new FlowLayout());
        sliderPanel.setBorder(
                    BorderFactory.createTitledBorder("RGB Color Selection"));

        redSlider = createSlider(MAX_COLOR);
        greenSlider = createSlider(MAX_COLOR);
        blueSlider = createSlider(MAX_COLOR);

        sliderPanel.add(redSlider);
        sliderPanel.add(greenSlider);
        sliderPanel.add(blueSlider);

        colorPanel = new JPanel( );
        colorPanel.setBackground(Color.white);
        colorPanel.setBorder(BorderFactory.createLoweredBevelBorder());
        contentPane.add(colorPanel, BorderLayout.CENTER);
        contentPane.add(sliderPanel, BorderLayout.WEST);

        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation( EXIT_ON_CLOSE );
    }

    public void stateChanged(ChangeEvent event) {

        int R, G, B;

        R = redSlider.getValue();
        G = greenSlider.getValue();
        B = blueSlider.getValue();

        colorPanel.setBackground(new Color(R, G, B));
    }

    /**
     * Creates a JSlider object.
     */
    private JSlider createSlider(int value ) {

        JSlider slider = new JSlider();

        slider.setOrientation(JSlider.VERTICAL);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setMinimum(MIN_COLOR);
        slider.setMaximum(MAX_COLOR);
        slider.setValue(value);
        slider.setMajorTickSpacing(50);
        slider.setMinorTickSpacing(25);

        slider.addChangeListener(this);

        return slider;
    }
}