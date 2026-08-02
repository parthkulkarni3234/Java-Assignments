
public class Inform{

    String name;
    int age;

    public Inform(String n, int a) {
        name = n;
        age = a;
        System.out.println("Object created and initialized!");
    }

    public void showDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    
    public static void main(String[] args) {
        Inform obj = new Inform("Parth", 19);   
        obj.showDetails();                     
    }
}