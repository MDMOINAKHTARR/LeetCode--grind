class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        int maxLen = 0, currentLen = 0;

        for (int num : nums) {
            if (num > max) {
                max = num;
                currentLen = 1;
                maxLen = 1;
            } else if (num == max) {
                currentLen++;
                maxLen = Math.max(maxLen, currentLen);
            } else {
                currentLen = 0;
            }
        }

        return maxLen;
    }
}
