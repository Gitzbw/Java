public class test17
{
	public static void main(String[] args)
	{
       Person p1 = new Person("Jack");
       System.out.println(p1.name);
       System.out.println(p1.age);

	}
}

class Person
{
	String name;
	int age;
	public Person(String name)
	{
	   this("Marry",20);
       this.name = name;
	}
	public Person(String name,int age)
	{
       this.name = name;
       this.age = age;
	}
}