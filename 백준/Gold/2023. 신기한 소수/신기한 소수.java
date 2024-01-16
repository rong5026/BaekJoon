import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class Main {

    public static boolean isPrime(int number) {

        for (int i = 2 ; i <= number / 2 ; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public static void DFS(int number, int i, int n) {

        if (i == n) {
            if (isPrime(number))
                System.out.println(number);
        }
        else {
            for (int k = 1 ; k < 10 ; k++) {
                if (isPrime((number * 10) + k))
                    DFS((number * 10) + k, i + 1, n);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        DFS(2, 1, n);
        DFS(3, 1, n);
        DFS(5, 1, n);
        DFS(7, 1, n);

    }
}