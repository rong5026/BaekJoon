import com.sun.source.tree.Tree;

import java.io.*;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> map = new HashMap<>();


		for (int i = 0; i < n ; i++) {
			String str = br.readLine();
			map.put(str, 0);
		}

		int resultCount = 0;

		for (int i = 0 ; i < m ; i++) {
			String input = br.readLine();

			if (map.get(input) != null)
				resultCount++;
		}
		System.out.println(resultCount);
	}
}
