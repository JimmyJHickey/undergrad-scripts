

public class Stack_Test {
	
	public static int random(){
		int i=((int) (Math.random()*10));
		return i;
	}
	
	public static void pushes(NPSArrayStack<Integer> A){
		int z=random();
		System.out.println("Attempting to push " + z + " numbers to the stack");
		for(int i=0; i<z;i++)
		{	
			int t = random();
			System.out.println("Pushing " + t + " to the stack.");
			A.push(t);
		}
	}
	
	public static void pops(NPSArrayStack<Integer> A){
			int z=random();
			System.out.println("Attempting to pop  " + z + " numbers from the stack");
			for(int i=0; i<z;i++)
			{
				if (A.isEmpty()){
					System.out.println("The stack is empty.");
				}
				else{
					System.out.println("Popping " + A.peek() + " from the stack.");
					A.pop();	
			}
		}
	}
	
	public static void main(String[] args){
		NPSArrayStack<Integer> array = new NPSArrayStack<Integer>();
		NPSArrayStack<Integer> array2 = new NPSArrayStack<Integer>(29);
		
		for(int i=0; i<random();i++){
			pushes(array);
			pops(array);
		}
		System.out.println("The array size is: " + array.size());
		array.clear();
		System.out.println("The array size is: " + array.size());
	}

}
