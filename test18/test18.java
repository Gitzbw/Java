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
        System.out.print("������ʯͷ(0)/����(1)/��(2):");
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      Guess guess1 = new Guess();
      int ret = guess1.guess(n);
      if(ret==1)
      {
        count++;
      }

      }
      System.out.println("��Ӯ��" + count + "��");
      
    }
}

class Guess
{
  public int guess(int n)
  {
     Random r = new Random();
     int x = r.nextInt(3);
     System.out.println("���Գ�����:"+ x );
     if(x == n)
     {
      System.out.println("ƽ��");
      return 0;
     }
     else if((n==0 && x==1)||(n==1 && x==2)||(n==2 && x==0))
     {
       System.out.println("��Ӯ��");
       return 1;
     }
     else
     {
      System.out.println("������");
      return 2;
     }
  }
}