
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long count[] = new long[m];
		long result = 0;

		st = new StringTokenizer(br.readLine());
		long sum[] = new long[n + 1];

		for (int i = 1 ; i <= n ; i++) {
			long elem = Long.parseLong(st.nextToken());
			sum[i] = sum[i - 1] + elem;
			sum[i] %= m;
		}

		for (int i = 1 ; i <= n ; i++) {
			if (sum[i] == 0) // 구간합 자기 자신일 경우
				result++;
			count[(int) sum[i]]++;
		}

		for (int i = 0 ; i < m ; i++) {
			if (count[i] >= 2) { // 다른 좌표들에서 nC2 선택하는 경우의 수
				result += count[i] * (count[i] - 1) / 2;
			}
		}

		System.out.println(result);


	}
}



