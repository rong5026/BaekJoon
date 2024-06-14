import com.sun.source.tree.Tree;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		long sum[] = new long[n + 1];
		long count[] = new long[m];
		long resultCnt = 0;

		st = new StringTokenizer(br.readLine());

		for (int i = 1 ; i <= n ; i++) {
			long elem = Long.parseLong(st.nextToken());
			sum[i] = sum[i - 1] + elem;
		}

		for (int i = 1; i <= n ; i++) {
			sum[i] %= m;

			if (sum[i] == 0) {
				resultCnt++;
			}
			count[(int)sum[i]]++;
		}

		for (int i = 0 ; i < m ; i++){
			if (count[i] >=2) {
				resultCnt += count[i] * (count[i] - 1) / 2;
			}
		}

		System.out.println(resultCnt);
	}
}
