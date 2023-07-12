import javax.swing.*;
import java.io.*;
import java.nio.Buffer;
import java.sql.Array;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        int [] arr = new int[n];

        for(int i = 0 ; i < n ; i++)
            arr[i] = input.nextInt();

        int cnt = 1;
        boolean isResult = true;

        Stack<Integer> stack = new Stack<Integer>();

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < n ; i++) {

            while (arr[i] >= cnt) {
                stack.push(cnt);
                sb.append("+\n");
                cnt++;
            }
            int elem = stack.pop();

            if(elem != arr[i]){
                System.out.println("NO");
                isResult = false;
                break;
            }
            else
                sb.append("-\n");
        }

        if(isResult){
            System.out.println(sb.toString());
        }


    }
}