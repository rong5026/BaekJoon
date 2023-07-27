import javax.swing.*;
import java.io.*;
import java.nio.Buffer;
import java.sql.Array;
import java.util.*;



public class Main {

    public static int[] tmp;

    private static void merge(int arr[], int start, int last, int mid) {
        int i = start;
        int j = mid + 1;
        int k = start;

        while (i <= mid && j <= last) {
            if (arr[i] <= arr[j])
                tmp[k++] = arr[i++];
            else
                tmp[k++] = arr[j++];
        }
        while (i <= mid)
            tmp[k++] = arr[i++];
        while (j <= last)
            tmp[k++] = arr[j++];
        for(int l = start ; l <=last ; l++)
            arr[l] = tmp[l];
    }
    private static void merge_sort(int arr[], int start, int last) {

        if (last - start < 1)
            return ;
        int mid = (start + last) / 2;
        merge_sort(arr, start, mid);
        merge_sort(arr, mid + 1, last);
        merge(arr, start, last, mid);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(st.nextToken());
        int []arr = new int[n];
        tmp = new int[n];

        for( int i = 0 ; i < n ; i++) {
            arr[i]= Integer.parseInt(br.readLine());
        }
        merge_sort(arr, 0 , n - 1);
        for(int i = 0 ; i  < n ; i++)
            bw.write(arr[i] + "\n");
        bw.flush();
        bw.close();

    }
}