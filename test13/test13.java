class Person
{
	int age;
	String name;

	public int sum(int a,int b)
	{
		return a+b;
	}
	
}

public class test13
{
	public static void main(String[] args)
	{
       Person n = new Person();
       n.age = 18;
       n.name = "ÕÅÈı";
       int ret = n.sum(10,20);
       System.out.print("name = " + n.name + "\n" + "age = " +  n.age + "\n" + "ret = " + ret);
	}
}

