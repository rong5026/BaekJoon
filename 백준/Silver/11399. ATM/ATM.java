import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int sumArr[] = new int[n];

        sumArr[0] = arr[0];
        for (int i = 1; i < n ; i++) {
            sumArr[i] = arr[i] + sumArr[i - 1];
        }

        int resultSum = 0;

        for (int i = 0 ; i < n ; i++) {
            resultSum += sumArr[i];
        }

        System.out.println(resultSum);

    }
}