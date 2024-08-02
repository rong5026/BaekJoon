import com.sun.source.tree.Tree;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int map[][] = new int[n + 1][n + 1];

		for (int i = 1 ; i <= n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1 ; j <=n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int k = 1 ; k <= n ; k ++) {
			for (int i = 1 ; i <= n ; i++) {
				for (int j = 1 ; j <= n ; j ++) {
					if (map[i][k] == 1 && map[k][j] == 1) {
						map[i][j] = 1;
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 1 ; i <= n ; i++) {
			for (int j = 1 ; j <=n ; j++) {
				sb.append(map[i][j] +" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);


	}
}

