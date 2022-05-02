package couriermanagementsystem.data;
import java.time.LocalDate;

public  class Bookingdata {
    public static String name,source,destination;
    public static char category;
    public static int pay,trackId,offer;
    public static int []distancefactor=new int[2];
    public static float weight;
    public static LocalDate deliverydate,orderdate;
}
