import com.sun.source.tree.Tree;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static ArrayList<Integer> list[];
	private static int answer[];

	private static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		list = new ArrayList[n + 1];
		answer = new int[n + 1];
		visited = new boolean[n + 1];

		for (int i = 1 ; i <= n ; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int last = Integer.parseInt(st.nextToken());

			list[start].add(last);
			list[last].add(start);
		}

		dfs(1);

		for (int i = 2 ; i <= n ; i++) {
			bw.write(answer[i] + "\n");
		}

		bw.flush();
		bw.close();
	}

	public static void dfs(int index) {
		visited[index] = true;

		for (int elem : list[index]) {
			if (!visited[elem]) {
				answer[elem] = index;
				dfs(elem);
			}
		}
	}
}
