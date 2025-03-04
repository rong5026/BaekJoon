
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class hNode {
	int node, value;
	public hNode(int node, int value) {
		this.node = node;
		this.value = value;
	}
}

public class Main {

	private static ArrayList<hNode> list[];
	private static int[] map;

	private static void bfs(int start) {
		PriorityQueue<hNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.value));
		queue.add(new hNode(start, 0));

		while (!queue.isEmpty()) {
			hNode elem = queue.poll();
			for (hNode next: list[elem.node]) {
				if (map[next.node] > map[elem.node] + next.value) {
					map[next.node] = map[elem.node] + next.value;
					queue.add(new hNode(next.node, map[next.node]));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());


		// 초기화
		map = new int[n + 1];
		list = new ArrayList[n + 1];

		for (int i = 1 ; i <= n ; i++) {
			list[i] = new ArrayList<>();
			if (i != start) {
				map[i] = Integer.MAX_VALUE;
			}
		}

		// 입력
		for (int i = 1 ; i <= m ; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list[a].add(new hNode(b, c));
		}

		bfs(start);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 1; i <= n ; i++) {
			if (map[i] == Integer.MAX_VALUE) {
				bw.write("INF\n");
			}
			else {
				bw.write(map[i]+"\n");
			}
		}

		bw.flush();
		bw.close();

	}
}
