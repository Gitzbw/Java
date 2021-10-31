import java.util.Scanner;
public class test15
{
	public static void main(String[] args)
	{
       T t = new T();
       Scanner scanner = new Scanner(System.in);
       System.out.println("ÇëÊäÈëÔ²ÅÌÊýÄ¿:");
       int num = scanner.nextInt();
       t.move(num,'A','B','C');
	}
}

class T
{
	public void move(int num ,char a,char b ,char c)
	{
         if(num == 1)
         {
         	System.out.println( a + "->" + c );
         }
         else
         {
            move(num-1,a,c,b);
            System.out.println( a + "->" + c );
            move(num-1,b,a,c);
         }
	}
}