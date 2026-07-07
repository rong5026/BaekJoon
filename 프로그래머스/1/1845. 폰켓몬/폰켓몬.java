import java.util.*;

class Solution {
    public int solution(int[] nums) {
   
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < nums.length ; i++) {
            map.put(nums[i], map.getOrDefault(map.get(nums[i]), 0) + 1);
        }
        
        int keyCnt = map.size();
        
        if (keyCnt < nums.length / 2)
            return keyCnt;
        else
            return nums.length/2;
        
    }
}