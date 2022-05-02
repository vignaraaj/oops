package couriermanagementsystem.UI;
import couriermanagementsystem.data.Statusdata;
import couriermanagementsystem.usecase.Status;
import java.io.IOException;
import java.util.Scanner;

public class Statusui {
        public Statusui() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the trackId : ");
        Statusdata.Id = sc.nextInt();
        Status.status();
    }
}
