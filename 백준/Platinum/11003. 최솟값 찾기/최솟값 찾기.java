import javax.swing.*;
import java.io.*;
import java.nio.Buffer;
import java.sql.Array;
import java.util.*;



public class Main {

    static class Node {
        public int index;
        public int value;

        Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int [] arr = new int[n];

        for(int i = 0 ; i < n ; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Deque<Node> myDeque = new LinkedList<>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0 ; i < n ; i++) {


            while(!myDeque.isEmpty() && myDeque.getLast().value > arr[i])
                myDeque.removeLast();

            Node node = new Node(i, arr[i]);
            myDeque.addLast(node);

            // remove
            if(myDeque.getFirst().index < i - m + 1) {
                myDeque.removeFirst();
            }
            bw.write(myDeque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();

    }
}