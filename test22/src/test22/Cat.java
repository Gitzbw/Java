package test22;

public class Cat extends Animal {

    private String behavior;

    public Cat(String name, String food, String behavior) {
        super(name, food);
        this.behavior = behavior;
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }
}
