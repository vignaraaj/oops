package couriermanagementsystem.UI;
import java.util.Scanner;

import static java.lang.System.*;

public class Main {

    public static void main(String[] args) {
        try {
            int choice;
            boolean b = true;
            Scanner sc = new Scanner(System.in);
            while(b) {
                out.println("COURIER MANAGEMENT SYSTEM");
                out.println("1.login(admin only)\n2.Bookings\n3.track order\n4.exit");
                out.print("Enter choice : ");
                choice = sc.nextInt();
                switch (choice){
                        case 1 -> {
                            Loginui l = new Loginui();
                        }
                        case 2 -> {
                            Bookingui bi = new Bookingui();
                            bi.booking();
                        }
                        case 3 -> {
                            Statusui s = new Statusui();
                        }
                        case 4 -> {
                            out.println("Terminating...");
                            b=false;
                        }
                        default -> out.println("choose 1-4");
                }
                out.println("\n");
            }
        } catch (Exception e) {
            out.println("Incorrect value leads to termination of program");
        }
    }
}

