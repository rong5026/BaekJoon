
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Edge {
	int start, end, time;

	public Edge(int start, int end, int time) {
		this.start = start;
		this.end = end;
		this.time = time;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long[] distance = new long[n + 1];
		Edge edges[] = new Edge[m + 1];

		for(int i = 1 ; i <= n ; i++) {
			if (i != 1) {
				distance[i] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int last = Integer.parseInt(st.nextToken());

			edges[i] = new Edge(start, end, last);
		}

		for (int i = 1 ; i < n; i++) { // n-1까지 반복
			for (int j = 0 ; j < m ; j++) {
				Edge now = edges[j];
				if (distance[now.start] != Integer.MAX_VALUE
				 && distance[now.end] > distance[now.start] + now.time) {
					distance[now.end] = distance[now.start] + now.time;
				}
			}
		}

		boolean flag = false;

		for (int j = 0 ; j < m ; j++) {
			Edge now = edges[j];

			if (distance[now.start] != Integer.MAX_VALUE
			&& distance[now.end] > distance[now.start] + now.time) {
				flag = true;
			}
		}

		if (flag) {
			System.out.println("-1");
		}
		else {
			for (int i = 2; i <= n ; i++) {
				if (distance[i] == Integer.MAX_VALUE) {
					System.out.println("-1");
				}
				else {
					System.out.println(distance[i]);
				}
			}
		}

	}
}
