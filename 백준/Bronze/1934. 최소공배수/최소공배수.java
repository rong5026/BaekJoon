import org.w3c.dom.Node;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.*;


public class Main {

    private static int GCD(int a, int b) {

        if (b == 0)
            return a;
        return GCD(b, a % b);
    }

    private static int LCM(int a, int b) {
        return a * b / GCD(a,b);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(LCM(a,b));
        }
    }
}
