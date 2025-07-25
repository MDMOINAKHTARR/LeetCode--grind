public class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {3, 1, 3, 4, 2};
        System.out.println("Duplicate: " + sol.findDuplicate(nums));  
    }
}
