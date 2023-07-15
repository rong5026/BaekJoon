import javax.swing.*;
import java.io.*;
import java.nio.Buffer;
import java.sql.Array;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        StringTokenizer st = new StringTokenizer(br.readLine());

        int []arr = new int[n];

        for(int i = 0 ; i < n ; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        System.out.println(arr[m - 1]);
    }
}