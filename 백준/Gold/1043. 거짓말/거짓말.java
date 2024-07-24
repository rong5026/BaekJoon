import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int find(int a) {
		if (a == parent[a])
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
	private static boolean checkPossibleParty(int elem, int truePerson[]) {
		for (int i = 0 ; i < truePerson.length ; i++) {
			int trueParent = find(truePerson[i]);
			int elemParent = find(elem);
			if (trueParent == elemParent) {
				return false;
			}
		}
		return true;
	}

	private static int parent[];
	private static ArrayList<Integer> party[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 첫 줄 입력
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		party = new ArrayList[m + 1];
		parent = new int[n + 1];
		for (int i = 1 ; i <= n ; i++) {
			parent[i] = i;
		}


		// 진실 아는 사람 입력
		st = new StringTokenizer(br.readLine());
		int trueKnowCnt = Integer.parseInt(st.nextToken());
		int truePerson[] = new int[trueKnowCnt];

		for (int i = 0 ; i < trueKnowCnt ; i++) {
			truePerson[i] = Integer.parseInt(st.nextToken());
		}

		// 각 파티에 참여하는 인원 입력
		for (int i = 1 ; i <= m ; i++) {
			st = new StringTokenizer(br.readLine());
			party[i] = new ArrayList<>();

			int personCnt = Integer.parseInt(st.nextToken());

			for(int j = 0 ; j < personCnt ; j++) {
				party[i].add(Integer.parseInt(st.nextToken()));

				if (j != 0)
					union(party[i].get(j - 1), party[i].get(j));
			}
		}

		int reulstCount = m;

		for (int i = 1 ; i <= m ; i++) {

			int elem = party[i].get(0);

			if(!checkPossibleParty(elem, truePerson)) {
				reulstCount--;
			}
		}

		System.out.println(reulstCount);

	}
}