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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringTokenizer input = new StringTokenizer(br.readLine());

        long [] arr = new long[n + 1];

        for(int i = 1 ; i <= n ; i++) {
            arr[i] = arr[i - 1] + Long.parseLong(input.nextToken());
        }

        for(int i = 0 ; i < m ; i++) {
            input = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(input.nextToken());
            int b = Integer.parseInt(input.nextToken());
            System.out.println(arr[b] - arr[a - 1]);
        }
    }
}