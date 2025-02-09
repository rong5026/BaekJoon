
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	private static ArrayList<Integer> list[];
	private static boolean[] visited;
	private static boolean isResultExist = false;

	private static void DFS(int node, int depth) {
		if (depth == 5) {
			isResultExist = true;
			return;
		}
		visited[node] = true;
		for (int elem : list[node]) {
			if (!visited[elem]) {
				DFS(elem, depth + 1);
			}
		}
		visited[node] = false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		list = new ArrayList[n];
		visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		for (int i = 0; i < n; i++) {
			if (isResultExist) {
				break;
			}
			DFS(i, 1);
		}

		if (isResultExist) {
			System.out.println("1");
		}
		else {
			System.out.println("0");
		}

	}
}
