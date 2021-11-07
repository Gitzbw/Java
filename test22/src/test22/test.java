package test22;

public class test {
    public static void main(String[] args) {
        feed f = new feed();
        Master jack = new Master("jack");
        Animal cat = new Cat("小花","鱼","喵喵叫");
        f.Feed(jack,cat);
        System.out.println("======================");
        Animal dog = new Dog("大黄","骨头","汪汪叫");
        f.Feed(jack,dog);
        System.out.println("======================");
        Cat cat1 =(Cat)cat;
        System.out.println(cat1.getName()+"在"+cat1.getBehavior());
        System.out.println("======================");
        Dog dog1 =(Dog)dog;
        System.out.println(dog1.getName()+"在"+dog1.getBehavior());
    }
}
