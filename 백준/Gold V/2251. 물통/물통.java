import com.sun.source.tree.Tree;
import org.w3c.dom.Node;

import java.io.*;
import java.nio.Buffer;
import java.nio.file.LinkPermission;
import java.sql.Array;
import java.util.*;

public class Main {

    static TreeSet<Integer> result;
    static boolean visited[][];
    static int input[];

    static int send[] = {0, 0, 1, 1, 2, 2};
    static int receive[] = {1, 2, 0, 2, 0, 1};


    private static void DFS(int a, int b) {

        visited[a][b] = true;

        int total = input[2];

        if (a == 0)
            result.add(total - (a + b));

        for (int i = 0 ; i < 6 ; i++) {
            for (int j = 0 ; j < 6 ; j++) {

                int value[] = {a, b, total - (a + b)};

                int sendIdx = send[i];
                int receiveIdx = receive[j];
                if (value[sendIdx] == 0 || value[receiveIdx] == input[receiveIdx]) { // 보내려는 값이 0, 받는 값이 꽉찼을때 넘어감
                }

                int validReceiver = input[receiveIdx] - value[receiveIdx]; // 받는 부분에서 여분 공간

                if (value[sendIdx] > validReceiver) { // 보내는 값이 여분보다 클 때
                    value[sendIdx] -= validReceiver;
                    value[receiveIdx] += validReceiver;
                }
                else {
                    value[receiveIdx] += value[sendIdx];
                    value[sendIdx] = 0;
                }

                if (!visited[value[0]][value[1]]) { //  방문을 안했을 때
                    DFS(value[0], value[1]);
                }

            }
        }
        // a가 풀일때 b - c ,
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        input = new int[3];

        input[0] = Integer.parseInt(st.nextToken());
        input[1] = Integer.parseInt(st.nextToken());
        input[2] = Integer.parseInt(st.nextToken());

        result = new TreeSet<Integer>();
        visited = new boolean[input[0] + 1][input[1] + 1];

        visited[0][0] = true; // a, b 0일때


        DFS(0, 0);


        for (int i : result) {
            System.out.print(i + " ");

        }
    }
}
