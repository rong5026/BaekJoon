import javax.print.DocFlavor;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr[][] = new int[n + 1][n + 1];
        int arrSum[][] = new int[n + 1][n + 1];


        for (int i = 1 ; i <= n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                arrSum[i][j] = arr[i][j] + arrSum[i][j - 1] + arrSum[i - 1][j] - arrSum[i - 1][j - 1];
            }
        }


        for (int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int [] input = new int[4];

            for(int j = 0 ; j < 4 ; j++)
                input[j] = Integer.parseInt(st.nextToken());

            int x1 = input[0];
            int y1 = input[1];
            int x2 = input[2];
            int y2 = input[3];

            int result = arrSum[x2][y2] - arrSum[x2][y1 - 1] - arrSum[x1 - 1][y2] + arrSum[x1 - 1][y1 - 1];
            System.out.println(result);

        }




    }
}