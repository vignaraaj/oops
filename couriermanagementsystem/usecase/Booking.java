package couriermanagementsystem.usecase;
import couriermanagementsystem.data.Bookingdata;
import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import static java.lang.System.out;

public class Booking {

    public static char find_category(float weight) {
        if (weight>0 && weight<=50 ) Bookingdata.category = 'A';
        else if(weight>50 && weight<=100) Bookingdata.category='B';
        else if(weight>100 && weight<=200) Bookingdata.category='C';
        else if(weight>200) Bookingdata.category='D';
        return Bookingdata.category;
    }

    public static LocalDate order() {
        return Bookingdata.orderdate= LocalDate.now();
    }

    public static LocalDate Issuedeliverydate(LocalDate orderdate,int waitingday) {
        return Bookingdata.deliverydate = orderdate.plus(waitingday, ChronoUnit.DAYS);
    }

    public static int issuetrackid() throws IOException {
        Random rnd = new Random();
        Bookingdata.trackId = rnd.nextInt(9999);
        BufferedReader br = new BufferedReader(new FileReader("cust_details.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            if (line.contains(String.valueOf(Bookingdata.trackId))) {
                issuetrackid();
            }
        }
        return Bookingdata.trackId;
    }

    public static int[] distancefactor(String source,String destination){
        boolean f=false,g=false;
        String[] south={"BANGALORE","CHENNAI","COIMBATORE","HYDERABAD","KOCHI","MADURAI","TIRUCHI"};
        //String[] north={"DELHI","GUWAHATI","KOLKATA","MUMBAI"};
        for (String s : south) {
            if (source.equalsIgnoreCase(s)) f = true;
            if (destination.equalsIgnoreCase(s)) g = true;
        }
        if(f && g){
            Bookingdata.distancefactor[0]=200; //distancepay
            Bookingdata.distancefactor[1]=3;  //waitingday
        }else if(f){
            Bookingdata.distancefactor[0]=500;
            Bookingdata.distancefactor[1]=5;
        }else if(g){
            Bookingdata.distancefactor[0]=500;
            Bookingdata.distancefactor[1]=5;
        }else {
            Bookingdata.distancefactor[0]=300;
            Bookingdata.distancefactor[1]=4;
        }
        return Bookingdata.distancefactor;
    }


    public static int payment(int distancepay,char category) {
        return switch (category) {
            case 'A' -> distancepay + ((distancepay * 5) / 100);
            case 'B' -> distancepay + ((distancepay * 10) / 100);
            case 'C' -> distancepay + ((distancepay * 20) / 100);
            case 'D' -> distancepay + ((distancepay * 50) / 100);
            default -> 0;
        };
    }
    public static void writetofile() throws Exception {
        ArrayList<String> anotherlist = new ArrayList<>();

        Bookingdata.category = find_category(Bookingdata.weight);
        Bookingdata.orderdate = order();
        out.println("order date : " + Bookingdata.orderdate);
        Bookingdata.distancefactor = distancefactor(Bookingdata.source, Bookingdata.destination);
        Bookingdata.pay = payment(Bookingdata.distancefactor[0], Bookingdata.category);
        out.println("Payment : " + Bookingdata.pay);
        Bookingdata.deliverydate = Issuedeliverydate(Bookingdata.orderdate, Bookingdata.distancefactor[1]);
        out.println("Delivery date : " + Bookingdata.deliverydate);
        Bookingdata.trackId = issuetrackid();
        out.println("TrackId : " + Bookingdata.trackId);
        Bookingdata.pay=Cities.getoffer(Bookingdata.source,Bookingdata.pay);
        out.println("Discount_amount : "+Bookingdata.pay);

        anotherlist.add("Customer name : " + Bookingdata.name);
        anotherlist.add("Sent from : " + Bookingdata.source);
        anotherlist.add("Sent to : " + Bookingdata.destination);
        anotherlist.add("Weight : " + Bookingdata.weight + "kg");
        anotherlist.add("Category : " + Bookingdata.category);
        anotherlist.add("payment : " + Bookingdata.pay);
        anotherlist.add("Orderdate : " + Bookingdata.orderdate);
        anotherlist.add("deliverydate : " + Bookingdata.deliverydate);
        anotherlist.add("TrackId : " + Bookingdata.trackId);

        var list = new ArrayList<>();
        list.add(anotherlist);
        FileWriter writer = new FileWriter("cust_details.txt", Boolean.TRUE);
        for (var str : list) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();
    }
}
