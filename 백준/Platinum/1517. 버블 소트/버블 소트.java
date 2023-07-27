import javax.swing.*;
import java.io.*;
import java.nio.Buffer;
import java.sql.Array;
import java.util.*;



public class Main {

    public static int []tmp;
    public static long result = 0;
    private static void merge_sort(int []arr, int start, int last) {

        if (last - start < 1)
            return;
        int mid = (start + last) / 2;

        merge_sort(arr, start, mid);
        merge_sort(arr, mid + 1, last);

        int i = start;
        int j = mid + 1;
        int k = start;

        while (i <= mid && j <= last) {
            if (arr[i] <= arr[j])
                tmp[k++] = arr[i++];
            else {
                tmp[k++] = arr[j++];
                result += (j - 1) - (k - 1);
            }
        }

        while (i <= mid)
            tmp[k++] = arr[i++];
        while (j <= last)
            tmp[k++] = arr[j++];
        for(int l = start ; l <= last ; l++) {
            arr[l] = tmp[l];
        }

    }
    public static void main(String[] args) throws IOException {

         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int n = Integer.parseInt(br.readLine());

         StringTokenizer st = new StringTokenizer(br.readLine());

         int arr[] = new int[n];
            tmp = new int[n];
         int i = 0;

         while(st.hasMoreTokens())
             arr[i++] = Integer.parseInt(st.nextToken());

         merge_sort(arr, 0 , n - 1);
            System.out.println(result);

    }
}