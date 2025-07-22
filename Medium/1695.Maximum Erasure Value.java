class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet <Integer> seen = new HashSet<>();
        int start=0;
        int maxsum=0, currentsum=0; 

        for(int end=0;end<nums.length;end++){
            while(seen.contains(nums[end])){
                seen.remove(nums[start]);
                currentsum -= nums[start];
                start++;
            }
            seen.add(nums[end]);
            currentsum+=nums[end];
            maxsum=Math.max(maxsum,currentsum);
            
            
        }
        return maxsum;
    }
}
