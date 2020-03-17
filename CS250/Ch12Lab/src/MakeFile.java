import java.io.*;
import java.beans.*;

class MakeFile implements Serializable {

	public static void main (String [] args) 
                        throws IOException, FileNotFoundException {

	File outFile = new File("objects.dat");
        FileOutputStream outFileStream =
                                   new FileOutputStream(outFile);
        ObjectOutputStream outObjectStream =
                                   new ObjectOutputStream(outFileStream);

        int numObjects = (int)(Math.random() * 1000);
        for (int i = 0; i < numObjects; i++) {
           int n = (int)(Math.random() * 3);
           Object obj;
           if (n == 0)
        	   obj = new Integer(i);
           else if (n == 1)
               obj = new Double(i);
           else
               obj = new MakeFile();
           
           outObjectStream.writeObject(obj);
           }
	

        outObjectStream.close();
        System.out.println(numObjects  + " objects written to file...");
    }

}
