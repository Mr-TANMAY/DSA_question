package leetcode.easy;

public class Merge_Sorted_Array {
    public static void main(String[] args) {
        
    }
    /*
     * ### Approach

1. **Initialize Pointers**: Set three pointers:
   - `i` at the end of the valid elements in `nums1` (`m - 1`).
   - `j` at the end of `nums2` (`n - 1`).
   - `k` at the end of the merged array (`m + n - 1`).

2. **Merge from the End**: Iterate while `j` is greater than or equal to 0:
   - If `i` is greater than or equal to 0 and the current element in `nums1` is greater than the current element in `nums2`, place `nums1[i]` at `nums1[k]` and decrement `i`.
   - Otherwise, place `nums2[j]` at `nums1[k]` and decrement `j`.
   - Decrement `k` in both cases to move to the next position in the merged array.

3. **End of Loop**: Once the loop completes, `nums1` will contain the merged sorted elements.

### Time Complexity (TC)

The time complexity of this solution is \(O(m + n)\), where \(m\) is the number of elements in `nums1` and \(n\) is the number of elements in `nums2`. This is because:
- The algorithm iterates through both arrays exactly once.

### Space Complexity (SC)

The space complexity of this solution is \(O(1)\). This is because:
- We are using a fixed amount of extra space (for pointers `i`, `j`, and `k`), regardless of the input size.
- The merging is done in place in `nums1` without using any additional data structures that grow with the input size.
     */
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            // i is the pointer for the last element in the initial part of nums1
            int i = m - 1;
            // j is the pointer for the last element in nums2
            int j = n - 1;
            // k is the pointer for the last position in nums1 (total length m + n)
            int k = m + n - 1;
            
            // Iterate while there are elements in nums2 to be merged
            while (j >= 0) {
                // If nums1 has elements and the current element in nums1 is greater than the current element in nums2
                if (i >= 0 && nums1[i] > nums2[j]) {
                    // Place the larger element from nums1 at the end of the merged array
                    nums1[k] = nums1[i];
                    // Decrement both k and i
                    k--;
                    i--;
                } else {
                    // Place the current element from nums2 at the end of the merged array
                    nums1[k] = nums2[j];
                    // Decrement both k and j
                    k--;
                    j--;
                }
            }
        }
    }
    
}
