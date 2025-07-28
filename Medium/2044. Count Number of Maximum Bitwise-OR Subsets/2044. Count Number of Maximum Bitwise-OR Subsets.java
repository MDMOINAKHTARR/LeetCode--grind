class Solution {
    int maxOr = 0;
    int count = 0;

    public int countMaxOrSubsets(int[] nums) {
        backtrack(nums, 0, 0);
        return count;
    }

    private void backtrack(int[] nums, int index, int currentOr) {
        if (index == nums.length) {
            if (currentOr == maxOr) {
                count++;
            } else if (currentOr > maxOr) {
                maxOr = currentOr;
                count = 1;
            }
            return;
        }

        // Include current element
        backtrack(nums, index + 1, currentOr | nums[index]);

        // Exclude current element
        backtrack(nums, index + 1, currentOr);
    }
}
