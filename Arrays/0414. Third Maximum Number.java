//414. Third Maximum Number.java
//FIRST APPROACH
//Runtime 4 ms Beats 64.75%T IME COMPLEXITY:O(n log n)
//Memory 42.86 MB Beats 88.18% SPACE COMPLEXITY:O(1)
class Solution {
    public int thirdMax(int[] nums) {
        //sort
        Arrays.sort(nums);
        int i=0,
            j=nums.length-1;
        //reverse
        while(i<j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;

            i++;
            j--;
        }
        //count the distinct element
        int count=1;//the first element is always distinct
        for(int k=1;k<nums.length;k++){
            if(nums[k]!=nums[k-1]){
                count++;
            }
            //the third distinct element us the third maximum 
            if(count==3){
                  return nums[k];
            }
        }
        //if less than 3 distinct number return largest one
        return nums[0];
    }
}

//APPROACH 2
//WITHOUT REVERSING THE ARRAY
//Time complexity:O(nlogn)
//Space Complexity:O(1)
import java.util.Arrays;

class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums); // Sort in ascending order by default
        int count = 1; // First distinct max is at the end after sorting

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] != nums[i + 1]) { // Check for distinctness
                count++;
            }
            if (count == 3) {
                return nums[i]; // Return the third distinct maximum
            }
        }

        // If less than 3 distinct numbers, return the largest one
        return nums[nums.length - 1];
    }
}

//APPROACH 3
//Runtime 3ms Beats 75.17% TIME COMPLEXITY:O(n)
//Memory 42.86MB Beats 88.18% SPACE COMPLEXITY:O(1)

class Solution {
    public int thirdMax(int[] nums) {
        Integer max1=null;
        Integer max2=null;
        Integer max3=null;

        for(int i=0;i<nums.length;i++){
            if(max1!=null && max1==nums[i]){
                continue;
            }
            if(max2!=null && max2==nums[i]){
                continue;
            }
            if(max3!=null && max3==nums[i]){
                continue;
            }
            if(max1==null || nums[i]>max1){
                max3=max2;
                max2=max1;
                max1=nums[i];
            }
            else if(max2==null || nums[i]>max2){
                max3=max2;
                max2=nums[i];
            }
            else if(max3==null || nums[i]>max3){
                max3=nums[i];
            }
        }
        if(max3!=null){
            return max3;
        }
        return max1;
    }
}
