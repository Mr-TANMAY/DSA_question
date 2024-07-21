package leetcode.medium;

import java.util.Arrays;

public class Product_of_Except_Self {

    // Brute force approach: Nested loops
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];

        // Time Complexity: O(n^2) - due to nested loops
        // Space Complexity: O(1) - aside from the output array
        
        // Loop through each element in nums
        for (int i = 0; i < n; i++) {
            int pro = 1; // Initialize product for each element
            // Loop through nums again to calculate the product of all elements except nums[i]
            for (int j = 0; j < n; j++) {
                if (i == j) continue; // Skip the current element
                pro = pro * nums[j]; // Multiply elements except the current one
            }
            ans[i] = pro; // Store the product in ans[i]
        }
        
        return ans;
    }

    // Approach using division (assuming no element in nums is zero)
    // Time Complexity: O(n) - one pass to compute total product and one pass to divide
    // Space Complexity: O(1) - aside from the output array
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int pro = 1;
        
        
        // Calculate the product of all elements in nums
        for (int i : nums) {
            pro = pro * i;
        }
        
        // Divide the total product by each element to get the product of all elements except itself
        for (int i = 0; i < n; i++) {
            ans[i] = pro / nums[i];
        }
        return ans;
    }

    // Approach using left and right arrays

    // Time Complexity: O(n) - Three separate loops each iterate over n elements.
    // Space Complexity: O(n) - Two additional arrays of size n are used.
    public int[] productExceptSelf(int[] nums) {
        // Array to store the product of all elements to the left of each element
        int[] left = new int[nums.length]; 
        // Array to store the product of all elements to the right of each element
        int[] right = new int[nums.length];
        
        left[0] = 1; // There are no elements to the left of the first element
        // Fill the left array
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        } 
        
        right[nums.length - 1] = 1; // There are no elements to the right of the last element
        // Fill the right array
        for (int i = nums.length - 2; i > -1; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        
        int[] ans = new int[nums.length];
        // Calculate the product of elements except self by multiplying left and right arrays
        for (int i = 0; i < nums.length; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }

    // Optimal approach with O(1) space complexity (excluding the output array)
    // Time Complexity: O(n) - Two separate loops each iterate over n elements.
    // Space Complexity: O(1) - Only a constant amount of extra space is used (excluding the output array).
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        Arrays.fill(ans, 1); // Initialize the ans array with 1s
        
        int curr = 1;
        // First pass: Calculate the product of all elements to the left of each element
        for (int i = 0; i < n; i++) {
            ans[i] = ans[i] * curr; // Multiply the current product to ans[i]
            curr = curr * nums[i]; // Update the current product
        }
        
        curr = 1;
        // Second pass: Calculate the product of all elements to the right of each element
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = ans[i] * curr; // Multiply the current product to ans[i]
            curr = curr * nums[i]; // Update the current product
        }
        return ans;
    }
}
