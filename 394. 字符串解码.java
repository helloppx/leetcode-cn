class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(isNumber(c)) {
                int j = c - '0';

                int x = i + 1;
                while(isNumber2(s.charAt(x))){
                    j = j * 10 + s.charAt(x) - '0';
                    x++;
                }

                int k = x + 1;
                int left = 1;
                while(left != 0){
                    if(s.charAt(k) == '[') {
                        left++;
                    }else if(s.charAt(k) == ']') {
                        left--;
                    }
                    k++;
                }

                while(j-- > 0){
                    sb.append(decodeString(s.substring(x+1, k-1)));
                }
                i = k - 1;
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private boolean isNumber2(char c){
        return c >= '0' && c <= '9';
    }

    private boolean isNumber(char c){
        return c > '0' && c <= '9';
    }
}
