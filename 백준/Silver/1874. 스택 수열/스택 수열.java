import javax.print.DocFlavor;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int array[] = new int[n];

        for (int i = 0 ; i < n ; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<Integer>();

        StringBuilder sb = new StringBuilder();

        int cnt = 1;
        boolean result = true;

        for (int i = 0 ; i < n ; i++) {

            while (array[i] >= cnt) {
                stack.push(cnt);
                cnt++;
                sb.append("+\n");
            }

            int elem = stack.pop();

            if (elem == array[i]) {
                sb.append("-\n");
            }
            else {
                System.out.println("NO");
                result = false;
                break;
            }
        }

        if (result)
            System.out.println(sb.toString());

    }
}