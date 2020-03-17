import java.io.*;
import javax.swing.*;

class BytesInAndOut {

    public static void main (String [] args) throws IOException {
        
        // open input stream
        File inFile = new File("message");
        FileInputStream inStream = new FileInputStream(inFile);

        // set up byte array
        int length = (int) inFile.length();
        byte [] bArray = new byte[length];

        
        // read bytes into it and close the file
        inStream.read(bArray);
        inStream.close();

        // open the same file for output
        // finish this code
      for(int i=0;i<bArray.length;i++)
    	  System.out.print((char)(bArray[i]+1));
    	  
    }

}
