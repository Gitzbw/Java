import java.util.Scanner;
public class test6
{
	public static void main(String[] args)
	{
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入姓名:");
        String name = scanner.next();
        System.out.println("请输入年龄:");
        int age = scanner.nextInt();
        System.out.println("请输入工资:");
        double salary = scanner.nextDouble();
        System.out.println("信息如下:");
        System.out.println("姓名:"+name+" 年龄:"+age+" 工资:"+salary);

	}
}