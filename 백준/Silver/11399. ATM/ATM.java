import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int input[] = new int[n];
		int sumArray[] = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0 ; i < n ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(input);

		int m = n;
		int sum = 0;
		for (int i = 0 ; i < n ; i++) {
			sum += m * input[i];
			m--;
		}

		System.out.println(sum);

	}
}
