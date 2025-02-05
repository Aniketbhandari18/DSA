class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        int n = s.length();

        if (n == 0) return 0;

        int idx = 1;
        long ans = 0;
        int sign = 1;


        if (s.charAt(0) == '-') sign = -1;

        else if (s.charAt(0) != '+') idx = 0;

        while (idx < n){
            char ch = s.charAt(idx);

            if (!(ch >= '0' && ch <= '9')) break;

            ans = ans * 10 + (int)(ch - '0');

            if (sign * ans >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign * ans <= Integer.MIN_VALUE) return Integer.MIN_VALUE;

            idx++;
        }

        return (int) ans * sign;
    }
}
