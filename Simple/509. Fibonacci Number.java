//509. Fibonacci Number
class Solution {
    public int fib(int n) {
        if(n==0){
            return 0;
        }
        else if(n==1){
            return 1;
        }
        int first=0;int third=0;
        int sec=1;
        System.out.print("0,1,");
       for(int i=2;i<=n;i++){
            third=first+sec;
            first=sec;
            sec=third;
        }
        return sec;
    }
}
