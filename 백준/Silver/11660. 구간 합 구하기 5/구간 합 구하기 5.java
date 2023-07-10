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

        int [][] arr = new int[n + 1][n + 1];

        for(int i = 1 ; i <= n ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= n ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int [][] hong = new int[n + 1][n + 1];

        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1 ; j <= n ; j++) {
                hong[i][j] = arr[i][j] + hong[i - 1][j] + hong[i][j - 1] - hong[i - 1][j - 1];
            }
        }

        for(int i = 0 ; i < m ; i++) {
            int [] input = new int[4];
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 4 ; j++)
                input[j] = Integer.parseInt(st.nextToken());
            int x1 = input[0];
            int y1 = input[1];
            int x2 = input[2];
            int y2 = input[3];

            int result = hong[x2][y2] - hong[x1 - 1][y2] - hong[x2][y1 - 1] + hong[x1 - 1][y1 -1];
            System.out.println(result);

        }

    }
}