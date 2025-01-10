import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
      
        HashSet<Integer> list = new HashSet<>();
      
        int max = nums.length / 2;
        for(int elem : nums) {
            list.add(elem);
        }
        if (max < list.size()) {
            return max;
        }
        return list.size();
        
        
    }
}