package Polimorfism;

public class StaticPolymorphism {
    public static int addNumbers(int x, int y){
        return x + y;
    }

    public static double addNumbers(double x, double y){
        return x + y;
    }

    public static double addNumbers(double x, double y, int z){
        return x + y + z;
    }

    public static void main (String[] args){
        System.out.println(addNumbers(5000,20));
        System.out.println(addNumbers(2.42,3.47));
        System.out.println(addNumbers(120.22,928.41,22));
    }
}
