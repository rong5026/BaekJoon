import javax.swing.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.sql.Array;
import java.util.*;


class Node implements Comparable<Node>{
    int value;
    int index;

    public Node() {
        this.value = 0;
        this.index = 0;
    }
    public Node(int value , int index){
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Node[] arr = new Node[n];

        for(int i = 0 ; i < n ; i++) {
            arr[i] = new Node(Integer.parseInt(br.readLine()), i);
        }
        Arrays.sort(arr);

        int max = 0;
        for(int i = 0 ; i < n ; i++) {
            if ( arr[i].index - i > max)
                max = arr[i].index - i;
        }

        System.out.println(max + 1);
    }
}