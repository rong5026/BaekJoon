import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for( int i = 0; i < n ; i++) {

            String []str = br.readLine().split(" ");

            int m = Integer.parseInt(str[0]);

            String result = str[1];
            for(int j = 0 ; j < result.length() ; j++) {
                for(int k = 0; k < m ; k++) {
                    System.out.print(result.charAt(j));
                }
            }
            System.out.println();

        }

    }
}