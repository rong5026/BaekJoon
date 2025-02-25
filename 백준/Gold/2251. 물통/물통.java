
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static boolean[][] visited;
	private static int sender[] = {0, 0, 1, 1, 2, 2};
	private static int receiver[] = {1, 2, 0, 2, 0, 1};
	private static int[] input;
	private static PriorityQueue<Integer> result;

	private static void dfs(int a, int b) {

		if (a == 0) {
			result.add(input[2] - b);
		}

		for (int i = 0 ; i < 6 ; i++) {
			int value[] = {a, b, input[2] - a - b};

			int send = sender[i];
			int receive = receiver[i];

			// receive에서 수용가능 값
			int remainValue = input[receive] - value[receive];

			if (value[send] >= remainValue) {
				value[receive] = input[receive];
				value[send] = value[send] - remainValue;
			}
			else {
				value[receive] += value[send];
				value[send] = 0;
			}

			if (!visited[value[0]][value[1]]) {
				visited[value[0]][value[1]] = true;
				dfs(value[0], value[1]);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		visited = new boolean[201][201];
		input = new int[3];
		result = new PriorityQueue<>();

		input[0] = Integer.parseInt(st.nextToken());
		input[1] = Integer.parseInt(st.nextToken());
		input[2] = Integer.parseInt(st.nextToken());

		visited[0][0] = true;

		dfs(0, 0);

		while (!result.isEmpty()){
			System.out.print(result.poll() + " ");
		}

	}
}
