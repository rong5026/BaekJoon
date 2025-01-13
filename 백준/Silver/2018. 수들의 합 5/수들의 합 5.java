
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
		int start = 1;
		int last = 1;
		int sum = 1;
		int count = 0;

		while (last <= n) {
			if (sum <= n) {
				if (sum == n) {
					count++;
				}
				last++;
				sum += last;
			}
			else  {
				sum -= start;
				start++;
			}

		}
		System.out.println(count);
	}
}



