//342. Power of Four
class Solution {
    public boolean isPowerOfFour(int n) {
        if(n<1){
            return false;
        }
        if(n==1){
            return true;
        }
        else{
            while(n%4==0){
                n=n/4;
            }
            if(n==1){
                return true;
            }
            else{
                return false;
            }
        }
    }
}
