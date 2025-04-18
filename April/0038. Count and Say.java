//Time Complexity:	O(2ⁿ)
//Space Complexity:	O(2ⁿ)
class Solution {
    public String countAndSay(int n) {
        String res="1";
        for(int i=1;i<n;i++){
            StringBuilder current=new StringBuilder();
            int count=1;
            for(int j=1;j<res.length();j++){
                if(res.charAt(j)==res.charAt(j-1)){
                    count++;
                }
                else{
                    current.append(count).append(res.charAt(j-1));
                    count=1;
                }
            }
            current.append(count).append(res.charAt(res.length() - 1));
            res = current.toString();
        }
        return res;
    }
}
