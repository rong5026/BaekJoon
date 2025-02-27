
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static ArrayList<Integer> list[];
	private static int order[];
	private static int result[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[] times = new int[n + 1];
		order = new int[n + 1];
		result = new int[n + 1];

		list = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		// input
		for (int i = 1 ; i <= n ; i++) {
			st = new StringTokenizer(br.readLine());
			times[i] = Integer.parseInt(st.nextToken());

			int elem = Integer.parseInt(st.nextToken());
			while (elem != -1) {
				list[elem].add(i);
				order[i]++;
				elem = Integer.parseInt(st.nextToken());
			}
		}

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1 ; i <= n ; i++) {
			if (order[i] == 0) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			int elem = queue.poll();

			result[elem] += times[elem];

			for (int next: list[elem]) {
				order[next]--;

				result[next] = Math.max(result[elem], result[next]);

				if (order[next] == 0) {
					queue.add(next);
				}
			}
		}

		for (int i = 1 ; i <= n ; i++) {
			System.out.println(result[i]);
		}


	}
}
