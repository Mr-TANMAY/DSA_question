package leetcode.easy;

public class Find_the_Index_of_the_First_Occurrence_in_a_String {
    public static void main(String[] args) {
        
    }
    /*
     * ### Approach

1. **Check for Empty Haystack**: If the `haystack` is empty, return -1 since there's nothing to search in.
2. **Get Lengths**: Calculate the lengths of `haystack` and `needle`.
3. **Iterate Through Haystack**: Loop through the `haystack` from the start to `haystackLen - needleLen` (inclusive). This ensures that there are enough characters left in the `haystack` to potentially match the `needle`.
4. **Check for Match**: For each position in the `haystack`, assume a match and then compare each character of the `needle` with the corresponding character in the `haystack`.
    - If any character does not match, set the match flag to false and break out of the inner loop.
    - If all characters match, return the current starting index.
5. **Return -1 if No Match**: If no match is found after checking all possible starting positions, return -1.

### Time Complexity (TC)

The time complexity of this solution is \(O(n \cdot m)\), where \(n\) is the length of `haystack` and \(m\) is the length of `needle`. This is because:
- The outer loop runs up to \(n - m + 1\) times.
- For each iteration of the outer loop, the inner loop can run up to \(m\) times to check for a match.

### Space Complexity (SC)

The space complexity of this solution is \(O(1)\). This is because:
- We are using a fixed amount of extra space (for variables like `haystackLen`, `needleLen`, `i`, `j`, and `match`), regardless of the input size.
- No additional data structures that grow with the input size are used.
     */
    class Solution {
        public int strStr(String haystack, String needle) {
            // If the haystack is empty, return -1 as there's nothing to search in
            if(haystack.length() == 0) return -1;

            // Get the lengths of both haystack and needle
            int haystackLen = haystack.length();
            int needleLen = needle.length();
    
            // Loop through the haystack up to the point where the remaining characters are fewer than needle's length
            for(int i = 0; i <= haystackLen - needleLen; i++){
                // Assume a match is found
                boolean match = true;
                
                // Check each character in the needle against the corresponding character in the haystack
                for(int j = 0; j < needleLen; j++){
                    if(haystack.charAt(i + j) != needle.charAt(j)){
                        // If any character does not match, set match to false and break the inner loop
                        match = false;
                        break;
                    }
                }
                // If match is still true after inner loop, return the starting index i
                if(match){
                    return i;
                }
            }
            // If no match is found after checking all possible starting positions, return -1
            return -1;
        }
    }
    
}
