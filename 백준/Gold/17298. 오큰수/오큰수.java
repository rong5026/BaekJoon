import javax.swing.*;
import java.io.*;
import java.nio.Buffer;
import java.sql.Array;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int [] arr = new int[n];

        for(int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        int []result = new int[n];

        for(int i = 0 ; i < n ; i++) {

            if(stack.isEmpty()){
                stack.push(i);
            }
            else {

                while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                    result[stack.pop()] = arr[i];
                }
                stack.push(i);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0 ; i < n ; i++) {
            if (result[i] == 0)
                bw.write("-1 ");
            else
                bw.write(result[i] + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}