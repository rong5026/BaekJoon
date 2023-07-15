import javax.swing.*;
import java.io.*;
import java.nio.Buffer;
import java.sql.Array;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int [] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int [] result = new int[n];
        int sum = 0;
        result[0] = arr[0];
        for(int i = 1 ; i < n ; i++) {
            result[i] = result[i - 1] + arr[i];
        }

        for(int i = 0 ; i < n ;i++)
            sum+= result[i];

        System.out.println(sum);
    }
}