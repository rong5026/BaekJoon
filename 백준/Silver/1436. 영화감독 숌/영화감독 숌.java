import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        int num = 0;
        int count = 0;

        while(count < n) {
            num++;
            if (Integer.toString(num).contains("666"))
                count++;
        }
        System.out.println(num);
    }
}