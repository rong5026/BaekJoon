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
        long cnt = 0;
        long [] sum = new long[n];
        long [] count = new long[m];
        st = new StringTokenizer(br.readLine());

        sum[0] = Long.parseLong(st.nextToken());

        for(int i = 1 ; i < n ; i++) {
            sum[i] = sum[i-1] + Long.parseLong(st.nextToken());
        }

        for(int i = 0 ; i < n ; i++) {
            sum[i] %= m;
            if(sum[i] == 0)
                cnt++;
            count[(int) sum[i]]++;
        }

        for(int i = 0 ; i < m ; i++) {
            if(count[i] >= 2) {
                cnt += count[i] * (count[i] - 1) / 2;

            }
        }

        System.out.println(cnt);

    }
}