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
        int m = Integer.parseInt(br.readLine());

        int [] array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < n ; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);

        int start = 0;
        int last = n - 1;
        int cnt = 0;

        while(start < last) {

            int sum = array[start] + array[last];
            if(sum == m) {
                cnt++;
                start++;
            }
            else if(sum < m)
                start++;
            else
                last--;
        }
        System.out.println(cnt);
    }
}