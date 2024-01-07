import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

//        Scanner input = new Scanner(System.in);
//
//        int n = input.nextInt();
//
//        String str = input.next();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String str = br.readLine();

        char [] array = str.toCharArray();
        long sum = 0;

        for(int i = 0 ; i < array.length ; i++) {
            sum += array[i] - '0';
        }

        System.out.println(sum);
    }
}