package couriermanagementsystem.UI;
import couriermanagementsystem.data.Logindata;
import couriermanagementsystem.usecase.Login;
import java.util.Scanner;

public class Loginui {

    public Loginui() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username : ");
        Logindata.s = sc.nextLine();
        System.out.print("Enter password : ");
        Logindata.p = sc.nextLine();
        Login.login();
    }

}
