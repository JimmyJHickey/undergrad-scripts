
public class ArraySorting {
	public static void loadArray(int A [])
	{
		for (int i = 0; i<A.length;i++)
			A[i]= (int)((100 * Math.random()) + 1);
	}
	
	 public static void bubbleSort(int A [], int number)
	 {
		 int temp;
		 for (int i = 0; i < number; i++)
			 for (int j = i+1; j < number; j++)
				if (A[i]>A[j])
				{
					temp = A[i];
					A[i] = A[j];
					A[j] = temp;
				}
	 }
	 
	 //http://courses.cs.washington.edu/courses/cse373/01wi/slides/Measurement/sld010.htm
	 public static void insertionSort(int A[], int number)
	 {
		 for (int i=1;i<number;i++)
		 {
			 int temp = A[i];
			 int j;
			 for (j=i-1; j>=0;j--)
			 {
				 A[j+1]=A[j];
			 }
			 A[j+1]=temp;
		 }
	 }
	 
	 //http://mathbits.com/MathBits/Java/arrays/SelectionSort.htm
	 public static void selectionSort(int A[], int number)
	 {
		 int i, j, first, temp;  
	     for ( i = number - 1; i > 0; i -- )  
	     {
	          first = 0;   
	          for(j = 1; j <= i; j ++)   //locate smallest element between positions 1 and i.
	          {
	               if( A[ j ] < A[ first ] )         
	                 first = j;
	          }
	          temp = A[ first ];   //swap smallest found with element in position i.
	          A[ first ] = A[ i ];
	          A[ i ] = temp; 
	      }           
	 }
	 
	 //http://www.sanfoundry.com/java-program-implement-heap-sort/
	  /* Sort Function */
	 	private static int N;
	    public static void heapSort(int arr[],int n)
	    {       
	        heapify(arr,n);        
	        for (int i = N; i > 0; i--)
	        {
	            swap(arr,0, i);
	            N = N-1;
	            maxheap(arr, 0);
	        }
	    }     
	    /* Function to build a heap */   
	    public static void heapify(int arr[], int n)
	    {
	        N = n-1;
	        for (int i = N/2; i >= 0; i--)
	            maxheap(arr, i);        
	    }
	    /* Function to swap largest element in heap */        
	    public static void maxheap(int arr[], int i)
	    { 
	        int left = 2*i ;
	        int right = 2*i + 1;
	        int max = i;
	        if (left <= N && arr[left] > arr[i])
	            max = left;
	        if (right <= N && arr[right] > arr[max])        
	            max = right;
	 
	        if (max != i)
	        {
	            swap(arr, i, max);
	            maxheap(arr, max);
	        }
	    }    
	    /* Function to swap two numbers in an array */
	    public static void swap(int arr[], int i, int j)
	    {
	        int tmp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = tmp; 
	    }  
	    
	    
	    //http://www.java2novice.com/java-sorting-algorithms/merge-sort/
	    private int[] array;
	    private int[] tempMergArr;
	    private int length;
	
	    public void mergeSort(int inputArr[],int n) {
	        this.array = inputArr;
	        this.length = n;
	        this.tempMergArr = new int[length];
	        doMergeSort(0, length - 1);
	    }
	    
	    private void doMergeSort(int lowerIndex, int higherIndex) {
	         
	        if (lowerIndex < higherIndex) {
	            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
	            // Below step sorts the left side of the array
	            doMergeSort(lowerIndex, middle);
	            // Below step sorts the right side of the array
	            doMergeSort(middle + 1, higherIndex);
	            // Now merge both sides
	            mergeParts(lowerIndex, middle, higherIndex);
	        }
	    }
	 
	    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
	 
	        for (int i = lowerIndex; i <= higherIndex; i++) {
	            tempMergArr[i] = array[i];
	        }
	        int i = lowerIndex;
	        int j = middle + 1;
	        int k = lowerIndex;
	        while (i <= middle && j <= higherIndex) {
	            if (tempMergArr[i] <= tempMergArr[j]) {
	                array[k] = tempMergArr[i];
	                i++;
	            } else {
	                array[k] = tempMergArr[j];
	                j++;
	            }
	            k++;
	        }
	        while (i <= middle) {
	            array[k] = tempMergArr[i];
	            k++;
	            i++;
	        }
	 
	    }

	
	 
	 //http://www.vogella.com/tutorials/JavaAlgorithmsQuicksort/article.html
	  private int[] numbers;
	  private int number;

	  public void quickSort(int[] values,int n) {
	    // check for empty or null array
	    if (values ==null || n==0){
	      return;
	    }
	    this.numbers = values;
	    number = n;
	    qsort(0, number - 1);
	  }

	  private void qsort(int low, int high) {
	    int i = low, j = high;
	    // Get the pivot element from the middle of the list
	    int pivot = numbers[low + (high-low)/2];

	    // Divide into two lists
	    while (i <= j) {
	      // If the current value from the left list is smaller then the pivot
	      // element then get the next element from the left list
	      while (numbers[i] < pivot) {
	        i++;
	      }
	      // If the current value from the right list is larger then the pivot
	      // element then get the next element from the right list
	      while (numbers[j] > pivot) {
	        j--;
	      }

	      // If we have found a values in the left list which is larger then
	      // the pivot element and if we have found a value in the right list
	      // which is smaller then the pivot element then we exchange the
	      // values.
	      // As we are done we can increase i and j
	      if (i <= j) {
	        exchange(i, j);
	        i++;
	        j--;
	      }
	    }
	    // Recursion
	    if (low < j)
	      qsort(low, j);
	    if (i < high)
	      qsort(i, high);
	  }

	  private void exchange(int i, int j) {
	    int temp = numbers[i];
	    numbers[i] = numbers[j];
	    numbers[j] = temp;
	  }
	
	  public static void dummySort(){
	  }
	
	  public static void copyArray(int A[], int B[])
	  {
		  for (int i=0; i<A.length; i++)
			  B[i]=A[i];
	  }
		public static void main(String[] args) {
			ArraySorting sort=new ArraySorting();
			
			int A[]=new int[5000000];
			int B[]=new int[5000000];
			ArraySorting.loadArray(A);
			int number = 100000;
			ArraySorting.copyArray(A,B);
			
			long startDummy=System.nanoTime();
			ArraySorting.dummySort();
			long endDummy=System.nanoTime();
			long dummytime=endDummy-startDummy;
			
			ArraySorting.copyArray(A,B);
			long starttime=System.nanoTime();
			ArraySorting.bubbleSort(A,number);
			long endtime=System.nanoTime();
			long time=endtime-starttime;		
			long sorttime=time-dummytime;
			System.out.println("Bubble sort time in ns: " + sorttime);
			
			ArraySorting.copyArray(A,B);
			starttime=System.nanoTime();
			ArraySorting.heapSort(A,number);
			endtime=System.nanoTime();
			time=endtime-starttime;
			sorttime=time-dummytime;
			System.out.println("Heap sort time in ns: " + sorttime);
			
			ArraySorting.copyArray(A,B);
			starttime=System.nanoTime();
			ArraySorting.insertionSort(A, number);
			endtime=System.nanoTime();
			time=endtime-starttime;
			sorttime=time-dummytime;
			System.out.println("Insertion sort time in ns: " + sorttime);
			
			ArraySorting.copyArray(A,B);
			starttime=System.nanoTime();
			ArraySorting.selectionSort(A, number);
			endtime=System.nanoTime();
			time=endtime-starttime;
			sorttime=time-dummytime;
			System.out.println("Selection sort time in ns: " + sorttime);
			
			ArraySorting.copyArray(A,B);
			starttime=System.nanoTime();
			sort.mergeSort(A, number);
			endtime=System.nanoTime();
			time=endtime-starttime;
			sorttime=time-dummytime;
			System.out.println("Merge sort time in ns: " + sorttime);
			
			ArraySorting.copyArray(A,B);
			starttime=System.nanoTime();
			sort.quickSort(A,number);
			endtime=System.nanoTime();
			time=endtime-starttime;
			sorttime=time-dummytime;
			System.out.println("Quick sort time in ns: " + sorttime);
		}
	 
}
