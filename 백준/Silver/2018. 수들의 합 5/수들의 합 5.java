import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.sql.Array;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int start = 1;
        int last = 1;

        int sum = 1;
        int cnt = 1;
        while(last != n) {

            if (sum <= n) {
                if (sum == n)
                    cnt++;
                last++;
                sum += last;

            }
            else if (sum > n ){
                sum -= start;
                start++;
            }
        }
        System.out.println(cnt);




    }
}