package leetcode.easy;

public class Valid_Palindrome {
    public static void main(String[] args) {
        
    }
    public boolean isPalindrome(String s) {
        // Remove all non-alphanumeric characters and convert the string to lowercase
        s = s.replaceAll("[^a-z0-9A-Z]", "").toLowerCase();
    
        // Initialize two pointers: one at the start and one at the end of the string
        int i = 0;
        int j = s.length() - 1;
    
        // Iterate while the two pointers do not cross
        while (i < j) {
            // Check if characters at the two pointers are different
            if (s.charAt(i) != s.charAt(j)) {
                return false; // Not a palindrome if a mismatch is found
            }
            // Move pointers towards the center
            i++;
            j--;
        }
    
        // Return true if no mismatches were found, meaning the string is a palindrome
        return true;
    }
}

/*
 * Time Complexity (TC):
 * - Removing non-alphanumeric characters and converting to lowercase takes O(n) time,
 *   where n is the length of the input string.
 * - The while loop also runs in O(n) time in the worst case, as each character is checked once.
 * - Overall, the time complexity is O(n), where n is the length of the input string.

 * Space Complexity (SC):
 * - The space complexity is O(n) due to the additional string created by replaceAll() and toLowerCase().
 * - No additional space is used beyond this, so the space complexity is O(n).
 */