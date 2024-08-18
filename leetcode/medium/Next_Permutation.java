package leetcode.medium;

public class Next_Permutation {
    public static void main(String[] args) {
        
    }
    class Solution {
        public void nextPermutation(int[] nums) {
            int n = nums.length;
            int i = n - 2;
    
            // Step 1: Find the first decreasing element from the right
            // (i.e., find the pivot where nums[i] < nums[i + 1])
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--;
            }
    
            // Step 2: If such a pivot is found
            if (i >= 0) {
                // Find the first element greater than nums[i] from the right
                int j = n - 1;
                while (nums[i] >= nums[j]) {
                    j--;
                }
                // Swap the elements to ensure the next permutation is larger
                swap(i, j, nums);
            }
    
            // Step 3: Reverse the elements after the pivot to get the smallest possible order
            reverse(i + 1, n - 1, nums);
        }
    
        // Swap elements at index i and j
        public void swap(int i, int j, int[] nums) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    
        // Reverse the elements from index i to j
        public void reverse(int i, int j, int[] nums) {
            while (i < j) {
                swap(i, j, nums);
                i++;
                j--;
            }
        }
    
        /**
         * Time Complexity: O(n)
         * - Finding the first decreasing element takes O(n).
         * - Finding the first element greater than nums[i] from the right takes O(n) in the worst case.
         * - Reversing the elements after the pivot takes O(n).
         * 
         * Overall, the time complexity is O(n).
         * 
         * Space Complexity: O(1)
         * - The algorithm modifies the input array in place and does not use any additional space.
         * 
         * Overall, the space complexity is O(1).
         */
    }
    
}


/*
 * Intuition for the Brute Force Approach
The brute force approach to solving the "Next Permutation" problem is based on generating all possible permutations of the given array and then identifying the next permutation in lexicographical order. Here's the step-by-step intuition:

Generate All Permutations:

The first step is to generate all possible permutations of the given array. A permutation is simply a rearrangement of the elements in the array.
For an array of length 
𝑛
n, there are 
𝑛
!
n! possible permutations.
Sort the Permutations:

Once all permutations are generated, they are sorted in lexicographical order (like dictionary order). This makes it easy to find the "next" permutation after the current one.
Identify the Next Permutation:

After sorting, locate the current permutation within the sorted list. The "next permutation" is simply the permutation that follows the current one in this sorted list.
If the current permutation is the last one in the sorted order (i.e., the largest possible permutation), the "next permutation" is the first one in the sorted order (i.e., the smallest possible permutation).
Output the Result:

The final step is to replace the original array with the next permutation identified in the previous step.
Why is it Called Brute Force?
This method is called brute force because it exhaustively generates all possible permutations and sorts them, which is not efficient for larger arrays.
The time complexity of generating all permutations is 
𝑂
(
𝑛
!
)
O(n!), and sorting them adds additional overhead. Therefore, this approach is very slow and impractical for large input sizes.
However, it is straightforward and easy to understand, which is why it's a common first step when approaching permutation problems.
Example
For the array [1, 2, 3]:

All permutations: [1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1].
Sorting them in lexicographical order gives the same list.
If the current permutation is [1, 2, 3], the next permutation is [1, 3, 2].
If the current permutation is [3, 2, 1], since it's the last permutation in lexicographical order, the next permutation would wrap around to [1, 2, 3].
This brute force method provides a simple, though inefficient, way to solve the problem and helps build an understanding before moving on to more optimal solutions.
 */
