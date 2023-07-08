import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);


        if (m < 45){
            n--;
            m = 60 - (45 - m);
            if(n<0)
                n = 23;
            System.out.println(n + " " + m);
        }
        else
            System.out.println(n + " " + (m - 45));


    }
}