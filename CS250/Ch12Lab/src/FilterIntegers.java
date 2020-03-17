import java.io.*;

public class FilterIntegers {

    public static void main (String [] args)
                           throws IOException, ClassNotFoundException {

        File inFile = new File("objects.dat");
        FileInputStream inFileStream = new FileInputStream(inFile);
        ObjectInputStream inObjectStream = new ObjectInputStream(inFileStream);

        int count = 0;
        try {
            while (true) {
            	if (inObjectStream.readObject() instanceof java.lang.Integer)
            			count++;
            	
	    }
	} catch (EOFException e) {
            System.out.println("Done reading file... " + 
                                       count + " Integers found");
            inObjectStream.close();
	}
     
    }

}
