import org.w3c.dom.Node;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split("-");

        int total = 0;
        for (int i = 0 ; i < input.length ; i++) {

            int sum = 0;

            String arr[] = input[i].split("\\+");

            for (int j = 0 ; j < arr.length ; j++) {
                sum += Integer.parseInt(arr[j]);
            }

            if (i == 0)
                total  = sum;
            else
                total -= sum;
        }

        System.out.println(total);
    }
}

















