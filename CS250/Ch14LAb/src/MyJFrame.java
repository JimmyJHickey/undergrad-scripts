
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

class MyJFrame extends JFrame implements ActionListener{

    // private instance variables
    JButton button;
    int buttonCount;
    JTextField inputLine;
    JLabel label;
    JMenu menu;
    JMenuItem exitItem;
    JMenuItem clearItem;
    
    public static void main (String [] args) {
         
	MyJFrame mine = new MyJFrame();
        mine.setVisible(true);

    }

    public MyJFrame () {

        setTitle ("This is a \"MyJFrame\" object (V5)");
        setSize (300, 500);
        setDefaultCloseOperation( EXIT_ON_CLOSE );

        // get the content pane and set properties
        Container contentPane = getContentPane();
        contentPane.setBackground (Color.blue);
        contentPane.setLayout(null); // so that we can use absolute positioning

        // construct a button, and set the number of click on it to 0
        button = new JButton("0");
        button.setBounds(110,230,80,40);
        button.addActionListener(this);
        contentPane.add(button);
        buttonCount = 0;

        // construct a text field
        inputLine = new JTextField();
        inputLine.setBounds(100,150,100,20);
        inputLine.addActionListener(this);
        contentPane.add(inputLine);
        
        label = new JLabel("Enter a number to update the button");
        contentPane.add(label);
        label.setBounds(25,0,300,200);
        
        menu=new JMenu("Menu");
        clearItem= new JMenuItem("Clear");
        clearItem.addActionListener(this);
        menu.add(clearItem);
        exitItem= new JMenuItem("Exit");
        exitItem.addActionListener(this);
        menu.add(exitItem);
        JMenuBar bar=new JMenuBar();
        setJMenuBar(bar);
        bar.add(menu);
      }

    public void actionPerformed(ActionEvent event) {
    	if(event.getSource()==button)
    	{
    		buttonCount++;
    	}
    	if(event.getSource()==inputLine)
    	{
    		String input = inputLine.getText();
    		buttonCount=Integer.parseInt(input);
    		button.setText(Integer.toString(buttonCount));
    	}
    	if(event.getSource()==exitItem)
    	{
    		System.exit(0);
    	}
    	if(event.getSource()==clearItem)
    	{
    		buttonCount=0;
    		inputLine.setText("");
    	}
    
    	button.setText(Integer.toString(buttonCount));
   }
}
