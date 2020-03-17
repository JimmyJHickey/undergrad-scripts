class Demo1 {

    public static void main(String [] args) {
	
	X x = new X(3);
	System.out.println(x.toString());
	 Q q = x.q;
	 q.a++;
	System.out.println(x.toString());
    }
}
