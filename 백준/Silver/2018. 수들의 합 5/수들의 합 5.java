import javax.print.DocFlavor;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int n = Integer.parseInt(br.readLine());

       int start = 1;
       int last = 1;
       long sum = 1;
       int count = 1;

       while (last != n) {

           if (sum <= n) {
               if (sum == n) {
                   count++;
               }
               last++;
               sum += last;
           }
           else {
               sum -= start;
               start++;
           }
       }
        System.out.println(count);
    }
}