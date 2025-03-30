/*APPROACH 1
import java.util.Map;

For nums = [2,7,11,15] and target = 9:

HashMap becomes {2:0, 7:1, 11:2, 15:3}

When i=0 (nums[0]=2), remain=7

Finds 7 in map at index 1

Returns [0, 1] */
//Runtime 4 ms Beats 59.18%  Time Complexity: O(n)
//Memory 44.73 MB Beats 88.17% Space Complexity: O(n)
 import java.util.HashMap;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int remain = target - nums[i];
            if (map.containsKey(remain) && map.get(remain) != i) {
                return new int[]{i, map.get(remain)};
            }
        }
        return null;
    }
}
//APPROAch 2
//Runtime 2 ms Beats 98.83% Time Complexity: O(n)
//Memory 45.08 MB Beats 45.72%  Space COmplexity: O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
        int remain=target- nums[i];
        if(map.containsKey(remain)){
             return new int[]{i,map.get(remain)};
        }
        map.put(nums[i],i);
       }
       return null;
    }
}
