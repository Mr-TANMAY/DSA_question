package leetcode.easy;

public class Remove_Duplicates {
    public static void main(String[] args) {
        
    }
    /*
     * ### Approach

1. **Initialize Pointer**: Start with the left pointer `l` at position 0.
2. **Iterate Through the Array**: Use a right pointer `r` to iterate through the array from the beginning.
3. **Check for Value**: For each element, check if it is not equal to the specified value `val`.
    - If the current element is not equal to `val`, assign the current element to the position pointed to by `l` and increment `l`.
    - If the current element is equal to `val`, do nothing and move to the next element.
4. **Return the Length**: After the loop finishes, `l` will be the length of the array with the specified value removed.

### Time Complexity (TC)

The time complexity of this solution is \(O(n)\), where \(n\) is the length of the array `nums`. This is because:
- The algorithm iterates through the array exactly once.

### Space Complexity (SC)

The space complexity of this solution is \(O(1)\). This is because:
- We are using a fixed amount of extra space (for variables like `l` and `r`), regardless of the input size.
- No additional data structures that grow with the input size are used.
     */
    class Solution {
        public int removeElement(int[] nums, int val) {
            // Initialize the left pointer at 0
            int l = 0;
            
            // Iterate through the array using the right pointer
            for(int r = 0; r < nums.length; r++){
                // If the current element is not equal to the value to be removed
                if(nums[r] != val){
                    // Assign the current element to the left pointer position
                    nums[l] = nums[r];
                    // Increment the left pointer
                    l++;
                }
            }
            // Return the length of the array with the specified value removed
            return l;
        }
    }
    
}
