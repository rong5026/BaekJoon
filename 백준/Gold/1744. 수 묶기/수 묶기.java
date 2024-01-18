import org.w3c.dom.Node;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int zero = 0;
        // 음수 음수  , 0 음수 , 양수 양수

        PriorityQueue<Integer> posNum = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negNum = new PriorityQueue<>();

        for (int i = 0 ; i < n ; i++) {

            int num = Integer.parseInt(br.readLine());

            if (num > 0)
                posNum.add(num);
            else if (num < 0)
                negNum.add(num);
            else
                zero++;
        }

        int sum = 0;

        while (posNum.size() >= 2) {
            int a = posNum.poll();
            int b = posNum.poll();

            if (a == 1 || b == 1)
                sum += (a + b);
            else
                sum += a * b;
        }

        while (negNum.size() >= 2) {
            int a = negNum.poll();
            int b = negNum.poll();
            sum += a * b;
        }

        if (!negNum.isEmpty()) {
            if (zero == 0) {
                sum += negNum.poll();
            }
        }

        if (!posNum.isEmpty()) {
            sum += posNum.poll();
        }

        System.out.println(sum);

    }
}