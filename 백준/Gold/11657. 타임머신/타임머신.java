import com.sun.source.tree.Tree;


import java.io.*;
import java.util.*;

class Edge {
	int start;
	int last;
	int value;

	public Edge(int start, int last, int value) {
		this.start = start;
		this.last = last;
		this.value = value;
	}
}

public class Main {

	static long distance[];
	static Edge edges[];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		edges = new Edge[m + 1];
		distance = new long[n + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[1] = 0L;

		for (int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int last = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

			edges[i] = new Edge(start, last, value);
		}

		for (int i = 1 ; i < n ; i++) {
			for (int j = 0 ; j < m ; j++) {
				Edge edge = edges[j];

				if (distance[edge.start] != Integer.MAX_VALUE &&
				distance[edge.last] > distance[edge.start] + edge.value) {
					distance[edge.last] = distance[edge.start] + edge.value;
				}
			}
		}

		boolean isCycle = false;
		// 음수 있는지 확인
		for (int i = 0; i < m ; i++) {

			Edge edge = edges[i];
			if (distance[edge.start] != Integer.MAX_VALUE &&
				distance[edge.last] > distance[edge.start] + edge.value) {
				isCycle = true;
				break;
			}
		}

		if (isCycle) {
			System.out.println("-1");
		}
		else {
			for (int i = 2 ; i <= n ; i++) {
				if (distance[i] == Integer.MAX_VALUE) {
					bw.write("-1\n");
				}
				else {
					bw.write(distance[i] + "\n");
				}
			}
		}

		bw.flush();
		bw.close();


	}
}