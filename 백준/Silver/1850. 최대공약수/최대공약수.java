import org.w3c.dom.Node;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.*;


public class Main {


    private static long GCD(long a, long b) {

        if (b == 0)
            return a;
        return (GCD(b, a % b));
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");

        long n = Long.parseLong(input[0]);
        long m =  Long.parseLong(input[1]);
        long count = GCD(n,m);

        StringBuilder sb = new StringBuilder();

        while (count > 0) {
            sb.append("1");
            count--;
        }
        System.out.println(sb);

    }
}
