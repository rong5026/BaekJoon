import javax.swing.*;
import java.io.*;
import java.nio.Buffer;
import java.sql.Array;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1 ; i <= n ; i++) {
            queue.add(i);
        }
        int i = 0;
        while(queue.size() != 1){
            int m = queue.poll();

            if (i % 2 == 1)
                queue.add(m);

            i++;
        }
        System.out.println(queue.peek());
    }
}