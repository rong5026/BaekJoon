import com.sun.source.tree.Tree;


import java.io.*;
import java.nio.Buffer;
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		distance = new long[n + 1];
		edges = new Edge[m + 1];

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[1] = 0L;

		for (int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int last = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

			edges[i] = new Edge(start, last, value);
		}

		// 최소 경로 확인
		for (int i = 1 ; i < n ; i++) {
			for (int j = 0 ; j < m ; j++) {
				Edge edge = edges[j];

				if (distance[edge.start] != Integer.MAX_VALUE
					&& distance[edge.last] > edge.value + distance[edge.start]) {
					distance[edge.last] = edge.value + distance[edge.start];
				}
			}
		}

		// 음수 여부 확인
		boolean isMinus = false;
		for (int j = 0 ; j < m ; j++) {
			Edge edge = edges[j];

			if (distance[edge.start] != Integer.MAX_VALUE
				&& distance[edge.last] > edge.value + distance[edge.start]) {
				isMinus = true;
			}
		}

		// 결과 도출
		if (isMinus) {
			System.out.println("-1");
			return ;
		}

		for (int i = 2 ; i <= n ; i++) {
			if (distance[i] == Integer.MAX_VALUE) {
				bw.write("-1\n");
			}
			else {
				bw.write(distance[i] + "\n");
			}
		}

		bw.flush();
		bw.close();
	}
}









