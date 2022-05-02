package couriermanagementsystem.usecase;
import couriermanagementsystem.data.Logindata;
import java.io.FileReader;

public class Login {

    public static void login() throws Exception {

        if (Logindata.username.equals(Logindata.s) && Logindata.password.equals(Logindata.p)) {
            Login.showdetails();
        } else {
            System.out.println("username and password mismatch");

        }
    }
    public static void showdetails() throws  Exception {
        FileReader fr = new FileReader("cust_details.txt");
        int i;
        while ((i = fr.read()) != -1) {
            System.out.print((char) i);
        }
    }
}
