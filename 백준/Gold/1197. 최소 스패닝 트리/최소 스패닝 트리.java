import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class hNode implements Comparable<hNode>{
	int start,last, value;

	public hNode(int start, int last, int value) {
		this.start = start;
		this.last = last;
		this.value = value;
	}

	@Override
	public int compareTo(hNode o) {
		return this.value - o.value;
	}
}

public class Main {
	private static int parent[];
	private static PriorityQueue<hNode> queue;

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
		int m = Integer.parseInt(st.nextToken());

		parent = new int[n + 1];
		queue = new PriorityQueue<>(Comparator.comparingInt(hNode -> hNode.value));

		for (int i = 1; i <= n ; i++ ) {
			parent[i] = i;
		}

		for (int i = 1 ; i <= m ; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int last = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			queue.add(new hNode(start, last, value));
		}

		long sum = 0;
		int i = 0;
		while (i < n - 1 && !queue.isEmpty()) {
			hNode elem = queue.poll();

			if (find(elem.start) != find(elem.last)) {
				sum += elem.value;
				union(elem.start, elem.last);
				i++;
			}

		}

		System.out.println(sum);
	}
}
