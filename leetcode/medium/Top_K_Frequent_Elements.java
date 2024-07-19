package leetcode.medium;

/* question
 Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 */



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* 
 First method brute force (Intuition) T.C = O(nlogn) time complexity of sorting. S.C = O(n)
 Count the frequency of each element in the array using a hash map.
 Sort the elements based on their frequency.
 Return the top k elements from the sorted list.
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count the frequency of each element
        Map <Integer, Integer> frequencyElement = new HashMap <>();
        for (int num : nums) {
            frequencyElement.put(num, frequencyElement.getOrDefault(num, 0) + 1);
        }
        // Step 2: Sort the elements based on their frequency
        List<Integer> sortedElemnt = new ArrayList<>(frequencyElement.keySet());
        sortedElemnt.sort((a,b) -> frequencyElement.get(b) - frequencyElement.get(a));
        // Step 3: Return the top k elements
        int[] topK = new int[k];
        for(int i = 0;i < k; i++){
            topK[i] = sortedElemnt.get(i);
        }
        return topK;
    } 
}
/* 
 Second method bucket sort (intution) T.C = O(n) S.C = O(n) 
 Count the Frequency:
    Use a HashMap to count the frequency of each element.
Bucket Sort:
    Use an array of lists (buckets) to group elements by their frequency.
Extract Top K Elements:
    Iterate through the buckets in descending order of frequency and collect the top k elements.
 */
class Sol {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Initialize a bucket array where index represents frequency
        List<Integer>[] Bucket = new List[nums.length + 1];

        // Step 2: Use a HashMap to count the frequency of each element
        Map<Integer, Integer> frequencyElement = new HashMap<>();
        for (int num : nums) {
            // Get the current count of num and increment by 1
            frequencyElement.put(num, frequencyElement.getOrDefault(num, 0) + 1);
        }

        // Step 3: Place elements into buckets based on their frequency
        for (int key : frequencyElement.keySet()) {
            int frequency = frequencyElement.get(key);
            if (Bucket[frequency] == null) {
                // Initialize the bucket if it's not already initialized
                Bucket[frequency] = new ArrayList<>();
            }
            // Add the element to the appropriate bucket
            Bucket[frequency].add(key);
        }

        // Step 4: Collect the top k frequent elements from the bucket
        int[] res = new int[k];
        int counter = 0;
        // Traverse the bucket array from the end (highest frequency) to the start
        for (int pos = Bucket.length - 1; pos >= 0 && counter < k; pos--) {
            if (Bucket[pos] != null) {
                // Add all elements from the current bucket to the result
                for (int i : Bucket[pos]) {
                    res[counter++] = i;
                    // If we have collected k elements, we can stop
                    if (counter == k) {
                        break;
                    }
                }
            }
        }
        return res;
    }
}



