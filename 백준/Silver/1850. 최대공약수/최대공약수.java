import java.io.*;
import java.util.*;

public class Main {

    public static long gcd(long a, long b) {

        if (b == 0)
            return a;

        return gcd(b , a % b);
    }

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        long a = input.nextLong();
        long b = input.nextLong();

        long c = gcd(a, b);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(c > 0) {
            bw.write("1");
            c--;
        }
        bw.flush();
        bw.close();




    }
}
