import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = input.nextInt();
        int m = input.nextInt();


        int size = m - n + 1;
        int arr[] = new int[size];

        int j = 0;
        for(int i = n ; i <= m ; i++) {
            arr[j++] = i;
        }

        if(arr[0] == 1)
            arr[0] = -1;
        for(int i = 2 ; i <=Math.sqrt(m) ; i++) {

            for(int k = 0 ; k < size ; k++) {

                if(arr[k] == -1)
                    continue;

                if(arr[k] % i == 0 && arr[k] / i != 1)
                    arr[k] = -1;
            }
        }
        for(int i = 0 ; i < size ; i++)
        {
            if(arr[i] != -1)
                bw.write(arr[i] + "\n");
        }

        bw.flush();
        bw.close();


    }
}
