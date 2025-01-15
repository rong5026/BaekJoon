
import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	private static int array[] = new int[4];

	private static void plusValue(char c) {
		switch (c) {
			case 'A':
				array[0]++;
				break;
			case 'C':
				array[1]++;
				break;
			case 'G':
				array[2]++;
				break;
			case 'T':
				array[3]++;
			default:
				break;
		}
	}
	private static void minusValue(char c) {
		switch (c) {
			case 'A':
				array[0]--;
				break;
			case 'C':
				array[1]--;
				break;
			case 'G':
				array[2]--;
				break;
			case 'T':
				array[3]--;
			default:
				break;
		}
	}
	private static boolean checkValid(int value[]) {
		for (int i = 0 ; i < 4 ; i++) {
			if (array[i] < value[i])
				return false;
		}
		return true;
	}
	private static void sliceNext(char input[], int i, int m) {
		minusValue(input[i]);
		plusValue(input[i + m]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int value[] = new int[4];
		int count = 0;

		char input[] = br.readLine().toCharArray();
		for (int i = 0 ; i < m ; i++) {
			plusValue(input[i]);
		}

		st = new StringTokenizer(br.readLine());
		value[0] = Integer.parseInt(st.nextToken());
		value[1] = Integer.parseInt(st.nextToken());
		value[2] = Integer.parseInt(st.nextToken());
		value[3] = Integer.parseInt(st.nextToken());



		for (int i = 0 ; i < n - m ; i++) {
			if (checkValid(value))
				count++;
			sliceNext(input, i, m);
		}

		if (checkValid(value))
			count++;

		System.out.println(count);
	}
}



