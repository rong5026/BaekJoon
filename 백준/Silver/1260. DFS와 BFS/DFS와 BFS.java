
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	private static boolean visited[];
	private static ArrayList<Integer> list[];

	private static void DFS(int start) {
		visited[start] = true;
		System.out.print(start + " ");
		for (int elem : list[start]) {
			if (!visited[elem]) {
				DFS(elem);
			}
		}
	}

	private static void BFS(int start) {
		Queue<Integer> queue = new LinkedList<>();
		visited[start] = true;
		queue.add(start);

		while (!queue.isEmpty()) {
			int elem = queue.poll();
			System.out.print(elem + " ");
			for (int next : list[elem]) {
				if (!visited[next]) {
					visited[next] = true;
					queue.add(next);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		list = new ArrayList[n + 1];

		for (int i = 1 ; i <= n ; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1 ; i <= m ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			list[b].add(a);
		}

		for (int i = 1 ; i <= n ; i++) {
			Collections.sort(list[i]);
		}

		visited = new boolean[n + 1];
		DFS(v);
		System.out.println();
		visited = new boolean[n + 1];
		BFS(v);
	}
}



