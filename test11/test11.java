import java.util.Scanner;
public class test11
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int arr1[] = {1,2,3};
		do{
	    int arr2[] = new int[arr1.length + 1];
	    int i = 0;
	    for(i=0;i<arr1.length;i++)
	    {
	    	arr2[i] = arr1[i];
	    }
	    System.out.println("请输入要添加的数据:");
	    arr2[arr2.length-1] = scanner.nextInt();
	    arr1 = arr2;
	    System.out.println("扩容后的数组如下:");
        for(i=0;i<arr1.length;i++)
	    {
	    	System.out.printf(arr1[i]+" ");
	    }
		System.out.println("");
	    System.out.println("是否继续扩容:y/n");
	    char key = scanner.next().charAt(0);
	    if (key == 'n')
	    {
	    	break;
	    }

		}while(true);
	    
	}
}