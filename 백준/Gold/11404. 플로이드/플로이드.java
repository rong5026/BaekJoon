import com.sun.source.tree.Tree;

import java.io.*;
import java.nio.Buffer;
import java.util.*;



public class Main {

	static int n;
	static int m;
	static int distance[][];

	static int MAX_VALUE = 100000000;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		distance = new int[n + 1][n + 1];

		for (int i = 1 ; i <= n ; i++) {
			for (int j = 1; j <= n ; j++) {

				if (i == j) {
					distance[i][j] = 0;
				}
				else {
					distance[i][j] = MAX_VALUE;
				}
			}
		}

		for (int i = 0 ; i < m ; i++) {
			String input[] = br.readLine().split(" ");
			int start =  Integer.parseInt(input[0]);
			int last = Integer.parseInt(input[1]);
			int value = Integer.parseInt(input[2]);

			if (distance[start][last] > value)
				distance[start][last] = value;
		}

		for (int k = 1 ; k <= n ; k++) { // 노드 수
			for (int i = 1 ; i <= n ; i++) { // 출발 노드
				for (int j = 1 ; j <= n ; j++) { // 도착 노드
					if (distance[i][j] > distance[i][k] + distance[k][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];
					}
				}
			}
		}

		for (int i = 1 ; i <= n ; i++) {
			for (int j = 1 ; j <= n ; j++){
				if (distance[i][j] == MAX_VALUE)
					bw.write("0 ");
				else
					bw.write(distance[i][j] + " ");
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();

	}
}
