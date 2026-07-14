class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindromes
        // Numbers ending in 0 (except 0 itself) are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        
        int reverted = 0;
        while (x > reverted) {
            reverted = reverted * 10 + x % 10;
            x /= 10;
        }
        
        // When the length is odd, we can get rid of the middle digit
        // by revertedNumber/10, e.g. 12321 -> 123, x -> 12
        return x == reverted || x == reverted / 10;
    }
}
