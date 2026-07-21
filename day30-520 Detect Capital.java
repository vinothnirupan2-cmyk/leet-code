class Solution {
    public boolean detectCapitalUse(String word) {
        int upperCount = 0;
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperCount++;
            }
        }
        
        // All lowercase, all uppercase, or only first letter capital
        return upperCount == 0 
            || upperCount == word.length() 
            || (upperCount == 1 && Character.isUpperCase(word.charAt(0)));
    }
}
