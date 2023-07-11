import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int A[];
    static long D[]; // 구간합 배열
    static long C[]; // 나머지가 같은 인덱스 개수 저장
    
	void Solve() {
        long count = 0;
        // 구간합 배열을 %M 한 나머지로 갱신
        for (int i=0; i<N; i++) {
            int remain = (int)(D[i] % M);
            // 구간합 배열 요소에서 0인 인덱스 카운트
            if (remain == 0) count++;
            //D[i] = D[i]%M;
            C[remain]++;
        }
        
        // 구간합 배열의 부분 계산
        for (int i=0; i<M; i++) {
            if (C[i] <= 1) continue; // 2개 보다 이하면 패스
            // 조합의 개수 구하는 공식 : C[i] 개수에서 2개를 고르는 모든 경우의 수
            long tmp = C[i] * (C[i]-1)/ 2;
            count += tmp;
        }
        System.out.println(count);
	}

    void inputData() throws Exception {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];
        D = new long[N];
        C = new long[M];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            if (i == 0) {
                D[i] = A[i];
            } else {
                D[i] = D[i-1]+A[i];
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.inputData(); // 입력 받는 부분
        m.Solve();// 여기서부터 작성
    }

}