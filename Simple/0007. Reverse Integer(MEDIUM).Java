//0ms Beats 100.00%
//Memory 40.71MB Beats 84.41%
class Solution {
    public int reverse(int x) {
        int rev=0;
        int d=0;
        while(x!=0){
            d=x%10;
             if(rev>Integer.MAX_VALUE/10||rev<Integer.MIN_VALUE/10)//Checking for overflow
             {
                return 0;
            }
            rev=rev*10+d;
            x=x/10;
        }
        return rev;
    }
}
