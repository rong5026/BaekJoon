
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[] parent;

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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());


		// parent 초기화
		parent = new int[n + 1];
		for (int i = 1 ; i <=n ; i++) {
			parent[i] = i;
		}

		st = new StringTokenizer(br.readLine());
		int knowCnt = Integer.parseInt(st.nextToken());
		int[] knowPeople = new int[knowCnt + 1];

		if (knowCnt == 0) {
			System.out.println(m);
			return;
		}

		int prev = 1;
		// 진실을 알고 있는 사람
		for (int i = 1 ; i <= knowCnt ; i++) {
			knowPeople[i]= Integer.parseInt(st.nextToken());
			if (i == 1)
				prev = knowPeople[i];
			union(prev , knowPeople[i]);
			prev = knowPeople[i];
		}


		prev = Integer.MAX_VALUE;

		ArrayList<Integer> partyValue[] = new ArrayList[m + 1];

		for (int i = 1; i <= m ; i++) {
			partyValue[i] = new ArrayList<>();
		}

		// 파티 input
		for (int i = 1 ; i <= m ; i++) {
			st = new StringTokenizer(br.readLine());
			int partyPerson = Integer.parseInt(st.nextToken());

			for (int j = 1 ; j <= partyPerson ; j++) {
				int elem = Integer.parseInt(st.nextToken());
				partyValue[i].add(elem);

				if (j == 1) {
					prev = elem;
				}
				union(prev, elem);
				prev = elem;
			}
		}

		int total = m;
		int start = knowPeople[1];

		// 파티중 거짓가능한 수 파악
		for (int i = 1; i <= m ; i++) {

			for (int elem : partyValue[i]) {
				if (find(start) == find(elem)) {
					total--;
					break;
				}
			}
		}

		System.out.println(total);
	}
}
