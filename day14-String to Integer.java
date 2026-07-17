class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();
        
        // Step 1: skip leading whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        
        if (i == n) return 0;
        
        // Step 2: determine sign
        int sign = 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            if (s.charAt(i) == '-') sign = -1;
            i++;
        }
        
        // Step 3: read digits, building result while guarding overflow
        long result = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            result = result * 10 + digit;
            
            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            
            i++;
        }
        
        return (int) (sign * result);
    }
}
