class Solution {
    public String xxxlongestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            while(!strs[i].startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length() - 1);
                if(prefix == "") return "";
            }
        }
        return prefix;
    }


    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";

        int len = Integer.MAX_VALUE;
        for(String each : strs) {
            len = Math.min(len, each.length());
        }

        int l = 1;
        int r = len;
        while(l <= r) {
            int mid = (l + r)/2;
            if(compare(strs, mid)){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return strs[0].substring(0, (l+r)/2);
    }

    private boolean compare(String[] strs, int pos){
        String prefix = strs[0].substring(0, pos);
        for(int i = 1; i < strs.length; i++){
            if(!strs[i].startsWith(prefix)){
                return false;
            }
        }
        return true;
    }
}
