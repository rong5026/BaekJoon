
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge{
	int start;
	int last;
	int time;

	public Edge(int start, int last, int time) {
		this.start = start;
		this.last = last;
		this.time = time;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long dist[] = new long[n + 1];
		Edge edges[] = new Edge[m + 1];

		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0L;

		for (int i = 0  ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			edges[i] = new Edge(a, b, c);
		}

		for (int i = 1 ; i < n ; i++) {
			for (int j = 0 ; j < m ; j++) {
				Edge edge = edges[j];

				if (dist[edge.start] != Integer.MAX_VALUE
				&& dist[edge.last] > dist[edge.start] + edge.time) {
					dist[edge.last] = dist[edge.start] + edge.time;
				}
			}
		}

		boolean isTrue = false;

		for (int j = 0 ; j < m ; j++) {
			Edge edge = edges[j];

			if (dist[edge.start] != Integer.MAX_VALUE
				&& dist[edge.last] > dist[edge.start] + edge.time) {
				isTrue = true;
			}
		}

		if (isTrue) {
			System.out.println("-1");
		}
		else {
			for (int i = 2 ; i <= n ; i++) {
				if (dist[i] == Integer.MAX_VALUE)
					System.out.println("-1");
				else
					System.out.println(dist[i]);
			}
		}


	}
}