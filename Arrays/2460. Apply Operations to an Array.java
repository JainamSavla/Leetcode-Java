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

//Approach-2
//IMPROVED SPACE COMPLEXITY O(1) TO 43.50MB Beats 87.87% 

class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        int k = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
                k++;
            }
        }
        
        return nums;
    }
}

