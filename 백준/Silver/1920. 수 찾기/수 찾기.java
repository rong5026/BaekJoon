import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int BinarySearch(int arr[] , int value) {
        int start = 0;
        int last = arr.length - 1;

        while(start <= last) {
            int mid = (start + last) / 2;

            if(value > arr[mid])
                start = mid + 1;
            else if(value < arr[mid])
                last = mid - 1;
            else
                return 1;
        }
        return 0;


    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());

        int arr1[] = new int[m];
        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < m ; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < m ; i++) {
            System.out.println(BinarySearch(arr, arr1[i]));
        }
    }
}
