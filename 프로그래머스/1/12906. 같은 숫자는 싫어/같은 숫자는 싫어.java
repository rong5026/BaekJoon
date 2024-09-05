import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        ArrayList<Integer> list = new ArrayList<>();
        int prenum = -1;
        
        for (int elem : arr) {
            if (prenum != elem) {
                list.add(elem);
            }
            prenum = elem;
        }
        int [] answer = new int[list.size()];
        
        int j = 0;
        for (int i : list) {
            answer[j++] = i;
        }
        
        return answer;
    }
}