public class test16
{
	public static void main(String[] args)
	{
		Person p1 = new Person("Jack",18);
		System.out.println("ĞÕÃû:" + p1.name);
		System.out.println("ÄêÁä:" + p1.age);
		int arr[] = new int[3];
		int i = 0;
		for(i=0;i<arr.length;i++)
		{
			arr[i] = i+1;
		}
		p1.print(arr);
	}
      
}

class Person
{
	String name;
	int age;
	public Person(String name1,int age1)
	{
		name = name1;
		age = age1;
	}
	public void print(int... num)
	{
		int i =0;
		for(i=0;i<num.length;i++)
		{
			System.out.println(num[i]);
		}
	}
}