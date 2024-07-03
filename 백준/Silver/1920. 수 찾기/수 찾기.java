import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

	private static int findNumber(int input[], int findValue) {
		int start = 0 ;
		int last = input.length - 1;

		while (start <= last) {
			int mid = (start + last) / 2;

			if (findValue > input[mid])  {
				start = mid + 1;
			}
			else if (findValue < input[mid]) {
				last = mid - 1;
			}
			else
				return 1;
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int input[] = new int[n];
		for (int i = 0 ; i < n ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int isValid[] = new int[m];
		for (int i = 0 ; i < m ; i++) {
			isValid[i] = Integer.parseInt(st.nextToken());
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0 ; i < m ; i++) {
			bw.write(findNumber(input, isValid[i]) + "\n");
		}

		bw.flush();
		bw.close();
	}
}