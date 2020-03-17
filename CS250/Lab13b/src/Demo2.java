class Demo2 {

    public static void main(String [] args) {
	
	Y y = new Y(3);
	System.out.println(y.toString());
	Q q = y.getQ();
	q.a++;
	System.out.println(y.toString());
    }
}
