package leetcode.medium;

import java.util.ArrayList;
import java.util.List;


public class findPermutation {
    /* this will take extra sapce for map and the data structure
     * public void permutation(int[] nums, List<List<Integer>> ans, List<Integer> ds, boolean map[]) {
        if (ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!map[i]) {
                map[i] = true;
                ds.add(nums[i]);
                permutation(nums, ans, ds, map);
                ds.remove(ds.size() - 1);
                map[i] = false;
            }
        }
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean map[] = new boolean[nums.length];
        permutation(nums, ans, ds, map);
        return ans;
    }
*/
    public static void main(String[] args) {
        findPermutation obj = new findPermutation();
        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> result = obj.permute(nums);

        // Print the permutations
        for (List<Integer> perm : result) {
            System.out.println(perm);
        }
    }

    //new method with no extra space



    public List<List<Integer>> permute (int nums[]){
        List<List<Integer>> ans = new ArrayList<>();
        recurPermute(0, nums, ans);
        return ans;
    }

    private void recurPermute(int index, int[] nums, List<List<Integer>> ans) {

        if(index == nums.length){
            List<Integer> ds = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = index; i < nums.length; i++){
            swap(i , index ,nums);
            recurPermute(index + 1, nums, ans);
            swap(index, i, nums);

        }
    }
    public void swap(int i, int j, int nums[]){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
