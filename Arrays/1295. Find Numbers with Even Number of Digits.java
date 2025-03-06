//1295. Find Numbers with Even Number of Digits
//Runtime :1ms Beats 98.35%
class Solution {
    public int findNumbers(int[] nums) {
        int even = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int digit = 0;
            int temp = nums[i];

            while (temp != 0) {
                temp = temp / 10;
                digit++;
            }
            
            if (count % 2 == 0) {
                even++;
            }
        }
        
        return even;
    }
}
//Approach 2
//Runtime 2ms Beats 25.79%
class Solution {
    public int findNumbers(int[] nums) {
        int even=0;
        for(int num:nums){
            int len=String.valueOf(num).length();//converted to string than took length
            if(len%2==0){
                even++;
            }
        }
        return even;
    }
}
//Approach 3
//Runtime 1 ms Beats 98.33%
class Solution {
    public int findNumbers(int[] nums) {
        int even=0;
        for(int num:nums){
            int digit=(int)Math.floor(Math.log10(num))+1;
            if(digit%2==0){
             even++;
           }
        }
         return even;
    }
}
//Approach-4
//Runtime 1ms Beats 98.33%
class Solution {
    public int findNumbers(int[] nums) {
        int even = 0;
        for (int num : nums) {
            if ((num >= 10 && num <= 99) || (num >= 1000 && num <= 9999) || (num == 100000)) {
                even++;
            }
        }
        return even;
    }
}


