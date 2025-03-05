
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Edge {
	int start,last,price;

	public Edge(int start, int last, int price) {
		this.start = start;
		this.last = last;
		this.price = price;
	}
}


public class Main {

	private static void bfs(int start, ArrayList<Integer>[] list, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);

		while (!queue.isEmpty()) {
			int now = queue.poll();
			visited[now] = true;

			for (int next: list[now]) {
				if (!visited[next]) {
					queue.add(next);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		int last = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		ArrayList<Integer> list[] = new ArrayList[n];
		ArrayList<Integer> check = new ArrayList<>();
		boolean visited[] = new boolean[n];

		Edge[] edges = new Edge[m + 1];
		long[] prices = new long[n];
		long[] pay = new long[n];

		for (int i = 0 ; i < n ; i++) {
			if (i != start) {
				prices[i] = Integer.MIN_VALUE;
			}
			list[i] = new ArrayList<>();
		}

		for (int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());

			edges[i] = new Edge(s, l, price);
			list[s].add(l);
		}

		// 돈벌이
		st = new StringTokenizer(br.readLine());
		for (int i = 0 ; i <n ; i++) {
			pay[i] = Integer.parseInt(st.nextToken());
		}

		prices[start] = pay[start];

		for (int i = 1; i < n ; i++) {
			for (int j = 0 ; j < m ; j++) {
				Edge edge = edges[j];

				if (prices[edge.start] != Integer.MIN_VALUE &&
				prices[edge.last] < prices[edge.start] - edge.price + pay[edge.last]) {
					prices[edge.last] = prices[edge.start] - edge.price + pay[edge.last];
				}
			}
		}

		for (int j = 0 ; j < m ; j++) {
			Edge edge = edges[j];

			if (prices[edge.start] != Integer.MIN_VALUE &&
				prices[edge.last] < prices[edge.start] - edge.price + pay[edge.last]) {
				check.add(edge.last);

			}
		}

		if (prices[last] == Integer.MIN_VALUE) {
			System.out.println("gg");
			return;
		}

		if (!check.isEmpty()) {
			for (int i = 0 ; i < check.size() ; i++) {
				int elem = check.get(i);
				bfs(elem, list, visited);

				if (visited[last]) {
					System.out.println("Gee");
					return;
				}
			}
		}
		System.out.println(prices[last]);

	}
}
