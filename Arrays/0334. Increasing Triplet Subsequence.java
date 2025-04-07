//Time Complexity: O(n)
//Space Complexity: O(1)
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first=Integer.MAX_VALUE,second=Integer.MAX_VALUE,third=Integer.MAX_VALUE;

        for(int num:nums){
            if(num<=first){
                first=num;
            }else if(num<=second){
                second=num;
            }else{
                third=num;
                return true;
            }
        }
        return false;
    }
}
