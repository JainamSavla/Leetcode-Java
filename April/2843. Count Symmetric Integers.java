//Time Complexity: O(N)
//Space Complexity: O(1) 
class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for(int num=low;num<=high;num++){
            String str=String.valueOf(num);
            int length=str.length();
            if(length % 2==1 ){
                continue;
            }
            int mid=length/2;
            int left=0,right=0;

            for(int i=0;i<mid;i++){
                left+=str.charAt(i)-'0';
                right+=str.charAt(i+mid)-'0';
            }            
            if(left==right){
                count++;
            }
        }
        return count;
    }
}
