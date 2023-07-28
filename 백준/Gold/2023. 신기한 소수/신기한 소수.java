import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static boolean isPrime(int num) {

        for(int i = 2 ; i <= num / 2 ; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
    public static void DFS(int num, int i, int n) {

        if (i == n){
            if(isPrime(num))
                System.out.println(num);
            return ;
        }
        for(int k = 1 ; k < 10 ; k++) {
            if (k % 2 == 0)
                continue;
            if (isPrime(num * 10 + k))
                DFS(num * 10 + k, i + 1, n);
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        DFS(2,1,n);
        DFS(3,1,n);
        DFS(5,1,n);
        DFS(7,1,n);

    }
}