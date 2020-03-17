public class Demo {

    private String target;
    private int loc;

    public Demo(String t) {
	target = t;
	loc = 0;
    }

    public boolean hasMoreChars() {
	return (target != null) && (loc < target.length());
    }

    public char peekChar() throws Exception {
	if (!hasMoreChars())
	    throw new Exception("No characters available");
	return target.charAt(loc);
    }

    public char nextChar() throws Exception {
	char ch = peekChar();
	loc++;
	// System.out.println("... next char is " + ch);
	return ch;
    }

    public void match(char want) throws Exception 	{
	char got = nextChar();
	if (want != got)
	    throw new Exception("Wanted "+want+" but got "+got);
    }

    public void parse() throws Exception {
    	int a_count=0;
    	int b_count=0;
    	char match;
        	
        while(hasMoreChars()){
        	match = nextChar();
        	 if (match == 'a') {	
                 if (b_count > 0)
                     throw new Exception("a's occur after b's");
                 a_count++;
        	 }
        	 else if(match == 'b')
        		 b_count++;
        	 else
        		 throw new Exception("not a nor b");
    		}
    	
        }
	
   
    public void checkAB() {
	try {
	    parse();
	    if (hasMoreChars())
		System.out.println(target + ": Parse error");
	    else
		System.out.println(target + ": OK");
	} catch (Exception e) {
	    System.out.println(target + ": " + e);
	}
    }
	
    public static void main(String [] args) {
	for (int i=0 ; i< args.length ; i++) {
	    Demo d = new Demo(args[i]);
	    d.checkAB();
	}
    }
}
	
