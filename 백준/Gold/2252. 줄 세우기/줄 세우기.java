import com.sun.source.tree.Tree;

import org.w3c.dom.Node;

import java.io.*;
import java.nio.Buffer;
import java.nio.file.LinkPermission;
import java.sql.Array;
import java.util.*;

import jdk.jshell.SourceCodeAnalysis;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		ArrayList<Integer> list[] = new ArrayList[n + 1];
		int enterArray[] = new int[n + 1];

		for (int i = 1 ; i <= n ; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 0 ; i < m ; i++) {

			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			enterArray[b]++;
		}

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= n ; i++) {
			if (enterArray[i] == 0) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			int now = queue.poll();
			System.out.print(now + " ");

			for (int next : list[now]) {
				enterArray[next]--;
				if (enterArray[next] == 0)
					queue.add(next);
			}
		}


		// for (int i = 1 ; i <= n ; i++) {
		//
		// 	list[i].forEach((elem) -> {
		// 		System.out.println(elem);
		// 	});
		// }
	}


}
