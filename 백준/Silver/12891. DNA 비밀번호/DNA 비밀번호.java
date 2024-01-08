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

        st = new StringTokenizer(br.readLine());

        char charArr[] = st.nextToken().toCharArray();
        int intArr[] = new int[4];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < 4 ; i++) {
            intArr[i] = Integer.parseInt(st.nextToken());
        }

        int sumArr[] = new int[4];

        for (int i = 0 ; i < m ; i++) {
            if (charArr[i] == 'A')
                sumArr[0]++;
            else if (charArr[i] == 'C')
                sumArr[1]++;
            else if (charArr[i] == 'G')
                sumArr[2]++;
            else if (charArr[i] == 'T')
                sumArr[3]++;
        }

        int count = 0;

        int i = 0;
        while (i++ <= n - m) {

            // 유효성 검증
            boolean finish = true;
            for (int j = 0 ; j < 4 ; j++) {
                if (sumArr[j] < intArr[j]) {
                    finish = false;
                    break;
                }
            }
            if(finish) {
                count++;
            }

            // 앞에꺼 빼기
            if (charArr[i - 1] == 'A')
                sumArr[0]--;
            else if (charArr[i - 1] == 'C')
                sumArr[1]--;
            else if (charArr[i - 1] == 'G')
                sumArr[2]--;
            else if (charArr[i - 1] == 'T')
                sumArr[3]--;

            // 이동시 포함된 배열값 추가
            if (i != n - m + 1) {
                if (charArr[i + m - 1] == 'A')
                    sumArr[0]++;
                else if (charArr[i + m - 1] == 'C')
                    sumArr[1]++;
                else if (charArr[i + m - 1] == 'G')
                    sumArr[2]++;
                else if (charArr[i + m - 1] == 'T')
                    sumArr[3]++;
            }
        }

        System.out.println(count);


    }
}