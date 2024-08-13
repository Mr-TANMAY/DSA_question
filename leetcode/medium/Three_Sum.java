package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Three_Sum {
    public static void main(String[] args) {
        
    }
    // Solution 1: Brute Force Approach (Time Limit Exceeded)
    public List<List<Integer>> threeSum(int[] nums) {
    // List to store the resulting triplets
    List<List<Integer>> result = new ArrayList<>();

    // Iterate through each element as the first element of the triplet
    for(int i = 0; i < nums.length - 2; i++) {
        // Iterate through each element after the current i as the second element
        for(int j = i + 1; j < nums.length - 1; j++) {
            // Iterate through each element after the current j as the third element
            for(int k = j + 1; k < nums.length; k++) {
                // Check if the sum of the triplet is zero
                if(nums[i] + nums[j] + nums[k] == 0) {
                    // Create a new triplet list
                    List<Integer> newList = new ArrayList<>();
                    newList.add(nums[i]);
                    newList.add(nums[j]);
                    newList.add(nums[k]);
                    // Sort the triplet to avoid duplicates
                    newList.sort(Integer::compareTo);
                    // Check if the triplet is not already in the result
                    if(!result.contains(newList)) {
                        result.add(newList);
                    }
                }
            }
        }
    }

    // Return the list of triplets
    return result;
}

/*
 * Time Complexity (TC): O(n^3)
 * - The code uses three nested loops to check all possible triplets.
 * - The outer loop runs approximately n - 2 times, the middle loop runs approximately n - 1 times, and the inner loop runs approximately n times.
 * - Therefore, the time complexity is O(n^3), where n is the length of the array.

 * Space Complexity (SC): O(n)
 * - The space complexity mainly depends on the size of the result list, which stores the triplets. 
 * - In the worst case, the space complexity can be O(n), if all triplets are valid and added to the result list.
 */

 // Solution 2: Two Pointer Approach (Time Complexity: O(n^2))

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       // If the input array is null or has less than 3 elements, return an empty list
       if(nums == null || nums.length < 3) return new ArrayList<>();
       
       // Sort the array to facilitate the two-pointer approach
       Arrays.sort(nums);

       // Use a set to avoid duplicate triplets
       Set<List<Integer>> result = new HashSet<>();
       
       // Iterate through the array
       for(int i = 0; i < nums.length - 2; i++){
            int left = i + 1; // Pointer to the element just after the current element
            int right = nums.length - 1; // Pointer to the last element
            
            // While left and right pointers do not cross
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                
                // If the sum is zero, add the triplet to the result set
                if(sum == 0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                }
                // If the sum is greater than zero, move the right pointer to the left
                else if(sum > 0){
                    right--;
                }
                // If the sum is less than zero, move the left pointer to the right
                else{
                    left++;
                }
            }
       }
       
       // Convert the set of triplets to a list and return it
       return new ArrayList<>(result);
    }
}

/*
 * Time Complexity (TC): O(n^2)
 * - Sorting the array takes O(n log n).
 * - The main loop runs approximately n - 2 times, and for each iteration, the two-pointer search takes O(n).
 * - Therefore, the overall time complexity is O(n^2), which is much more efficient than the brute-force approach.

 * Space Complexity (SC): O(n)
 * - The space complexity is mainly due to the extra space used by the set to store the unique triplets.
 * - The space used by the set is O(n), where n is the number of unique triplets.
 * - Sorting the array also requires O(log n) space due to the recursion stack used by the sorting algorithm, but this is usually negligible compared to the space used by the set.
 */

}
