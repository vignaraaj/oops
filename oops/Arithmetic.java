package oops;
public class Arithmetic extends Abstractclass implements Interface{

     public void add(double a, double b) {
        double c = a + b;
        System.out.println(c);
    }
    public void sub(double a, double b) {
        double c = a - b;
        System.out.println(c);
    }
    public void mul(double a, double b) {
        double c = a * b;
        System.out.println(c);
    }
    public void div(double a, double b) {
        double c = a / b;
        System.out.println(c);
    }

    public void sub(double a, double b, double c) {
        double d=a-b-c;
        System.out.println(d);
    }
    public void div(double a, double b, double c) {
        double d=a/b/c;
        System.out.println(d);
    }

    public void modulo(double a, double b) {
        double c=a%b;
        System.out.println(c);
    }
    public void modulo(double a, double b, double c) {
        double d=a%b%c;
        System.out.println(d);
    }
}



