import javabook.Format;


public class FirstArray {		
	
	public static void loadArray(int A [])
	{
		for (int i = 0; i<A.length;i++)
			A[i]= (int)((100 * Math.random()) + 1);
	}
	
	public static void readArray(int A [])
	{
		for (int i = 0; i < A.length;i++)
		{
			System.out.print(Format.leftAlign(4, A[i] + " "));
				
			
			if ((i+1)%10==0)
			{
				System.out.println();
			}
		}
	}
		 public static int smallestArray(int A[]){
		 int pos = 0;
		 
		 for(int i = 1; i < A.length; i++)
		 {
			 if (A[pos] > A[i])
			 {
				 pos = i;
			 }
		 }
		 return(pos);
		 }
	public static double averageArray(int A[])
	{
		double sum = 0;
		double average;
		for (int i = 0; i < A.length; i++)
		{
			sum += A[i];
		}
		average = sum /(A.length);
		return average;
	}
	 
	 public static int largestArray(int A[])
	 {
		 int pos = 0;
		 
		 for(int i = 1; i < A.length; i++)
		 {
			 if (A[pos] < A[i])
			 {
				 pos = i;
			 }
		 }
		 return(pos);
		 }
	 
	 public static int findArray(int A[], int key)
	 {
		int pos = -1;
		
		for (int i=0; i < A.length; i++)
		{
			if (key == A[i])
			{
				pos =  i;
				break;
			}

			
		}
		return pos;
	 }

	 public static void bubbleSort(int A [], int number)
	 {
		 int temp;
		 for (int i = 0; i < number; i++)
		 {
			 for (int j = i+1; j < number; j++)
			 {
				if (A[i]>A[j])
				{
					temp = A[i];
					A[i] = A[j];
					A[j] = temp;
				}
			 }
		 }
	 }
	
	public static void main(String[] args) {
		
		int array [];
		array = new int[100];
		int number = 100;
		

		FirstArray.loadArray(array);
		FirstArray.readArray(array);
		
		System.out.print("\n");
		System.out.println("The average of the numbers in the array is " + FirstArray.averageArray(array));
		System.out.println("The position of the largest number is in space " + FirstArray.largestArray(array));
		System.out.println("The position of the smallest number is in space " + FirstArray.smallestArray(array));
		System.out.println("The position of " + number + " in the arrary is " + FirstArray.findArray(array, number));
		System.out.print("\n");
		
		FirstArray.bubbleSort(array, array.length);
		FirstArray.readArray(array);
	}

}
