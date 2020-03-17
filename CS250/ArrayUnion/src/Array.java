
public class Array 
{
	public static void arrayUnion(int A [], int B [])
	{
		int C [] = new int [A.length + B.length];
		int u = 0;
		for (int i = 0; i < A.length; i++)
		{
			for (int f = 0; f < B.length; f++)
			{
				if ((A[i] == B[f])&&(! Array.check(C, A[i])))
				{
					C[u] = A[i];
					u++;
				}
				if (A[i] != B[f])
				{
					if (! Array.check(C, A[i]))
					{
						C[u] = A[i];
						u++;
					}
					if (! Array.check(C, B[f]))
					{
						C[u] = B[f];
						u++;
					}
				}
			}
		}
		 Array.resize(C, u);
	}
	
	public static void arrayIntersection(int X [], int Y [])
	{
		int Z [] = new int [X.length];
		int u=0;
		
		for (int i=0; i<X.length; i++)
		{
			for(int j=0; j<Y.length;j++)
			{
				if (X[i] == Y[j])
				{
					Z[u] = X [i];
					u++;
				}
			}
		}	
		Array.resize(Z, u);
	}

	private static boolean check(int AC [], int number)
	{
		for (int i =0; i < AC.length; i++)
		{
			if (AC[i] == number && AC[i] != 0)
			{
				return true;
			}
		}
		return false;
	}
	
	private static void resize(int Y[], int values)
	{
		int ZZ[] = new int [values];
		for (int t=0; t < values; t++){
			ZZ[t] = Y[t];
		}
		for (int h=0; h<ZZ.length;h++)
		{
			System.out.print(ZZ[h] + " ");
		}
	}
	public static void main(String[] args) 
	{
		int X [] = {1,2,3};
		int Y [] = {2,3,4};
		
		Array.arrayIntersection(X, Y);
		System.out.println("\n");
		Array.arrayUnion(X, Y);
	}

}
