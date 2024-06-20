import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<Long> list = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0 ; i < n ; i++) {
			list.add(Long.parseLong(st.nextToken()));
		}

		Collections.sort(list);

		System.out.println(list.get(m - 1));

	}
}
