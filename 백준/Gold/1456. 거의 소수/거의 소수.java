import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        boolean arr[] = new boolean[10000001];

        for(int i = 2 ; i <= 10000000; i++) {
            if(arr[i])
                continue;

            for(int j = i + i ; j <= 10000000 ; j+=i) {
                arr[j] = true;
            }
        }
        long count =  0;
        for(int i = 2 ; i <= 10000000 ; i++) {

            if (arr[i])
                continue;
            long tmp = i;
            while ((double) i <= (double) m / (double) tmp) {
                if( (double)i >= (double) n / (double) tmp)
                    count++;
                tmp *= i;
            }
        }

        System.out.println(count);


    }
}
