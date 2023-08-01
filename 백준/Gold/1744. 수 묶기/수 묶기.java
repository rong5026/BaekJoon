import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        PriorityQueue<Integer> minusQueue = new PriorityQueue<>();
        PriorityQueue<Integer> plusQueue = new PriorityQueue<>(Collections.reverseOrder());
        int zeroCnt = 0;
        for(int i = 0 ; i < n ; i++) {
            int m = input.nextInt();
            if(m > 0)
                plusQueue.add(m);
            else if (m < 0)
                minusQueue.add(m);
            else
                zeroCnt++;
        }
        int sum = 0;

        while(minusQueue.size() != 1 && !minusQueue.isEmpty()) {
            int a = minusQueue.poll();
            int b = minusQueue.poll();
            sum += a * b;
        }
        while(plusQueue.size() != 1 && !plusQueue.isEmpty()) {
            int a = plusQueue.poll();
            int b = plusQueue.poll();

            if (a == 1 || b == 1)
                sum += a + b;
            else
                sum += a * b;
        }

        int plusValue = 0;
        int minusValue = 0;
        if(!minusQueue.isEmpty())
            minusValue = minusQueue.poll();
        if(!plusQueue.isEmpty())
            plusValue = plusQueue.poll();

        if (zeroCnt != 0) {
            sum += plusValue;
        }
        else {
            sum += minusValue + plusValue;
        }
        System.out.println(sum);

    }
}
