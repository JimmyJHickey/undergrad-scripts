

public class QueueTest {
	
	public static int smallRandom(){
		int i=((int) (Math.random()*10));
		return i;
	}
	
	public static void addSome(NPSArrayQueue<Integer> A){
		int z=smallRandom();
		System.out.println("Attempting to add " + z + " numbers to the queue");
		for(int i=0; i<z;i++)
		{	
			int t = smallRandom();
			System.out.println("Adding " + t + " to the queue.");
			A.add(t);
		}
	}
	
	public static void removeSome(NPSArrayQueue	<Integer> A){
			int z=smallRandom();
			System.out.println("Attempting to remove " + z + " numbers from the queue");
			for(int i=0; i<z;i++)
			{
				if (A.isEmpty()){
					System.out.println("The queue is empty.");
				}
				else{
					System.out.println("Removing " + A.peek() + " from the queue.");
					A.remove();	
			}
		}
	}
	
	public static void main(String[] args){
		NPSArrayQueue<Integer> array = new NPSArrayQueue<Integer>();
		NPSArrayQueue<Integer> array2 = new NPSArrayQueue<Integer>(29);
		
		for(int i=0; i<smallRandom();i++){
			addSome(array);
			removeSome(array);
		}
		System.out.println("The array size is: " + array.size());
		array.clear();
		System.out.println("The cleared array size is: " + array.size());
				
		NPSArrayQueue<Integer> array3 = new NPSArrayQueue<Integer>(-9);
	}
	

}
