//485. Max Consecutive Ones
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count++; /* the whole if statement can be replace by "max = Math.max(max, count);" but due to a function call the runtime will increase so it is better to use the if statement*/
                if (count > max) { 
                    max = count; 
                }
            }
            else{
                count=0;
            }
        }
        return max;
    }
}
