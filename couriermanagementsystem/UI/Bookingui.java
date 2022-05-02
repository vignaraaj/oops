package couriermanagementsystem.UI;
import couriermanagementsystem.data.Bookingdata;
import couriermanagementsystem.usecase.Booking;
import couriermanagementsystem.usecase.Checkvalidity;
import couriermanagementsystem.usecase.Cities;
import java.util.Scanner;
import static java.lang.System.out;


public class Bookingui extends Checkvalidity {
    Scanner sc= new Scanner(System.in);
    public  Bookingui() {
        out.print("Enter your name : ");
        Bookingdata.name =sc.nextLine();
        out.print("Enter your address city : ");
        int f = 1;
        while(f==1) {
            Bookingdata.source = sc.nextLine();
            for (Cities c : Cities.values())
                if ((Bookingdata.source).equalsIgnoreCase(String.valueOf(c))) {
                    f = 0;
                    break;
                }
            if (f == 1) {
                out.println("Our Services are only provided at following cities");
                for (Cities c : Cities.values()) {
                    out.println(c);
                }
                out.print("Enter your address city : ");
            }
        }
        out.print("Enter your destination city : ");
        int g = 1;
        while(g==1) {
            Bookingdata.destination =sc.nextLine();
            for (Cities c : Cities.values())
                if ((Bookingdata.destination).equalsIgnoreCase(String.valueOf(c))) {
                    g = 0;
                    break;
                }
            if (g == 1) {
                out.println("Our Services are only provided at following cities");
                for (Cities c : Cities.values()) {
                    out.println(c);
                }
                out.print("Enter your destination city : ");
            }
            if(Bookingdata.source.equalsIgnoreCase(Bookingdata.destination)){
                out.println("source city and destination city can't be same");
                g=1;
            }
        }
        out.print("Enter weight of the package (in kg) : ");
        while(true) {
            Bookingdata.weight = sc.nextFloat();
            if(!onlydigits(Bookingdata.weight)){
                out.println("Enter valid weight");
                continue;
            }
            if(Bookingdata.weight>300) {
                out.println("Sorry we cant provide our service to more than 300kg of weight\nsplit the package and try again");
                out.print("Enter valid weight : ");
            }
            else  break;
        }
    }
    public  void booking() throws Exception {
        out.print("confirm to place order?\npress 'y' for yes 'n' for no : ");
        while (true) {
            char c = sc.next().charAt(0);
            if (c == 'y') {
                Booking.writetofile();
                break;
            }
            else if (c == 'n') break;
            else out.print("press 'y' or 'n' : ");
        }
    }
}
