
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

	private static int n,m;

	private static int getBlueLayCount(int[] sum, int blueLaySize) {
		int blueLayCnt = 1;
		int lastBlueLayValue = 0;

		for (int i = 1; i <= n; i++) {
			if (sum[i] - lastBlueLayValue > blueLaySize) {
				blueLayCnt++;
				lastBlueLayValue = sum[i - 1];
				i--;
			}
		}
		return blueLayCnt;
	}

	private static int getMinBLueLay(int[] sum, int total, int max) {

		int start = max;
		int last = total;
		int result = total;

		while (start <= last) {
			int mid = (start + last) / 2;
			int bluelayCount = getBlueLayCount(sum, mid);

			// System.out.println("start :" + start + " mid :" + mid + " last :" + last + " bluelayCount :" + bluelayCount);
			if (start == mid && mid == last && result == total)
				result = mid;

			if (bluelayCount < m) {
				last = mid - 1;
			}
			else if (bluelayCount > m) {
				start = mid + 1;
			}
			else {
				if (result > mid)
					result = mid;
				last = mid - 1;
			}
		}
		return result;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n =  Integer.parseInt(st.nextToken());
		m =  Integer.parseInt(st.nextToken());
		int max = 0;

		st = new StringTokenizer(br.readLine());
		int[] input = new int[n + 1];
		int[] sum = new int[n + 1];
		int total = 0;

		for (int i = 1 ; i <= n ; i++) {
			input[i] =  Integer.parseInt(st.nextToken());
			total += input[i];
			sum[i] = sum[i - 1] + input[i];
			if (input[i] > max) {
				max = input[i];
			}
		}

		System.out.println(getMinBLueLay(sum , total, max));
		// System.out.println(getBlueLayCount(sum, 17));
	}
}
