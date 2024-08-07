

import com.sun.source.tree.Tree;

import java.io.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class hNode {
	int start, last, value;

	public hNode(int start, int last, int value) {
		this.start = start;
		this.last = last;
		this.value = value;
	}
}

public class Main {

	private static int dx[] = {1, 0, -1, 0};
	private static int dy[] = {0, 1, 0, -1};
	private static int map[][];
	private static int n, m;
	private static PriorityQueue<hNode> edges;
	private static int parent[];

	private static void bfs(int y, int x, int islandNum) {
		map[y][x] = islandNum;

		Queue<int []> queue = new LinkedList<>();

		queue.add(new int[] {y, x});

		while (!queue.isEmpty()) {

			int elem[] = queue.poll();

			for (int i = 0 ; i < 4 ; i++) {
				int Y = elem[0] + dy[i];
				int X = elem[1] + dx[i];

				if (0 <= Y && Y < n && 0 <= X && X < m) {
					if (map[Y][X] == -1) {
						queue.add(new int[]{Y, X});
						map[Y][X] = islandNum;
					}
				}
			}
		}
	}

	private static void addValidEdges(int index, int y, int x) {
		int length = 0;

		Queue<int []> queue = new LinkedList<>();

		queue.add(new int[]{y, x});

		while(!queue.isEmpty()) {
			int elem[] = queue.poll();

			int Y = elem[0] + dy[index];
			int X = elem[1] + dx[index];

			if (0 <= Y && Y < n && 0 <= X && X < m) {
				if (map[Y][X] == 0){
					queue.add(new int[]{Y, X});
					length++;
				}
				else {
					if (length >= 2)
						edges.add(new hNode(map[y][x], map[Y][X], length));
				}
			}
		}
	}
	private static void checkValidEdges(int y, int x){

		for (int i = 0 ; i < 4 ; i++) {
			int Y = y + dy[i];
			int X = x + dx[i];

			if (0 <= Y && Y < n && 0 <= X && X < m) {
				if (map[Y][X] == 0){
					addValidEdges(i, y, x);
				}
			}
		}
	}

	private static int find(int a) {
		if (parent[a] == a)
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

	private static int getResult(int islandNum) {
		int result = 0;

		while (!edges.isEmpty()) {
			hNode elem = edges.poll();
			if (find(elem.start) != find(elem.last)) {
				result += elem.value;
				union(elem.start, elem.last);
			}
		}

		for (int i = 2 ; i < islandNum ; i++) {
			if (find(parent[1]) != find(parent[i]))
				return -1;
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		// input
		for (int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < m ; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					map[i][j] = -1;
				}
			}
		}

		// 섬마다 번호 매기기
		int islandNum = 1;
		for (int i = 0 ; i < n ; i++) {
			for (int j = 0 ; j < m ; j++) {
				if (map[i][j] == -1) {
					bfs(i, j, islandNum);
					islandNum++;
				}
			}
		}

		// 연결할 수 있는 다리의 Edge를 저장
		edges = new PriorityQueue<>(Comparator.comparingInt(hNode -> hNode.value));
		for (int i = 0 ; i < n ; i++) {
			for (int j = 0 ; j < m ; j++) {
				if (map[i][j] != 0)
					checkValidEdges(i, j);
			}
		}

		parent = new int[islandNum];

		// union, find 배열 초기화
		for (int i = 1 ; i < islandNum ; i++) {
			parent[i] = i;
		}

		System.out.println(getResult(islandNum));


	}
}

