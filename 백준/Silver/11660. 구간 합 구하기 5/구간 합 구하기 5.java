import com.sun.source.tree.Tree;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int arr[][] = new int[n + 1][n + 1];
		int sumArray[][] = new int[n + 1][n + 1];

		// 배열 초기화
		for (int i = 1 ; i <= n ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1 ; j <= n ; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
				sumArray[i][j] = arr[i][j] + sumArray[i - 1][j] + sumArray[i][j - 1] - sumArray[i - 1][j - 1];
			}
		}

		for (int i = 1 ; i <= m ; i++){
			String input[] = br.readLine().split(" ");
			int x1 = Integer.parseInt(input[0]);
			int y1 = Integer.parseInt(input[1]);
			int x2 = Integer.parseInt(input[2]);
			int y2 = Integer.parseInt(input[3]);
			int result = sumArray[x2][y2] - sumArray[x2][y1 - 1] - sumArray[x1 -1][y2] + sumArray[x1 - 1][y1 - 1];

			bw.write(result + "\n");
		}

		bw.flush();
		bw.close();


	}
}
