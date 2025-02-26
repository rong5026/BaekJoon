
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[] parent;

	private static int find(int a) {
		if (a == parent[a])
			return a;
		return parent[a] = find(parent[a]);
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a < b) {
			parent[b] = a;
		}
		else {
			parent[a] = b;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());

		parent = new int[n + 1];

		for (int i = 1 ; i <= n ; i++) {
			parent[i] = i;
		}

		for (int i = 1 ; i <= n ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1 ; j <= i - 1 ; j++) {
				int elem = Integer.parseInt(st.nextToken());
				if (elem == 1) {
					union(i, j);
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		int start = 0;

		for (int i = 0 ; i < m ; i++) {
			int elem = Integer.parseInt(st.nextToken());

			if (i == 0)
				start = find(elem);

			if (start != find(elem)) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
}
