import java.io.*;
import javax.swing.*;

class TextInAndOut {

    public static void main (String [] args) throws IOException {
        BufferedReader in=new BufferedReader(new FileReader("data"));
    	
        // open file output stream
        File outFile = new File("data");
        FileOutputStream outStream = new FileOutputStream(outFile);
        PrintWriter pWriter = new PrintWriter(outStream);

        // write an int, boolean, double
        pWriter.println("44");
        pWriter.println("true");
        pWriter.println("7.2");
 
        pWriter.close();

        // open file input stream
        File inFile = new File("data");
        FileInputStream inStream = new FileInputStream(inFile);
        DataInputStream inDataStream = new DataInputStream(inStream);
        
        String str;
        // read an int, boolean, double
        str = in.readLine();
        int n =  Integer.parseInt(str);
        str = in.readLine();
        boolean b = Boolean.parseBoolean(str);
        str = in.readLine();
        double d = Double.parseDouble(str);

        inDataStream.close();
        in.close();

        // what did we get?
        System.out.println("n = " + n);
        System.out.println("b = " + b);
        System.out.println("d = " + d);

        // can we add n to d?
        System.out.println("n + d = " + (n+d));

    }

}
