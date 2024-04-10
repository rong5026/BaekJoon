import com.sun.source.tree.Tree;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int distance[][];
	static ArrayList<Integer> list[];
	static int n;
	private static void checkVisited(int i, int j) {

		Queue<Integer> queue = new LinkedList<>();
		boolean visited[] = new boolean[n + 1];

		queue.add(i);

		while (!queue.isEmpty()) {
			int value = queue.poll();
			visited[value] = true;
			for(int elem: list[value]) {

				if (elem == j) {
					System.out.print("1 ");
					return;
				}
				if (!visited[elem])
					queue.add(elem);
			}
		}
		System.out.print("0 ");
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		list = new ArrayList[n + 1];
		distance = new int[n + 1][n + 1];

		for (int i = 1 ; i <= n ; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1 ; i <= n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				int value = Integer.parseInt(st.nextToken());
				if (value == 1) {
					list[i].add(j);
				}
			}
		}

		for (int i = 1 ; i <= n ; i++) {
			for (int j = 1 ; j <=n ; j++) {
				checkVisited(i, j);
			}
			System.out.println();
		}



	}
}
