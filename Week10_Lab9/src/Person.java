public class Person {
    private String name;
    private int age;

    //default constructor
    public Person(){
        this.name = "";
        this.age = 0;
    }

    //constructor with name and age
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    //toString method for name and age
    public String toString() {
        return name + " is " + age + " years old";
    }

    //increment age by 1
    public void incrementAge() {
        this.age++;
    }

    // accessor to return name
    public String getName() {
        return name;
    }

    // Accessor to return  age
    public int getAge() {
        return age;
    }
}
