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
	static int n;


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());

		distance = new int[n + 1][n + 1];

		for (int i = 1 ; i <= n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				distance[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int k = 1 ; k <= n ; k++) {
			for (int i = 1 ; i <= n ; i++) {
				for (int j = 1; j <= n ; j++) {
					if (distance[i][k] == 1 && distance[k][j] == 1) {
						distance[i][j] = 1;
					}
				}
			}
		}

		for (int i = 1 ; i <= n ; i++) {
			for (int j = 1; j <= n ; j++) {
				bw.write(distance[i][j] + " ");
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();
	}
}
