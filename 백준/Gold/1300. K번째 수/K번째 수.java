import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int k = input.nextInt();

        long start = 1;
        long last = k;
        long result = 0;

        while (start <= last) {
            long mid = (start + last) / 2;
            long cnt = 0;

            for(int i = 1 ; i <= n ; i++) {
                cnt += Math.min(mid/i , n);
            }

            if (cnt < k)
                start = mid + 1;
            else {
                result = mid;
                last = mid - 1;
            }
        }
        System.out.println(result);

    }
}
