
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	private static int dx[] = {0, 0, 1, -1};
	private static int dy[] = {1, -1, 0, 0};
	private static boolean visited[][];
	private static int n;
	private static int map[][];
	private static boolean checkValid(int mx, int my) {
		if (0 <= mx && mx < n && 0 <= my && my < n && !visited[my][mx] && map[my][mx] == 1)
			return true;
		return false;
	}
	private static int BFS(int y,int x) {
		int count = 1;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {y, x});
		visited[y][x] = true;

		while (!queue.isEmpty()) {
			int now[] = queue.poll();
			for (int i = 0; i < 4; i++) {
				int mx = now[1] + dx[i];
				int my = now[0] + dy[i];
				if (checkValid(mx, my)) {
					visited[my][mx] = true;
					count++;
					queue.add(new int[] {my, mx});
				}
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		ArrayList<Integer> resultList = new ArrayList<>();
		visited = new boolean[n][n];

		// input
		for (int i = 0 ; i < n ; i++) {
			String input[] = br.readLine().split("");
			for (int j = 0 ; j < n ; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}

		for (int i = 0 ; i < n ; i++) {
			for (int j = 0 ; j < n ; j++) {
				if (!visited[i][j] && map[i][j] != 0) {
					resultList.add(BFS(i, j));
				}
			}
		}
		Collections.sort(resultList);
		System.out.println(resultList.size());
		for (int elem : resultList) {
			System.out.println(elem);
		}

	}
}



