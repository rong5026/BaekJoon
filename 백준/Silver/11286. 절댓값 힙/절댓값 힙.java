import javax.swing.*;
import java.io.*;
import java.nio.Buffer;
import java.sql.Array;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int first = Math.abs(o1);
            int second = Math.abs(o2);

            if (first == second)
                return o1 > o2 ? 1 : -1;
            else
                return first - second;
        });


        for(int i = 0 ; i < n ; i++) {
            int m = Integer.parseInt(br.readLine());

            if( m != 0) {
                queue.add(m);
            }
            else {
                if(queue.isEmpty())
                    System.out.println("0");
                else
                    System.out.println(queue.poll());
            }
        }
    }
}