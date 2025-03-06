import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int start, last, value;

	public Edge(int start, int last, int value) {
		this.start = start;
		this.last = last;
		this.value = value;
	}

	@Override
	public int compareTo(Edge o) {
		return this.value - o.value;
	}

}

public class Main {

	private static int dx[] = {1, -1, 0, 0};
	private static int dy[] = {0, 0, 1, -1};
	private static int [][]map;
	private static int n,m;
	private static boolean visited[][];
	private static int[] parent;
	private static PriorityQueue<Edge> edges;

	private static boolean checkValidMap(int i, int j) {
		if ((1 <= i && i <= n) && (1 <= j && j <= m) ) {
			return true;
		}
		return false;
	}

	private static void findIsland(int i, int j, int islandCount) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {i, j});

		while (!queue.isEmpty()) {

			int[] elem = queue.poll();
			int y = elem[0];
			int x = elem[1];

			visited[y][x] = true;
			map[y][x] = islandCount;

			for (int k = 0 ; k < 4; k++) {
				int mx = x + dx[k];
				int my = y + dy[k];

				if (checkValidMap(my, mx) && map[my][mx] == -1) {
					queue.add(new int[] {my, mx});
				}
			}
		}
	}

	private static void checkValidBridgeAndAddEdge(int i, int j) {
		int count = 0;

		for (int k = 0 ; k < 4 ; k++ ){
			count = 0;
			int mx = j + dx[k];
			int my = i + dy[k];
			if (checkValidMap(my, mx) && map[my][mx] == 0) {
				while (checkValidMap(my, mx) && map[my][mx] == 0) {
					my += dy[k];
					mx += dx[k];
					count++;
				}

				if (checkValidMap(my, mx) && map[my][mx] != 0 && count >= 2) {
					edges.add(new Edge(map[i][j], map[my][mx], count));
				}
			}
		}
	}

	private static int find(int a) {
		if (a == parent[a])
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
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n + 1][m + 1];
		visited = new boolean[n + 1][m + 1];
		edges = new PriorityQueue<>();

		// input
		for (int i = 1 ; i <= n ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m ; j++) {
				int elem = Integer.parseInt(st.nextToken());
				if (elem == 1){
					map[i][j] = -1;
				}
				else {
					map[i][j] = elem;
				}
			}
		}

		int islandCount = 0;

		// 섬 번호 매기기
		for (int i = 1 ; i <= n ; i++) {
			for (int j = 1 ; j <= m ; j++) {
				if (map[i][j] == -1 && !visited[i][j]) {
					findIsland(i, j, ++islandCount);
				}
			}
		}

		// 섬출력
		// for (int i = 1 ; i <= n ; i++) {
		// 	for (int j = 1; j <= m ; j++) {
		// 		System.out.print(map[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }

		// 조건에 맞는 다리 Edge 리스트에 추가
		for (int i = 1 ; i <= n ; i++) {
			for (int j = 1; j <= m; j++) {
				if (map[i][j] != 0) {
					checkValidBridgeAndAddEdge(i, j);
				}
			}
		}

		// 유니온파인드 부모 배열 초기화
		parent = new int[islandCount + 1];
		for (int i  = 1 ; i <= islandCount ; i++) {
			parent[i] = i;
		}

		int result = 0;

		while (!edges.isEmpty()) {
			Edge edge = edges.poll();

			if (find(edge.start) != find(edge.last)) {
				union(edge.start, edge.last);
				result += edge.value;
			}
		}

		int value = find(parent[1]);
		for (int i = 2 ; i <= islandCount ; i++ ){
			if (value != find(parent[i])) {
				System.out.println("-1");
				return;
			}
		}
		System.out.println(result);




	}
}
