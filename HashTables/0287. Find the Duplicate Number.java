//Time Complexity: O(n)
//Space Complexity:O(n)
class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
        if(set.contains(num)){
           return num;
        }
        set.add(num);
        }
        return -1;
    }
}
