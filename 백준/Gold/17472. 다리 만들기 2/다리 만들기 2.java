import com.sun.source.tree.Tree;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;

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

	private static final int[] dx = {-1, 1, 0, 0};
	private static final int[] dy = {0, 0, -1, 1};

	static int n,m;
	static int board[][];
	static PriorityQueue<Edge> edges;
	static int islandCnt = 0;
	static boolean visited[][];
	static int parent[];


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		board = new int[n + 1][m + 1];
		visited = new boolean[n + 1][m + 1];
		edges = new PriorityQueue<>(Comparator.comparingInt((Edge e) -> e.value));


		// 입력값
		for (int i = 1 ; i <= n ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1 ; j <=m ; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 섬 번호로 구분
		for (int i = 1 ; i <= n ; i++) {
			for (int j = 1; j <= m ; j++) {
				if (board[i][j] == 1 && !visited[i][j]) {
					++islandCnt;
					BFS(i, j);
				}
			}
		}

		// 가능한 다리 Edge 리스트에 추가
		for (int i = 1 ; i <= n ; i++) {
			for (int j = 1; j <= m; j++) {
				if (board[i][j] != 0)
					checkValidBridgeAndAddEdge(i , j, board[i][j]);
			}
		}

		// 유니온 파인드 배열 초기화
		parent = new int[islandCnt + 1];
		for (int i = 1 ; i <= islandCnt ; i++) {
			parent[i] = i;
		}

		int sum = 0;

		while (!edges.isEmpty()) {
			Edge edge = edges.poll();
			if (find(edge.start) != find(edge.last)) {
				union(edge.start, edge.last);
				sum += edge.value;
			}
		}

		int parentValue = find(parent[1]);
		for (int i = 1; i <= islandCnt; i++) {
			if (parentValue != find(parent[i])) {
				System.out.println("-1");
				return;
			}
		}
		System.out.println(sum);
	}
	private static void BFS(int i, int j) {

		Queue<int []> queue = new LinkedList<>();

		queue.add(new int[]{i , j});
		visited[i][j] = true;
		board[i][j] = islandCnt; // 섬 번호 매기기

		while (!queue.isEmpty()) {
			int now[] = queue.poll();

			for (int index = 0 ; index < 4 ; index++) {
				int mx = now[1] + dx[index];
				int my = now[0] + dy[index];

				// 강 or 맵 밖 or 이미 방문
				if ((mx < 1 || my < 1 || mx > m || my > n)
					|| visited[my][mx]
					|| board[my][mx] == 0)
					continue;

				visited[my][mx] = true;
				board[my][mx] = islandCnt;
				queue.add(new int[]{my, mx});
			}
		}
	}

	private static void checkValidBridgeAndAddEdge(int y, int x, int startIsland) {

		int lenCount;

		for (int i = 0 ; i < 4 ; i++) {

			int mx = x + dx[i];
			int my = y + dy[i];
			lenCount = 0;

			while (!(mx < 1 || my < 1 || mx > m || my > n)) {

				if (board[my][mx] == 0) {
					lenCount++;
				}
				else {
					if (lenCount >= 2) {
						edges.add(new Edge(startIsland, board[my][mx], lenCount));
					}
					break;
				}
				mx += dx[i];
				my += dy[i];
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

		if (a < b) {
			parent[b] = a;
		}
		else {
			parent[a] = b;
		}
	}

}
