package leetcode.easy;

public class Remove_Duplicates_from_Sorted_Array {
    public static void main(String[] args) {
        
    }
    /*

1. **Initialize Pointers**: Start with the `left` pointer `l` at position 1, since the first element is always unique.
2. **Iterate Through the Array**: Use a `right` pointer `r` to iterate through the array starting from the second element (index 1).
3. **Check for Duplicates**: For each element, check if it is different from the previous element.
    - If the current element is different from the previous one, assign the current element to the position pointed to by `l` and increment `l`.
    - If the current element is the same as the previous one, do nothing and move to the next element.
4. **Return the Length**: After the loop finishes, `l` will be the length of the array without duplicates.

### Time Complexity (TC)

The time complexity of this solution is \(O(n)\), where \(n\) is the length of the array `nums`. This is because:
- The algorithm iterates through the array exactly once.

### Space Complexity (SC)

The space complexity of this solution is \(O(1)\). This is because:
- We are using a fixed amount of extra space (for variables like `l` and `r`), regardless of the input size.
- No additional data structures that grow with the input size are used.
     */
    class Solution {
        public int removeDuplicates(int[] nums) {
            // Initialize the left pointer at 1, as the first element is always unique
            int l = 1;
            
            // Iterate through the array starting from the second element
            for(int r = 1; r < nums.length; r++){
                // If the current element is not equal to the previous element
                if(nums[r] != nums[r-1]){
                    // Assign the current element to the left pointer position
                    nums[l] = nums[r];
                    // Increment the left pointer
                    l++;
                }
            }
            // Return the length of the array without duplicates
            return l;
        }
    }   
}
