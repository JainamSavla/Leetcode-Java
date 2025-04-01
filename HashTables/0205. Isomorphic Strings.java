//Runtime 16 ms Beats 44.61% Time Complexity :O(n)
//Memory 42.61 MB Beats 37.38%  Space Complexity:O(1)
//Approach -1
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character>sTot=new HashMap<>();
        Map<Character,Character>tTos=new HashMap<>();

        for(int i=0;i<s.length();i++){
            char _s=s.charAt(i),_t=t.charAt(i);
            if(!sTot.containsKey(_s) && !tTos.containsKey(_t)){
                sTot.put(_s,_t);
                tTos.put(_t,_s);
            }else if(sTot.get(_s)==null){
                return false;
            }else if(tTos.get(_t)==null){
                return false;
            }else if(sTot.get(_s)!=_t && tTos.get(_t)!=_s){
                return false;
            }
        }
        return true;
    }
}

//Approach-2
