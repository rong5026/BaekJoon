import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        while(true) {

            if(isPalindrome(n) && isPrime(n)) {
                System.out.println(n);
                break;
            }
            n++;
        }



    }

    public static boolean isPalindrome(int n) {
        String str = Integer.toString(n);
        char arr[] = str.toCharArray();

        for(int i  = 0 ; i < arr.length / 2 ; i++) {
            if(arr[i] != arr[arr.length -i -1])
                return false;
        }
        return true;
    }
    public static boolean isPrime(int n) {
        if(n==1)
            return false;
        for(int i = 2 ; i <= Math.sqrt(n) ; i++) {
            if(n % i == 0)
                return false;
        }
        return true;
    }
}
