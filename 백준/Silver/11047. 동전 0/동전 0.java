import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.management.MemoryType;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int input[] = new int[n + 1];
		int index = n;
		int resultCnt = 0;

		for (int i = 1 ; i <= n ; i++) {
			input[i] = Integer.parseInt(br.readLine());
			if (input[i - 1] <= m && m < input[i]) {
				index = i - 1;
			}
		}

		for (int j = index ; j >= 1 ; j--) {

			while (input[j] <= m) {
				resultCnt +=  m / input[j];
				m = m % input[j];
			}
		}

		System.out.println(resultCnt);


	}
}