//27. Remove Element
//Approach 1
//runtime 0ms beats 100% TIME COMPLEXITY:-O(n)
//Memory 41.89 MB beats 81.92% SPACE COMPLEXITY:-O(1)
class Solution {
    public int removeElement(int[] nums, int val) {
         if (nums.length == 0) return 0;
         int k=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[k]=nums[i];
                k++;
            }
        }
        return k;
    }
}
//Approach 2 
//Runtime 0ms 100% TIME COMPLEXITY O(n)
//Memory 41.75MB Beats 92.17% Space Complexity O(1)
class Solution {
    public int removeElement(int[] nums, int val) {
        int n=nums.length;
        int i=0;

        while(i<n){
            if(nums[i]==val){
                nums[i]=nums[n-1];
                n--; 
            }
            else{
                i++;
            }
        }
        return n;
    }
}
