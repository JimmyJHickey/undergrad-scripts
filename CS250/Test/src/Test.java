import java.util.Scanner;


public class Test 
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		String name;
		
		while(true)
		{
			System.out.println("Your name: ");
			name = scanner.next();
			if (name.length() == 0) break;
			
			System.out.println("Invalid");
		}
	}
}
