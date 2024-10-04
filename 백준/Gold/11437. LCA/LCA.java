
import java.io.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer> tree[];
	static int depth[];
	static int parent[];
	static boolean visited[];
	private static void BFS(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node] = true;

		int level = 1;
		int now_size =1;
		int count = 0;
		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int next : tree[now]) {
				if (!visited[next]) {
					visited[next] = true;
					queue.add(next);
					parent[next] = now;
					depth[next] = level;
				}
			}
			count++;
			if (count == now_size) {
				count = 0;
				now_size = queue.size();
				level++;
			}
		}
	}

	private static int excuteResult(int a, int b) {
		if (depth[a] < depth[b]) {
			int tmp = a;
			a = b;
			b = tmp;
		}

		while (depth[a] != depth[b]) {
			a = parent[a];
		}

		while (a != b) {
			a = parent[a];
			b = parent[b];
		}
		return a;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		tree = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		depth = new int[n + 1];
		parent = new int[n + 1];
		
		for (int i = 1 ; i <= n; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 0 ; i < n - 1 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			tree[a].add(b);
			tree[b].add(a);
		}

		BFS(1);

		int m = Integer.parseInt(br.readLine());

		for (int i = 0 ; i < m ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int result = excuteResult(a, b);
			System.out.println(result);
		}

	}
}



