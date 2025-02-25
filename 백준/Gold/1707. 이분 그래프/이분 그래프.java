
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static ArrayList<Integer> list[];
	private static int[] group;
	private static boolean[] visited;
	private static boolean flag = true;

	private static void dfs(int elem) {
		visited[elem] = true;

		for (int next : list[elem]) {
			if (!visited[next]) {
				group[next] = (group[elem] + 1) % 2;
				dfs(next);
			}
			else {
				if (group[next] == group[elem]) {
					flag = false;
					break;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		for (int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			list = new ArrayList[n + 1];
			group = new int[n + 1];
			visited = new boolean[n + 1];
			flag = true;

			for (int j = 1 ; j <= n ; j++) {
				list[j] = new ArrayList<>();
			}

			for (int j = 1 ; j <= m ; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				list[a].add(b);
				list[b].add(a);
			}

			for (int j = 1; j <= n ; j++) {
				if (flag)
					dfs(j);
				else
					break;
			}

			if(flag) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}

		}

	}
}
