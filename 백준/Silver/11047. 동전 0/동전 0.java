import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++) {
            arr[i] = input.nextInt();
        }
        int cnt = 0;
        for(int i = n - 1 ; i >= 0 ; i--) {

            while(arr[i] <= m)
            {
                m -= arr[i];
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}
