import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class Main {

    public static int[] tmp;
    public static long result = 0;
    private static void merge(int arr[], int start, int last, int mid) {
        int i = start;
        int j = mid + 1;
        int k = start;

        while (i <= mid && j <= last) {
            if (arr[i] <= arr[j])
                tmp[k++] = arr[i++];
            else {
                tmp[k++] = arr[j++]; // swap 발생
                result += j - k;

            }

        }
        while (i <= mid)
            tmp[k++] = arr[i++];
        while (j <= last)
            tmp[k++] = arr[j++];
        for(int l = start ; l <=last ; l++) {
            arr[l] = tmp[l];
        }

//
    }
    private static void mergeSort(int arr[], int start, int last) {
        if (last - start < 1)
            return ;
        int mid = (start + last) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, last);
        merge(arr, start, last, mid);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        tmp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(arr, 0 , n - 1);
        System.out.println(result);

    }
}