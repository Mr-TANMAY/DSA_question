package leetcode.easy;

public class Two_Sum_II_Input_Array_Is_Sorted {
    public static void main(String[] args) {
        
    }
    public int[] twoSum(int[] numbers, int target) {
        // Initialize two pointers: one at the beginning and one at the end of the array
        int i = 0;
        int j = numbers.length - 1;
    
        // Iterate while the two pointers do not cross
        while (i < j) {
            // Calculate the sum of the elements at the two pointers
            int sum = numbers[i] + numbers[j];
    
            // Check if the sum equals the target
            if (sum == target) {
                // Return the 1-based indices of the two numbers
                return new int[]{i + 1, j + 1};
            }
            // If the sum is greater than the target, move the right pointer left to decrease the sum
            else if (sum > target) {
                j--;
            }
            // If the sum is less than the target, move the left pointer right to increase the sum
            else {
                i++;
            }
        }
    
        // Return an empty array if no valid pair is found (though the problem guarantees a solution)
        return new int[]{};
    }
}
/*
 * Time Complexity (TC):
 * - The while loop iterates through the array with two pointers moving towards each other.
 * - Each pointer moves at most n times, where n is the length of the array.
 * - Thus, the time complexity is O(n), where n is the length of the array.

 * Space Complexity (SC):
 * - The space complexity is O(1) because no extra space is used that scales with the input size.
 * - Only a few variables are used (i, j, sum), and the result array size is constant (2 elements).
 */
