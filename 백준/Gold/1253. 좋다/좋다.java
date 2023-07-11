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

        StringTokenizer st = new StringTokenizer(br.readLine());

        int []arr = new int[n];

        for(int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int cnt = 0;

        for(int i = 0 ; i < n ; i++) {

            int start = 0;
            int last = n - 1;

            while(start < last) {
                if(i == last)
                    last--;
                else if(i == start)
                    start++;
                else {

                    int sum = arr[start] + arr[last];

                    if (sum > arr[i])
                        last--;
                    else if (sum < arr[i])
                        start++;
                    else {
                        cnt++;
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);

    }
}