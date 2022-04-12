package oops;
public abstract class  Abstractclass  {
    Abstractclass(){
        System.out.println("Calculator");
    }

    public abstract void modulo(double a, double b);
    abstract void modulo(double a, double b, double c);
    public void add(double a, double b, double c) {
        double d = a + b + c;
        System.out.println(d);
    }
    public void mul(double a, double b,double c) {
        double d = a * b * c;
        System.out.println(d);
    }


}
