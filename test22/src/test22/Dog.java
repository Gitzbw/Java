package test22;

public class Dog extends Animal {
    private String behavior;

    public Dog(String name, String food, String behavior) {
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
