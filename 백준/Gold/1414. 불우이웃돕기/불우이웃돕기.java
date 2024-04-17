import com.sun.source.tree.Tree;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

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

	static PriorityQueue<Edge> edges;
	private static int parent[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int totalSum = 0;
		parent = new int[n + 1];
		edges = new PriorityQueue<>(Comparator.comparingInt(hEdge->hEdge.value));

		// union find 배열 초기화
		for (int i = 1; i <= n ; i++) {
			parent[i] = i;
		}

		// 입력값 초기화
		for (int i = 1 ; i <= n ; i++) {
			String input = br.readLine();
			char[] inputArray = input.toCharArray();

			for (int j = 1 ; j <= n ; j++) {
				int value = changeCharToNum(inputArray[j - 1]);
				totalSum += value;
				if (i != j && value != 0)
					edges.add(new Edge(i, j, value));
			}
		}

		int minTotal = 0;
		while (!edges.isEmpty()) {

			Edge now = edges.poll();

			if (find(now.start) != find(now.last)) {
				union(now.start, now.last);
				minTotal += now.value;
			}
		}

		int parentIdx = find(1);
		for (int i = 1 ; i <= n ; i++) {
			if (parentIdx != find(parent[i])) {
				System.out.println("-1");
				return;
			}
		}

		System.out.println(totalSum - minTotal);
	}

	private static int find(int a) {
		if (parent[a] == a)
			return a;
		return parent[a] = find(parent[a]);
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}
	private static int changeCharToNum(char c) {

		if (c >= 'a' && c <='z')
			return c - 'a' + 1;
		else if (c >= 'A' && c <= 'Z')
			return c - 38;
		else
			return 0;
	}
}















