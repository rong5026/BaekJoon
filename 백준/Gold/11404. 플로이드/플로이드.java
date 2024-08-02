import com.sun.source.tree.Tree;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
	static int MAX_VALUE = 100_000_00;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int map[][] = new int[n][n];

		// 2차원배열 초기화
		for (int i = 0; i < n; i++) {
			Arrays.fill(map[i], MAX_VALUE);
		}
		for (int i = 0 ; i < n ; i++) {
			map[i][i] = 0;
		}

		// 입력
		for (int i = 0 ; i < m ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[a - 1][b - 1] = Math.min(map[a - 1][b - 1], c);
		}

		for (int k = 0 ; k < n ; k++) {
			for(int i = 0 ; i < n ; i++) {
				for (int j = 0 ; j < n ; j++) {
					if (map[i][k] + map[k][j] < map[i][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for(int i = 0 ; i < n ; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == MAX_VALUE)
					bw.write("0 ");
				else
					bw.write(map[i][j] + " ");
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();
	}
}

