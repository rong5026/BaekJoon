import com.sun.source.tree.Tree;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		long arr[] = new long[n + 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 1 ; i <= n ; i++) {
			arr[i] = arr[i - 1] + Long.parseLong(st.nextToken());
		}

		for (int i = 0 ; i < m ; i++) {
			String input[] = br.readLine().split(" ");

			int first = Integer.parseInt(input[0]);
			int second = Integer.parseInt(input[1]);
			Long result = arr[second] - arr[first - 1];
			bw.write(result + "\n");
		}

		bw.flush();
		bw.close();
	}
}
