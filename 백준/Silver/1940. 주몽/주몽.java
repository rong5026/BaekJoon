
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int input[] = new int[n];
		int start = 0;
		int last = n - 1;
		int count = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0 ; i < n ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(input);

		while (start < last) {
			int elem = input[start] + input[last];

			if (elem > m) {
				last--;
			}
			else if (elem < m){
				start++;
			}
			else {
				count++;
				start++;
				last--;
			}
		}
		System.out.println(count);

	}
}



