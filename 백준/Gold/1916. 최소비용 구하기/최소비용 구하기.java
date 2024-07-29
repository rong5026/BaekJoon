
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class hNode {
	int node, value;

	public hNode(int node, int value) {
		this.node = node;
		this.value = value;
	}
}
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		ArrayList<hNode> list[] = new ArrayList[n + 1];
		StringTokenizer st;
		for (int i = 1; i <= n ; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < m ; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

			list[a].add(new hNode(b, value));
		}

		st = new StringTokenizer(br.readLine());

		int start = Integer.parseInt(st.nextToken());
		int last = Integer.parseInt(st.nextToken());

		int price[] = new int[n + 1];

		for (int i = 1; i <= n ; i++) {
			if (start == i)
				price[i] = 0;
			else
				price[i] = Integer.MAX_VALUE;
		}

		PriorityQueue<hNode> queue = new PriorityQueue<>(Comparator.comparingInt(hNode->hNode.value));
		boolean visited[] = new boolean[n + 1];

		queue.add(new hNode(start, 0));

		while (!queue.isEmpty()) {
			hNode now = queue.poll();
			if (!visited[now.node]){
				visited[now.node] = true;

				for (hNode next : list[now.node]) {
					if (!visited[next.node] && price[next.node] > price[now.node] + next.value) {
						price[next.node] = price[now.node] + next.value;
						queue.add(new hNode(next.node, price[next.node]));
					}
				}
			}

		}
		System.out.println(price[last]);
	}
}