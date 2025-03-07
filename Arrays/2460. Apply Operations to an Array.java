//2460. Apply Operations to an Array
//runtime 1ms beats 82.39% TIME COMPLEXITY :O(n)
//memory 44.27MB beats 29.37% SPACE COMPLEXITY O(n)
class Solution {
    public int[] applyOperations(int[] nums) {
         for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2; 
                nums[i + 1] = 0;
            }
        }
        int[] result=new int[nums.length];
        int index=0;
        for(int i=0;i<nums.length;i++){
              if (nums[i] != 0){
                result[index]=nums[i];
                index++;
              }
        }
        return result;
    }
}
