import java.util.Scanner;
public class test8
{
	public static void main(String[] args)
	{
	     int i =0;
	     Scanner my_scanner = new Scanner(System.in);
	     System.out.println("ÇëÊäÈëÊıÖµ:");
	     int n = my_scanner.nextInt();
	     for(i=0;i<=n;i++)
	     {
	     	System.out.println(i + "+" + (n-i) + " = " + n);
	     }
	}
}