import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> list[] = new ArrayList[n + 1];
		int time[] = new int[n + 1];
		int value[] = new int[n + 1];
		int result[] = new int[n + 1];

		for (int i = 1; i <= n ; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1 ; i <= n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			time[i] = Integer.parseInt(st.nextToken());
			int tower = 0;
			while (true) {
				tower = Integer.parseInt(st.nextToken());
				if (tower == -1) {
					break;
				}
				list[tower].add(i);
				value[i]++;
			}
		}

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1 ; i <= n ; i++){
			if (value[i] == 0) {
				queue.add(i);
			}
		}


		while (!queue.isEmpty()) {
			int elem = queue.poll();

			for (int next : list[elem]) {
				value[next]--;
				result[next] =  Math.max(result[next], result[elem] + time[elem]);
				if (value[next] == 0)
					queue.add(next);
			}
		}

		for (int i = 1 ; i<= n ; i++){
			result[i] += time[i];
			System.out.println(result[i]);
		}
	}
}