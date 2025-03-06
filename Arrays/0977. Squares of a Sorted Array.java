//977. Squares of a Sorted Array
//7 ms beats 44.06% coders because the inbuilt sort function uses quicksort
class Solution {
    public int[] sortedSquares(int[] nums) {
        int [] temp=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            temp[i]=nums[i]*nums[i];
        }
       Arrays.sort(temp);
        return temp;
    }
}
//TWO POINTER 
//1ms beets 100% 
class Solution {
    public int[] sortedSquares(int[] nums) {  
        int n = nums.length;
        int l = 0;
        int r = nums.length - 1;
        int[] result = new int[n];

        for (int i = r; i >= 0; i--) {
            int val; 
            if (Math.abs(nums[l]) > Math.abs(nums[r])) {
              result[i] = nums[l] * nums[l];
              l++;
            } else {
            result[i] = nums[r] * nums[r];
             r--;
            }
        }
         return result;
    }
}

