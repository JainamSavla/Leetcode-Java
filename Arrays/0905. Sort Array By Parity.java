//905. Sort Array By Parity
//0 ms Beats 100.00% TIME COMPLEXITY:O(N)
//Memory 44.91MB Beats 61.28%:O(1)
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left=0;
        int right=nums.length-1;

        while(left<right){
            if(nums[left]%2==0){
                left++;
            }
            else{
                int temp= nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
                right--;
            }
        }
        return nums;
    }
}

//APPROACH 2
//runtime 5ms beats 5.11% TIME COMPLEXITY:O(N)
//Memory 45.60MB beats 6.18% TIME COMPLEXITY:O(N)
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        Integer[] result=new Integer[nums.length];
        for(int i=0;i<nums.length;i++){
            result[i]=nums[i];
        }

        Arrays.sort(result,(val1,val2)->Integer.compare(val1%2,val2%2));//sort based on remainder is 0 or 1 
        
        for(int i=0;i<nums.length;i++){
            nums[i]=result[i];
        }
        return nums;
    }
}

//APPROACH 3
//Runtime 1ms Beats 51.30% TIME COMPLEXITY O(N)
//Memory 44.64MB Beats 95.80% SPACE COMPLEXITY O(N)
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int index=0;
        int[] res=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                res[index]=nums[i];
                index++;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2!=0){
                res[index]=nums[i];
                index++;
            }
        }
        return res;
    }
}
