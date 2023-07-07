import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);

        int number = input.nextInt();

        int cnt = 0;

        while(number >= 5)
        {
            cnt += number /5;
            number /= 5;
        }
        System.out.println(cnt);



    }
}