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
	static long price[];
	static boolean visited[];

	private static void bfs(ArrayList<Integer> list[], int endCity) {


		Queue<Integer> queue = new LinkedList<>();

		queue.add(endCity);

		while (!queue.isEmpty()) {

			int next = queue.poll();
			visited[next] = true;

			for (int a : list[next]) {
				if (!visited[a]) {
					queue.add(a);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		// 초기값
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int startCity = Integer.parseInt(st.nextToken());
		int lastCity = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		distance = new long[n];
		edges = new Edge[m];
		price = new long[n];
		visited = new boolean[n];
		ArrayList<Integer> checkList = new ArrayList<>();
		ArrayList<Integer> list[] = new ArrayList[n];

		Arrays.fill(distance, Integer.MIN_VALUE);


		for (int i = 0 ; i < n ; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int last = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken()) * (-1);

			list[start].add(last);
			edges[i] = new Edge(start, last, value);
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
		distance[startCity] = price[startCity];


		// 비용 계산
		for (int i = 0; i < m; i++) {
			Edge edge = edges[i];
			edge.value += price[edge.last];
		}

		for (int i = 1; i < n ; i++) {
			for (int j = 0; j < m; j++) {
				Edge edge = edges[j];

				if (distance[edge.start] != Integer.MIN_VALUE
					&& distance[edge.last] < edge.value + distance[edge.start]) {
					distance[edge.last] = edge.value + distance[edge.start];
				}
			}
		}

		for (int j = 0; j < m; j++) {
			Edge edge = edges[j];
			if (distance[edge.start] != Integer.MIN_VALUE
				&& distance[edge.last] < edge.value + distance[edge.start]) {
				checkList.add(edge.last);
			}
		}


		if (distance[lastCity] == Integer.MIN_VALUE) {
			System.out.println("gg");
			return;
		}

		if (!checkList.isEmpty()) {
			for (int i = 0 ; i < checkList.size() ; i++) {
				bfs(list, checkList.get(i));
				if (visited[lastCity]) {
					System.out.println("Gee");
					return;
				}
			}
		}
		System.out.println(distance[lastCity]);


	}
}

