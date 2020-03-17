public class recursion {	
	public static long summation(long number)
	{
		long sum=0;
		if (number==1)
			return 1;
		if (number==-1)
			return -1;
		if (number==0)
			return 0;
		if(number>1)
			sum=summation(number-1)+number;
		if(number<1)
			sum=summation(number+1)+number;
		return sum;
	}
	
	public static long factorial(long number)
	{
		if (number==1)
			return 1;
		if (number==0)
			return 1;
		if(number<0)
			return -1;
		
		return factorial(number-1)*number;
	}
	
	public static int fibonacciIteration(int term)
	{
		int answer=0;
		int number1=1;
		int number2=0;
		
		if (term==0)
			return 0;
		if (term==1)
			return 1;
	
		for(int i=2; i<=term; i++)
		{
			answer=number1+number2;
			number2=number1;
			number1=answer;
		}
		
		return answer;
	}
	
	public static int fibonacciRecursion(int term)
	{
		if(term==1)
			return 1;
		if(term==2)
			return 1;
		
		System.out.println("Going left with " + (term-1));
		int a= fibonacciRecursion(term-1);
		System.out.println("Going right with " + (term-2));
		int b= fibonacciRecursion(term-2);
		
		return a+b;
		
	}
	
	public static void main(String[] args) 
	{
		//System.out.println(recursion.summation(5));
		//System.out.println(recursion.factorial(5));
		//System.out.println(recursion.fibonacciRecursion(6));
		//System.out.println(recursion.fibonacciIteration());

	}

}
