import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] array = new int[3];
        int[] result = new int[10];

        for(int i = 0; i < 3 ; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        int sum = array[0] * array[1] * array[2];

        String line = String.valueOf(sum);

        char [] hong = line.toCharArray();

        for (int i = 0 ; i < hong.length ; i++)
        {
            int index = hong[i] -'0';
            result[index] += 1;
        }

        for(int i = 0; i < 10 ; i++) {
            System.out.println(result[i]);
        }


    }
}