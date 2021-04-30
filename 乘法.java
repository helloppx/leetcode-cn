
    public static void main(String[] args) {
        System.out.println(com(-80,2));
    }

    public static int com(int x, int times) {
        int a = 0;
        int b = 0;

        if (x < 0) {
            a = 1;
            x = 0 - x;
        }
        if (times < 0) {
            b = 1;
            times = -times;
        }
        int sign = a ^ b;

        int res = _com(x, times);
        if (sign == 1) {
            return -res;
        }
        return res;
    }

    public static int _com(int x, int times) {
        if (times == 0) return 0;
        if (times == 1) return x;
        return x + com(x, times - 1);
    }
