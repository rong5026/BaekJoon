import javax.swing.*;
import java.io.*;
import java.nio.Buffer;
import java.sql.Array;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int arr[] = new int[10001];

        for(int i = 0 ; i < n ; i++) {
            arr[Integer.parseInt(br.readLine())]++;
        }

        for(int i = 1 ; i <= 10000 ; i++)
        {
            while(arr[i] > 0) {
                bw.write(i + "\n");
                arr[i]--;
            }
        }
        bw.flush();
        bw.close();


    }
}