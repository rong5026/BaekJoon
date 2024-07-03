import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

	private static int checkSeperatedCount(int input[], int valid) {

		int sum = 0;
		int count = 0;

		for (int i = 0 ; i < input.length ; i++) {
			if (sum + input[i] < valid) {
				sum += input[i];
			}
			else {
				if (i != input.length - 1) {
					sum = 0;
					count++;
					i--;
				}
			}
		}
		return count;
	}
	public static int findBlueLay(int arr[], int value) {


		int count = 0;
		int sum = 0;
		for(int i = 0 ; i < arr.length ; i++) {

			if( sum + arr[i] <= value) {
				sum += arr[i];
				if( i == arr.length - 1)
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
	private static int binarySearch(int input[], int sum, int max, int m) {

		int start = max;
		int last = sum;
		int result = 0;

		while (start <= last) {
			int mid = (start + last) /2;

			int seperatedCount = findBlueLay(input, mid);
			if (start == last && last == mid && result == 0)
				result = mid;

			if (seperatedCount > m) {
				start = mid + 1;
			}
			else if (seperatedCount < m) {
				last = mid - 1;
			}
			else {
				result = mid;
				last = mid - 1;
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int input[] = new int[n];

		int max = 0;
		int sum = 0;
		st = new StringTokenizer(br.readLine());

		for (int i = 0 ; i < n ; i++) {
			input[i] = Integer.parseInt(st.nextToken());

			if (input[i] > max) {
				max = input[i];
			}
			sum += input[i];
		}

		System.out.println(binarySearch(input, sum, max, m));


	}
}