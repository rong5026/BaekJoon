
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class hNode implements Comparable<hNode>{
	int node, value;

	public hNode (int node, int value) {
		this.value = value;
		this.node = node;
	}

	@Override
	public int compareTo(hNode o) {
		return this.value - o.value;
	}
}

public class Main {
	private static ArrayList<hNode> list[];
	private static int[] distance;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		list = new ArrayList[n + 1];
		distance = new int[n + 1];
		visited = new boolean[n + 1];

		for (int i = 1; i <= n ; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i <= m ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list[a].add(new hNode(b, c));
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int last = Integer.parseInt(st.nextToken());

		for (int i = 1 ; i <= n ; i++) {
			if (start != i) {
				distance[i] = Integer.MAX_VALUE;
			}
		}

		PriorityQueue<hNode> queue = new PriorityQueue<>();
		queue.add(new hNode(start, 0));

		while (!queue.isEmpty()) {
			hNode elem = queue.poll();

			if (visited[elem.node]) {
				continue;
			}

			visited[elem.node] = true;

			for (hNode next: list[elem.node]) {
				if (distance[next.node] > distance[elem.node] + next.value) {
					distance[next.node] = distance[elem.node] + next.value;
					queue.add(new hNode(next.node, distance[next.node]));
				}
			}
		}

		System.out.println(distance[last]);
	}
}
