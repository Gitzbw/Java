import java.util.Scanner;
public class test6
{
	public static void main(String[] args)
	{
        Scanner scanner = new Scanner(System.in);
        System.out.println("����������:");
        String name = scanner.next();
        System.out.println("����������:");
        int age = scanner.nextInt();
        System.out.println("�����빤��:");
        double salary = scanner.nextDouble();
        System.out.println("��Ϣ����:");
        System.out.println("����:"+name+" ����:"+age+" ����:"+salary);

	}
}