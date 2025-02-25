
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class hNode{
	int node, len;

	public hNode(int node, int len) {
		this.node = node;
		this.len = len;
	}
}

public class Main {

	private static ArrayList<Integer> list[];
	private static boolean[] visited;
	private static int k;
	private static int[] result;

	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			Integer elem = queue.poll();

			for (int next : list[elem]) {
				if (!visited[next]) {
					visited[next] = true;
					queue.add(next);
					result[next] = result[elem] + 1;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		visited = new boolean[n + 1];
		list = new ArrayList[n + 1];
		result = new int[n + 1];

		for (int i = 1 ; i <= n ; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
		}

		bfs(x);
		boolean flag = false;

		for (int i = 1 ; i <= n ; i++) {
			if (result[i] == k) {
				System.out.println(i);
				flag = true;
			}
		}
		if (!flag) {
			System.out.println("-1");
		}
	}
}
