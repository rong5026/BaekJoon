import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int n = Integer.parseInt(br.readLine());

       StringTokenizer st = new StringTokenizer(br.readLine());

       long max = 0;
       long sum = 0;

       for(int i = 0 ; i < n ; i++) {
           int input = Integer.parseInt(st.nextToken());
           if(input > max)
               max = input;
           sum+=input;
       }
       double result = 100.0 * sum / n / max;
        System.out.println(result);
    }
}