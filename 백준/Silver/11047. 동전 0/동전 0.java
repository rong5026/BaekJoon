import org.w3c.dom.Node;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.*;


public class Main {

    public static int getMaxIndex(int arr[], int num) {
        int start = 0;
        int last = arr.length - 1;

        int result = 0;

        while (start <= last) {
            int mid = (start + last) / 2;
            if (arr[mid]  > num) {
                last = mid - 1;
            }
            else {
                start = mid + 1;
                result = mid;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();

        int arr[] = new int[n];

        for (int i = 0 ; i < n ; i++) {
            arr[i] = input.nextInt();
        }

        int index = getMaxIndex(arr, m);
        int sum = 0;
        int count = 0;

        for (int i = index ; i >= 0 ; i--) {

            while (sum + arr[i] <= m) {
                sum += arr[i];
                count++;
            }
        }

        System.out.println(count);

    }
}