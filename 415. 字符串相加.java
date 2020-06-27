class Solution {
    public String addStrings(String num1, String num2) {
        int size1 = num1.length();
        int size2 = num2.length();
        int size = size1 > size2 ? size1 : size2;
        if(size1 == 0) return num2;
        if(size2 == 0) return num1;

        StringBuilder a = new StringBuilder(num1);
        StringBuilder b = new StringBuilder(num2);
        while(size > size1) {
            a.insert(0, 0);
            size1++;
        }
        
        while(size > size2) {
            b.insert(0, 0);
            size2++;
        }
        StringBuilder sb = new StringBuilder();
        int power = 0;
        for(int i = size - 1; i > -1; i--) {
            int x = a.charAt(i) - '0';
            int y = b.charAt(i) - '0';
            int sum = x + y + power;
            if(sum >= 10) {
                power = 1;
                sum = sum % 10;
            } else {
                power = 0;
            }
            sb.insert(0, sum);
        }
        if(power != 0) {
            sb.insert(0, '1');
        }

        int index = 0;
        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) != '0'){
                index = i;
                break;
            }
        }
        return sb.substring(index, sb.length());
    }
}
