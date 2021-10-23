import java.util.Scanner;
public class test7
{
	public static void main(String[] args)
	{
      Scanner my_scanner = new Scanner(System.in);
      System.out.println("请输入月份:");
      int month = my_scanner.nextInt();
      System.out.println("请输入年龄:");
	  int age = my_scanner.nextInt();
	  if(month>=4 && month <=10)
	  {
          if(age<18)
          {
			System.out.println("请支付30元");
          }
          else if (age>60)
          {
            System.out.println("请支付20元");
          }
          else
          {
			System.out.println("请支付60元");
          }
	  }
	  else
	  {
	  	if(age>=18 && age<=60)
	  	{
	  		System.out.println("请支付40元");
	  	}
	  	else
	  	{
	  		System.out.println("请支付20元");
	  	}
	  }

	}
}