
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static boolean checkAlphaNum(int currentNum[], int neededNum[]) {

		int count = 0;
		for (int i = 0 ; i < 4 ; i++) {
			if (currentNum[i] >= neededNum[i])
				count++;
		}

		if (count != 4)
			return false;
		return true;
	}

	private static int changeAlphaToNum(char c) {
		if (c == 'A')
			return 0;
		else if (c == 'C')
			return 1;
		else if (c == 'G')
			return 2;
		else
			return 3;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int neededNum[] = new int[4];
		int currentNum[] = new int[4];
		int resultCnt = 0;

		// 문자열 입력
		char input[] = br.readLine().toCharArray();

		// 첫 범위에서 알파뱃 수
		for (int i = 0 ; i < m ; i++) {
			if (input[i] == 'A')
				currentNum[0]++;
			else if (input[i] == 'C')
				currentNum[1]++;
			else if(input[i] == 'G')
				currentNum[2]++;
			else
				currentNum[3]++;
		}

		// 필요 알파뱃 수 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0 ; i < 4 ; i++) {
			neededNum[i] = Integer.parseInt(st.nextToken());
		}

		// 시작

		// 첫 배열 확인
		if (checkAlphaNum(currentNum, neededNum)) {
			resultCnt++;
		}

		for (int i = 0 ; i < n - m ; i++) {

			int start = i;
			int last = m + i;

			start = changeAlphaToNum(input[start]);
			last = changeAlphaToNum(input[last]);

			currentNum[start]--;
			currentNum[last]++;

			if (checkAlphaNum(currentNum, neededNum)) {
				resultCnt++;
			}
		}

		System.out.println(resultCnt);

	}
}
