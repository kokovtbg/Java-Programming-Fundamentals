package ObjectAndClasses.exercise;

public class Person {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //полета - характеристики
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;

    //конструктор
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
