package couriermanagementsystem.usecase;
import couriermanagementsystem.data.Statusdata;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Status  {
    public static void status() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cust_details.txt"));
        String line;
        int flag=1;
        while ((line = br.readLine()) != null) {
            if (line.contains(String.valueOf(Statusdata.Id))) {
                StringTokenizer tokenizer = new StringTokenizer(line, ",");
                while (tokenizer.hasMoreTokens())
                    System.out.println(tokenizer.nextToken());
                flag=0;

                break;
            }
        }
        if(flag==1){
            System.out.println("Invalid trackId");
        }
    }
}


