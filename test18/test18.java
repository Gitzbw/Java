import java.util.Scanner;
import java.util.Random;  
public class  test18
{
	public static void main(String[] args)
    {
      int i = 0;
      int count = 0;
      for(i=0;i<3;i++)
      {
        System.out.print("请输入石头(0)/剪子(1)/布(2):");
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      Guess guess1 = new Guess();
      int ret = guess1.guess(n);
      if(ret==1)
      {
        count++;
      }

      }
      System.out.println("你赢了" + count + "次");
      
    }
}

class Guess
{
  public int guess(int n)
  {
     Random r = new Random();
     int x = r.nextInt(3);
     System.out.println("电脑出的是:"+ x );
     if(x == n)
     {
      System.out.println("平手");
      return 0;
     }
     else if((n==0 && x==1)||(n==1 && x==2)||(n==2 && x==0))
     {
       System.out.println("你赢了");
       return 1;
     }
     else
     {
      System.out.println("你输了");
      return 2;
     }
  }
}