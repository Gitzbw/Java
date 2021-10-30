public class test14
{
	public static void main(String[] args)
	{
      Person p1 = new Person();
      p1.name = "Jack";
      p1.age = 18;
      A a = new A();
      Person p2 = a.copy(p1);
      System.out.println("p1的数据如下:");
      System.out.println("age = "+ p1.age);
      System.out.println("name = "+ p1.name);
      System.out.println("p2的数据如下:");
      System.out.println("age = "+ p2.age);
      System.out.println("name = "+ p2.name);
      System.out.println("p1 和 p2 是否相等: " + (p1 == p2));
	}
}

class Person
{
	String name;
	int age;
}

class A
{
	public Person copy(Person p1)
	{
       Person p2 = new Person();
       p2.name = p1.name;
       p2.age = p1.age;
       return p2;
	}
}