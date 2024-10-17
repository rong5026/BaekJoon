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

        StringTokenizer st = new StringTokenizer(br.readLine());

        int arr[] = new int[n];
        int result[] = new int[n];

        for (int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<Integer>();

        stack.push(0);

        for (int i = 1 ; i < n ; i++) {

            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {

                int index = stack.pop();
                result[index] = arr[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            result[index] = -1;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < n ; i++)
            sb.append(result[i]).append(" ");

        System.out.println(sb.toString());
    }
}