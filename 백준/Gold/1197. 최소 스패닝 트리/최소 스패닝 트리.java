import com.sun.source.tree.Tree;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Edge {
	int start;
	int last;
	int value;

	public Edge(int start ,int last, int value) {
		this.value = value;
		this.start = start;
		this.last = last;
	}
}

public class Main {

	static PriorityQueue<Edge> edges;
	static int array[];

	static int parent[];

	public static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}
	public static int find(int a) {
		if (a == parent[a])
			return a;
		return parent[a] = find(parent[a]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		long sum = 0;
		edges = new PriorityQueue<>(Comparator.comparingInt(hEdge -> hEdge.value));
		array = new int[v + 1];
		parent = new int[v + 1];

		for (int i = 1 ; i <= e ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int last = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			edges.add(new Edge(start, last, value));
		}

		for (int i = 1 ; i <= v ; i++) {
			parent[i] = i;
		}

		// 로직 시작
		// for (int i = 1; i <= v ; i ++) {
		// 	Edge now = edges.poll();
		//
		// 	if (find(now.start) != find(now.start)) {
		// 		union(now.start, now.last);
		// 		sum += now.value;
		// 	}
		// }
		int i = 0;
		while (i < v - 1 && !edges.isEmpty()) {
			Edge now = edges.poll();
			if (find(now.start) != find(now.last)) {
				union(now.start, now.last);
				sum += now.value;
				i++;
			}
		}

		System.out.println(sum);


	}
}













