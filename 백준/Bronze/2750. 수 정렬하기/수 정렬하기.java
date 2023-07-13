import javax.swing.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.sql.Array;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for(int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0 ; i < n - 1 ; i++) {
            for(int j = 0 ; j < n - i - 1 ; j++) {
                if (arr[j] > arr[j + 1]){
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        for(int i = 0 ; i < n ; i++) {
            System.out.println(arr[i]);
        }
    }
}