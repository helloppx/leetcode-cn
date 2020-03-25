class Solution {
    public int lengthOfLongestSubstring(String s) {
        // int size = s.length();
        // if(size == 1) return 1;

        // Set<Character> res = new HashSet<>();
        // for(int i = 0; i < size - 1; i++){
        //     Set<Character> set = new HashSet<>();
        //     set.add(s.charAt(i));
        //     for(int j = i + 1; j < size; j++){
        //         char ch = s.charAt(j);
        //         if(!set.contains(ch)){
        //             set.add(ch);
        //         }else{
        //             break;
        //         }
        //     }
        //     if(set.size() > res.size()) res = set;
        //     if(set.size() >= (size - i)){
        //         break;
        //     }
        // }
        // return res.size();

        int length = s.length();
        int res = 0;
        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();
        while(j < length && i < length){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                res = Math.max(res, j - i);
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return res;
    }
}
