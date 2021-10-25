import java.util.Scanner;
public class test9
{
	public static void main(String[] args)
	{
       Scanner scanner = new Scanner(System.in);
       int i = 0;
       int j = 0;
       System.out.print("ÇëÊäÈë²ãÊı:");
       int n = scanner.nextInt();
       for(i=0;i<n;i++)
       {
           for(j=0;j<=n-2-i;j++)
        {
            System.out.print(" ");
            
        }
           for(j=0;j<2*i+1;j++)
        {
              if(j == 0 || j == 2*i || i == n-1)
            {
              System.out.print("*");
            }
            else
            {
              System.out.print(" ");
            }
            
        }
          
          System.out.print("\n");
              
       }

	}
}