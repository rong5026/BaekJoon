import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        
        int copy[];
        answer = new int[commands.length];
        
        for (int i = 0 ; i < commands.length ; i++) {
            int size = commands[i][1] - commands[i][0] + 1;
            copy = new int[size];
            
            for (int j = 0 ; j < size ; j++) {
                copy[j] = array[commands[i][0] + j -1];
            }
            Arrays.sort(copy);
            answer[i] = copy[commands[i][2] - 1];
        }
        return answer;
    }
}