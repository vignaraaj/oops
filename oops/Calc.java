package oops;
import java.util.*;
public class Calc {
    public static void main(String[] args) {
        Arithmetic ob = new Arithmetic();
        Scanner sc = new Scanner(System.in);
        double a=0,b=0,c=0;
        System.out.print("Enter the total numbers to be manipulated (Valid-2(or)3):");
        int num=sc.nextInt();
        if (num==2) {
            System.out.print("Enter first number: ");
            a = sc.nextDouble();
            System.out.print("Enter second number: ");
            b = sc.nextDouble();
        }
        else if(num==3){
            System.out.print("Enter first number: ");
            a = sc.nextDouble();
            System.out.print("Enter second number: ");
            b = sc.nextDouble();
            System.out.print("Enter third number: ");
            c = sc.nextDouble();
        }

        System.out.println("1:Addition");
        System.out.println("2:Subtraction");
        System.out.println("3:Multiplication");
        System.out.println("4:Division");
        System.out.println("5:Modulo");
        int i=sc.nextInt();
        switch (i) {
            case 1 -> {
                System.out.println("Addition");
                if (num == 2) ob.add(a, b);
                else if (num == 3) ob.add(a, b, c);
            }
            case 2 -> {
                System.out.println("Subtraction");
                if (num == 2) ob.sub(a, b);
                else if (num == 3) ob.sub(a, b, c);
            }
            case 3 -> {
                System.out.println("Multiplication");
                if (num == 2) ob.mul(a, b);
                else if (num == 3) ob.mul(a, b, c);
            }
            case 4 -> {
                System.out.println("Division");
                if (num == 2) ob.div(a, b);
                else if (num == 3) ob.div(a, b, c);
            }
            case 5 -> {
                System.out.println("Modulo");
                if (num == 2) ob.modulo(a, b);
                else if (num == 3) ob.modulo(a, b, c);
            }
            default -> System.out.println("Enter valid number!!!");
        }
    }
}
