//Approach 1
//time complexity:O(nlogn)
//Space Complexity:O(logn)
class Solution {
    public int findMin(int[] nums) {
       Arrays.sort(nums);
       return nums[0];
    }
}
//Approach -2
class Solution {
    public int findMin(int[] nums) {
        int min = nums[0];
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
}
//Approach-3 Binary Sort
//Time Complexity:O(log n)
//Space Complexity:O(1)
class Solution {
    public int findMin(int[] arr) {
        int left=0,right=arr.length-1;

        while(left<right){
            int mid=left+(right-left)/2;

            if(arr[mid]>arr[right]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return arr[left];
    }
}
