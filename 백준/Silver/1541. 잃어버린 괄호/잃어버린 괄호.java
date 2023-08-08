import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String []line = br.readLine().split("-");

        int total = 0;
        int sum = 0;
        for(int i = 0 ; i < line.length ; i++) {

            String []arr = line[i].split("\\+");
            sum = 0;
            for(int j = 0 ;j < arr.length ; j++) {
                sum += Integer.parseInt(arr[j]);
            }

            if(i == 0)
                total = sum;
            else
                total -=sum;
        }
        System.out.println(total);


    }
}
