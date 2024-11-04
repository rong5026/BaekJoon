
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class hNode {
	int x,y;

	public hNode(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	private static int dx[] = {1, -1, 0, 0};
	private static int dy[] = {0, 0, 1, -1};
	private static 	int [][]input;

	private static int n,m;
	private static boolean [][]visited;


	private static boolean isValid(int x, int y) {
		if ((1 <= x  && x <= m) && (1 <= y && y <= n) && input[y][x] == 1)
			return true;
		return false;
	}
	private static void BFS(hNode node, int count) {
		Queue<hNode> queue = new LinkedList<>();
		visited[node.y][node.x] = true;
		queue.add(node);

		while(!queue.isEmpty()) {
			hNode now = queue.poll();

			for (int i = 0 ; i < 4 ; i++) {
				int mx = now.x + dx[i];
				int my = now.y + dy[i];

				if (isValid(mx, my) && !visited[my][mx]) {
					visited[my][mx] = true;
					input[my][mx] = input[now.y][now.x] + 1;
					queue.add(new hNode(mx, my));
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		input = new int[n + 1][m + 1];
		visited = new boolean[n + 1][m + 1];

		// 입력
		for (int i = 1 ; i <= n ; i++) {
			char elem[] = br.readLine().toCharArray();
			for (int j = 1 ; j <= m ; j++) {
				input[i][j] = elem[j - 1] - '0';
			}
		}

		BFS(new hNode(1,1), 1);

		System.out.println(input[n][m]);

	}
}



