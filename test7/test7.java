import java.util.Scanner;
public class test7
{
	public static void main(String[] args)
	{
      Scanner my_scanner = new Scanner(System.in);
      System.out.println("�������·�:");
      int month = my_scanner.nextInt();
      System.out.println("����������:");
	  int age = my_scanner.nextInt();
	  if(month>=4 && month <=10)
	  {
          if(age<18)
          {
			System.out.println("��֧��30Ԫ");
          }
          else if (age>60)
          {
            System.out.println("��֧��20Ԫ");
          }
          else
          {
			System.out.println("��֧��60Ԫ");
          }
	  }
	  else
	  {
	  	if(age>=18 && age<=60)
	  	{
	  		System.out.println("��֧��40Ԫ");
	  	}
	  	else
	  	{
	  		System.out.println("��֧��20Ԫ");
	  	}
	  }

	}
}