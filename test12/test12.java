public class test12
{
	public static void main(String[] args)
	{
	   int arr[][] = new int[10][];
	   int i = 0;
	   for(i=0;i<arr.length;i++)
	   {
          arr[i] = new int [i+1];
	   }

       for(i=0;i<arr.length;i++)
       {
          int j = 0;
          for(j=0;j<i+1;j++)
          {
          	if(j==0 || j==i)
          	{
          		arr[i][j] = 1;
          	}
          	else
          	{
          		arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
          	}
          }
       }

       for(i=0;i<arr.length;i++)
	   {
          int j = 0;
          for(j=0;j<i+1;j++)
	     {
            System.out.print(arr[i][j] + " ");
	     }
          System.out.println();
	   }

	}
}