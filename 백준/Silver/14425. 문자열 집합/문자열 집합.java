import com.sun.source.tree.Tree;

import java.io.*;
import java.util.ArrayList;

import java.util.StringTokenizer;

public class Main {

	private static ArrayList<String> list;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();
		// for (int i = 0 ; i < n ; i++) {
		// 	list[i] = new ArrayList<>();
		// }

		for (int i = 0; i < n ; i++) {
			String str = br.readLine();
			// list[i].add(str);
			list.add(str);
		}

		int resultCount = 0;

		for (int i = 0 ; i < m ; i++) {
			String input = br.readLine();

			for (int j = 0 ; j < n ; j++) {
				if (list.get(j).equals(input))
					resultCount++;
			}
		}
		System.out.println(resultCount);

	}
}
