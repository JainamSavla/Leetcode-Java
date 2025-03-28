//Runtime 10 ms Beats 88.78% Time Complexity: O(n)
//Memory 58.13MB Beats 46.96% Space Complexity:O(n)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int num: nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
