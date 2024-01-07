import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());


        int sum = 0;
        int max = -1;

        for(int i = 0 ; i < n ; i++) {
            int score = Integer.parseInt(st.nextToken());
            if (score > max) {
                max = score;
            }
            sum += score;
        }

        double result = 100.0 * sum / n / max;
        System.out.println(result);
    }
}