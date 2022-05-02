package couriermanagementsystem.usecase;

import static com.sun.tools.javac.util.StringUtils.toUpperCase;
import static couriermanagementsystem.data.Bookingdata.offer;

public enum Cities {
    BANGALORE(20), CHENNAI(30), COIMBATORE(15), DELHI(25), GUWAHATI(15), HYDERABAD(25), KOCHI(30), KOLKATA(10), MADURAI(20), MUMBAI(20), TIRUCHI(15);
    int discount;
    Cities(int offer) {
        discount=offer;
    }
    int getdiscount() {
        return discount;
    }

    public static int getoffer(String source, int pay){
        offer= Cities.valueOf(toUpperCase(source)).getdiscount();
        pay= pay - offer*pay/100;
        System.out.println("Discount : "+offer+"%");
        return pay;
    }

}

