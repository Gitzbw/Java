package test22;

public class Animal {
    private String name;
    private String food;

    public Animal(String name, String food) {
        this.name = name;
        this.food = food;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getName() {
        return name;
    }

    public String getFood() {
        return food;
    }
}
