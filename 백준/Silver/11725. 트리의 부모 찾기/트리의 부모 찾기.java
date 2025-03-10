

import com.sun.source.tree.Tree;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int result[];
	private static boolean visited[];
	private static ArrayList<Integer> list[];
	private static void dfs(int index) {

		visited[index] = true;

		for (int elem : list[index]) {
			if (!visited[elem]) {
				result[elem] = index;
				dfs(elem);
			}
		}
	}

	private static void bfs(int index) {

		Queue<Integer> queue = new LinkedList<>();
		queue.add(index);
		visited[index] = true;

		while (!queue.isEmpty()) {
			int elem = queue.poll();

			for (int i : list[elem]) {
				if (!visited[i]) {
					visited[i] = true;
					result[i] = elem;
					queue.add(i);
				}
			}

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		result = new int[n + 1];
		visited = new boolean[n + 1];
		list = new ArrayList[n + 1];

		for (int i = 1 ; i <= n ; i++) {
			list[i] = new ArrayList<>();
		}
		result[1] = 1;

		for (int i = 1 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		// dfs(1);
		bfs(1);
		for (int i = 2 ; i <= n ; i++){
			bw.write(result[i] + "\n");
		}
		bw.flush();
		bw.close();
	}
}
