
import java.io.*;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int input[] = new int[n];

		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);

		int []sum = new int[n + 1];
		int result = 0;

		for (int i = 1; i <=n ; i++) {
			sum[i] = sum[i-1] + input[i - 1];
			result += sum[i];
		}

		System.out.println(result);
	}
}



