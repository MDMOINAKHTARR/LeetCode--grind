import java.util.Arrays;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums); 

        for (int i = 1, n = nums.length; i < n; i++) {
            if (nums[i] == nums[i - 1]) return true;
        }

        return false;
    }
}
