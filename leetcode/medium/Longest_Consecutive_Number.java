package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class Longest_Consecutive_Number {
    public static void main(String[] args) {
        
    }
    public int longestConsecutive(int[] nums) {
        // Create a set to store unique numbers from the input array
        Set<Integer> numSet = new HashSet<>();
        
        // Add each number from the input array to the set
        for (int num : nums) {
            numSet.add(num);
        }
    
        // Initialize the variable to keep track of the longest streak
        int longestStreak = 0;
    
        // Iterate over each number in the set
        for (int num : numSet) {
            // Check if the current number is the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentStart = num;  // Starting number of the current sequence
                int currentStreak = 1;   // Length of the current sequence
                
                // Continue to find the next consecutive numbers
                while (numSet.contains(currentStart + 1)) {
                    currentStart = currentStart + 1;  // Move to the next number in the sequence
                    currentStreak = currentStreak + 1;  // Increment the length of the current sequence
                }
    
                // Update the longest streak found so far
                longestStreak = Math.max(currentStreak, longestStreak);
            }
        }
    
        // Return the length of the longest consecutive sequence
        return longestStreak;
    }
    
    /*
    Time Complexity (TC):
    - Building the set with all unique numbers takes O(n) time, where n is the number of elements in the input array.
    - The outer loop iterates over each element in the set, which is O(n) in the worst case.
    - The inner while loop runs in total O(n) times across all iterations of the outer loop, because each number is processed once.
    - Thus, the overall time complexity is O(n).
    
    Space Complexity (SC):
    - The primary space usage is the HashSet to store unique numbers, which requires O(n) space.
    - Additional space usage includes variables for the longest streak, current start, and current streak, which are O(1).
    - Thus, the overall space complexity is O(n).
    */
    
    }


