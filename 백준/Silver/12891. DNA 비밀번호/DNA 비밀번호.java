import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.sql.Array;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        StringTokenizer st = new StringTokenizer(br.readLine());

        char [] charArr = st.nextToken().toCharArray();

        st = new StringTokenizer(br.readLine());

        int [] intArr = new int[4];

        for(int i = 0 ; i < 4 ; i++) {
            intArr[i] = Integer.parseInt(st.nextToken());
        }


        int [] sumArr = new int[4];

        for(int i = 0 ; i < m ; i++){
            if(charArr[i] == 'A')
                sumArr[0]++;
            else if(charArr[i] == 'C')
                sumArr[1]++;
            else if(charArr[i] == 'G')
                sumArr[2]++;
            else if(charArr[i] == 'T')
                sumArr[3]++;
        }

        int i = 0;
        int resultCnt = 0;
        while (i <= n - m) {

            boolean isCheck = true;
            for(int j = 0 ; j < 4 ; j++){
               if ( sumArr[j] < intArr[j]){
                   isCheck = false;
                   break;
               }
            }
            if(isCheck) {
                resultCnt++;
            }
            // remove
            if(charArr[i] == 'A')
                sumArr[0]--;
            else if(charArr[i] == 'C')
                sumArr[1]--;
            else if(charArr[i] == 'G')
                sumArr[2]--;
            else if(charArr[i] == 'T')
                sumArr[3]--;

            if(i != n - m) {
                //add
                if(charArr[i+m] == 'A')
                    sumArr[0]++;
                else if(charArr[i+m] == 'C')
                    sumArr[1]++;
                else if(charArr[i+m] == 'G')
                    sumArr[2]++;
                else if(charArr[i+m] == 'T')
                    sumArr[3]++;
            }

            i++;
        }
        System.out.println(resultCnt);
    }
}