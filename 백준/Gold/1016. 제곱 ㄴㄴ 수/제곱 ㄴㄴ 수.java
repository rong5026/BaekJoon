
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());
		long elem;
		boolean[] visited = new boolean[(int)(max - min) + 1];
		int count =0;

		for (long i = 2 ; i <= Math.sqrt(max) ; i++) {

			if (min % (i * i) == 0 ) {
				elem = min / (i * i);
			}
			else {
				elem = (min / (i * i)) + 1;
			}
			long start = elem * i * i;

			for (long j = start ; j <= max ; j += i*i) {
				visited[(int)(j - min)] = true;
			}
		}

		for (int i = 0 ; i < max - min + 1 ; i++) {
			if (!visited[i])
				count++;
		}
		System.out.println(count);

	}
}
