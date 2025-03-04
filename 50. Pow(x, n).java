//50. Pow(x, n)
class Solution {
    public double myPow(double x, int n) {
    return Math.pow(x, n);
     /* if(n==1){
            return x;
        }
        if(n==0){
            return 1;
        }
        if(n<0){
            x=1/x;
            n=-n;
        }
        double result=1.0;
        for(int i=0;i<n;i++){
            result=result*x;
        }
        return result;*/ 
    }
}
