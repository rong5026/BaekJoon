import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Set<String> list = new HashSet<String>();

		for (int i = 0 ; i < n ; i++) {
			list.add(br.readLine());
		}

		String[] array = list.toArray(new String[0]);

		Arrays.sort(array, (a, b) -> {
			if (a.length() != b.length()) {
				return a.length() - b.length();
			}
			return a.compareTo(b);
		});

		StringBuilder sb = new StringBuilder();

		for (String s : array) {
			sb.append(s).append("\n");
		}
		System.out.print(sb);
	}
}