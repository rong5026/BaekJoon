

import com.sun.source.tree.Tree;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

class hNode {
	int start, last, value;

	public hNode(int start, int last, int value) {
		this.start = start;
		this.last = last;
		this.value = value;
	}
}

public class Main {

	private static int parent[];

	private static int convertCharToInt(char c) {

		if ('a' <= c && c <= 'z')
			return c - 'a' + 1;
		else
			return c - 'A' + 27;
	}

	private static int find(int a) {
		if (a == parent[a])
			return a;
		return parent[a] = find(parent[a]);
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a > b)
			parent[a] = b;
		else
			parent[b] = a;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int map[][] = new int[n + 1][n + 1];
		int total = 0;

		PriorityQueue<hNode> list = new PriorityQueue<>(Comparator.comparingInt(hNode -> hNode.value));
		parent = new int[n + 1];

		// input
		for (int i = 1; i <= n; i++) {
			char input[] = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				if (input[j] == '0')
					map[i][j + 1] = 0;
				else
					map[i][j + 1] = convertCharToInt(input[j]);
				total += map[i][j + 1];
			}
		}

		for (int i = 1 ; i <= n ; i++) {
			parent[i] = i;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (map[i][j] != 0) {
					list.add(new hNode(i, j, map[i][j]));
				}
			}
		}

		while (!list.isEmpty()) {
			hNode elem = list.poll();
			if (find(elem.start) != find(elem.last)) {
				total -= elem.value;
				union(elem.start, elem.last);
			}
		}

		boolean isValid = true;
		for (int i = 2; i <= n ; i++) {
			if (find(parent[1]) != find(parent[i])) {
				isValid = false;
				break;
			}
		}

		if (!isValid)
			System.out.println("-1");
		else
			System.out.println(total);

	}
}

