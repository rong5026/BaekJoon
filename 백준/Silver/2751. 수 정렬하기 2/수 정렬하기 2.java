
import java.io.*;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	private static int result[];
	private static int idx = 0;

	private static void merge_sort(int[] input, int start, int last) {

		if (start == last) {
			return;
		}

		int mid = (start + last) / 2;

		merge_sort(input, start, mid);
		merge_sort(input, mid + 1, last);
		merge(input, start, mid, last);

	}


	private static void merge(int[] input, int start, int mid, int last) {

		int i = start;
		int j = mid + 1;
		int[] tmp = new int[last - start + 1];
		int index  = 0;

		while (i <= mid && j <= last) {
			if (input[i] < input[j]) {
				tmp[index++] = input[i++];
			}
			else {
				tmp[index++] = input[j++];
			}
		}

		while (i <= mid) {
			tmp[index++] = input[i++];
		}
		while (j <= last) {
			tmp[index++] = input[j++];
		}
		for (int k = 0; k < tmp.length; k++) {
			input[start++] = tmp[k];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int []input = new int[n];
		result = new int[n];

		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}

		merge_sort(input, 0, n - 1);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < n; i++) {
			bw.write(input[i] + "\n");
		}
		bw.flush();
		bw.close();
	}
}



