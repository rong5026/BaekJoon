import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static int n,m, result;

    public static int getCorrectNum(int arr[], int mid) {

        int count = 0;
        int sum = 0;
        for(int i = 0 ; i < n ; i++) {

            if( sum + arr[i] <= mid) {
                sum += arr[i];
                if( i == n - 1)
                    count++;
            }
            else {
                count++;
                sum = 0;
                i--;
            }
        }
        return count;
    }
    public static void BinarySearch(int arr[], int start, int last) {

        int mid = 0;
        int cnt = 0;
        while(start <= last) {
            mid = (start + last) / 2;

            int needValue = getCorrectNum(arr, mid);
//            System.out.println(mid + " " + needValue);
//            cnt++;
//            if (cnt == 5)
//                break;
            if (start == last && last == mid && result == 0)
                result = mid;
            if (needValue == m){
                result = mid;
                last = mid - 1;
            }
            else if( needValue < m) {
                last = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str[] = br.readLine().split(" ");

        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        StringTokenizer st = new StringTokenizer(br.readLine());

        int arr[] = new int[n];
        int max = 0;
        int sum = 0;
        result = 0;

        for(int i = 0 ; i < n ; i++) {
            arr[i]= Integer.parseInt(st.nextToken());
            if (arr[i] > max)
                max = arr[i];
            sum += arr[i];
        }
        BinarySearch(arr, max, sum);
        System.out.println(result);

    }
}
