public class StringBalancing {
	public static void main(String[] args){
		
		NPSArrayStack<Integer> p = new NPSArrayStack<Integer>();
		NPSArrayStack<Integer> b = new NPSArrayStack<Integer>();
		NPSArrayStack<Integer> c = new NPSArrayStack<Integer>();
		String string = new String("((()))");
	
		//parenthesis
		boolean bp=true;
		for (int i = 0; i<string.length();i++){	
			if(string.charAt(i)=='(')
			{
				p.push(1);
			}
			if(string.charAt(i)==')')
			{
				if(p.isEmpty()){
					 bp=false;
					System.out.println("The parenthesis are unbalanced.");
					break;
				}
				else{
					p.pop();
				}}}
		
		
		if (!p.isEmpty())
		{
			System.out.println("The parenthesis are unbalanced.");
		}
		if(p.isEmpty()&&bp){
			System.out.println("The parenthesis are balanced.");
		}
		//brackets
		boolean bb=true;
		for (int i = 0; i<string.length();i++){	
			if(string.charAt(i)=='[')
			{
				b.push(1);
			}
			if(string.charAt(i)==']')
			{
				if(b.isEmpty()){
					 bb=false;
					System.out.println("The brackets are unbalanced.");
					break;
				}
				else{
					b.pop();
				}}}
		
		
		if (!b.isEmpty())
		{
			System.out.println("The brackets are unbalanced.");
		}
		if(b.isEmpty()&&bb){
			System.out.println("The brackets are balanced.");
		}
		// curly braces
		boolean bc=true;
		for (int i = 0; i<string.length();i++){	
			if(string.charAt(i)=='{')
			{
				c.push(1);
			}
			if(string.charAt(i)=='}')
			{
				if(c.isEmpty()){
					 bc=false;
					System.out.println("The curly braces are unbalanced.");
					break;
				}
				else{
					c.pop();
				}}}
		
		
		if (!c.isEmpty())
		{
			System.out.println("The curly braces are unbalanced.");
		}
		if(c.isEmpty()&&bc){
			System.out.println("The curly braces are balanced.");
		}
		}
	}
