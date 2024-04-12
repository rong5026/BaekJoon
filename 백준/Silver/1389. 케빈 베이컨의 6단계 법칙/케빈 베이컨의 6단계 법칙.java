import com.sun.source.tree.Tree;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int distance[][];

	static int MAX_VALUE = 500001;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int result[] = new int[n + 1];

		distance = new int[n + 1][n + 1];

		// 초기화
		for (int i = 1 ; i <= n ; i++) {
			for (int j = 1 ; j <= n ; j++) {
				if (i == j) {
					distance[i][j] = 0;
				}
				else {
					distance[i][j] = MAX_VALUE;
				}
			}
		}

		for (int i = 1 ; i <= m ; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			distance[a][b] = 1;
			distance[b][a] = 1;

		}

		for (int k = 1 ; k <= n ; k ++) {
			for (int i = 1 ; i <= n ; i++) {
				for (int j = 1; j <=n ; j++) {
					if (distance[i][j] > distance[i][k] + distance[k][j])
						distance[i][j] = distance[i][k] + distance[k][j];
				}
			}
		}
		
		int minIdx = 0;
		int minSum = MAX_VALUE;
		
		for (int i = 1 ; i <= n ; i++) {
			for (int j = 1 ; j <=n ; j++) {
				if (distance[i][j] != MAX_VALUE)
					result[i] += distance[i][j];
			}
			
			if (minSum > result[i]){
				minSum = result[i];
				minIdx = i;
			}
		}

		System.out.println(minIdx);
	}
}
