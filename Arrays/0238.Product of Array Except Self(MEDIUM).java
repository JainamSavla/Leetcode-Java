//Brute force method will not work at all in these problem 
//Time Complexity: O(n²)
//Space Complexity: O(n)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer=new int[nums.length];

        for(int i=0;i<nums.length;i++){
            int product=1;
            for(int j=0;j<nums.length;j++){
                if(i!=j){
                    product *=nums[j];
                }
            }
            answer[i]=product;
        }
        return answer;
    }
}

//approach 2
//Time Complexity: O(n)
//Space Complexity: O(n)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int totalproduct=1;
        int zerocount=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zerocount++;
            }
            else{
                totalproduct=totalproduct*nums[i];
            }
        }
        int[] result = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(zerocount>1){
                result[i]=0;
            }
            else if(zerocount ==1){
                result[i]=(nums[i]==0)? totalproduct:0;
            }else{
                result[i]=totalproduct/nums[i];
            }
        }
        return result;
    }
}
//Approach 3
//Time Complexity: O(n)
//Space Complexity: O(1)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left=new int[nums.length];
        left[0]=1;
        for(int i=1;i<nums.length;i++){
            left[i]=left[i-1]*nums[i-1];
        }
        int right=1;
        for(int i=nums.length-1;i>=0;i--){
            left[i]*=right;
            right=right*nums[i];
        }
        return left;
    }
}
