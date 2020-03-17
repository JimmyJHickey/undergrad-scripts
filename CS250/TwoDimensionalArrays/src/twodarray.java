import javabook.Format;
public class twodarray {
	
	public static void loadArray(int A [][],int n)
	{
		for(int row=0;row<n;row++)
			for(int col=0;col<n;col++)
				A[row][col]=(int)(Math.random()*4)-2;		
	}

	public static void readArray(int A[][], int n)
	{
		for(int row=0;row<n;row++){
			for(int col=0;col<n;col++)
				System.out.print(Format.leftAlign(4, A[row][col] +" "));
		System.out.print("\n");
		}
		System.out.print("\n");
	}
	
	public static void addArrays(int A[][], int B[][], int C[][], int n)
	{
		for (int row=0;row<n;row++)
			for(int col=0; col<n;col++)
				C[row][col]=A[row][col]+B[row][col];
	}
	
	public static void multiplyArrays(int A[][], int B[][], int C[][], int n)
	{
		for (int row=0;row<n;row++)
			for(int col=0; col<n;col++)
			{
				C[row][col]=0;
				for(int c=0;c<n;c++)
					C[row][col]=A[row][c]*B[c][col]+C[row][col];
			}
	}
	
	
	public static void main(String[] args) {
		int n=2;
		int A[][]=new int [n][n];
		int B[][]=new int [n][n];
		int C[][]=new int [n][n];
		
		twodarray.loadArray(A, n);
		twodarray.loadArray(B, n);
		twodarray.readArray(A, n);
		twodarray.readArray(B, n);
		twodarray.addArrays(A,B,C,n);
		twodarray.readArray(C, n);
		twodarray.multiplyArrays(A, B, C, n);
		twodarray.readArray(C, n);
	}
}
