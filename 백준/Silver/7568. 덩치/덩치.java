import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int [][] array = new int[n][2];


        for(int i = 0 ; i < n ; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            array[i][0] = Integer.parseInt(st1.nextToken());
            array[i][1] = Integer.parseInt(st1.nextToken());
        }

        ArrayList<Integer> result = new ArrayList<>();

        int cnt;

        for(int i = 0 ; i < n ; i++) {
            cnt = 1;
            for(int j = 0 ; j < n ; j++) {
                if (i != j){
                    if (array[i][0] < array[j][0] && array[i][1] < array[j][1])
                        cnt++;
                }
            }
            result.add(cnt);
        }

        for(int a : result)
            System.out.print(a + " ");
    }
}