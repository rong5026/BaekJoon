
import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static void DFS(ArrayList<Integer> list[], int index, boolean visited[]) {
		if (visited[index])
			return ;

		visited[index] = true;

		for (int i : list[index]) {
			if (!visited[i])
				DFS(list, i, visited);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		ArrayList<Integer> list[] = new ArrayList[n + 1];

		for (int i = 1; i <= n ; i++) {
			list[i] = new ArrayList<>();
		}

		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			list[b].add(a);
		}

		boolean visit[] = new boolean[n + 1];
		int count = 0;

		for (int i = 1 ; i <=n ; i++) {
			if (!visit[i]) {
				count++;
				DFS(list, i, visit);
			}
		}
		System.out.println(count);


	}

}
