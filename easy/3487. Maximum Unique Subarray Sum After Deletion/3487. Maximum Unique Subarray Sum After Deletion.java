class Solution {
    public int maxSum(int[] nums) {
       
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }

       
        if (max <= 0) {
            return max;
        }

       
        Set<Integer> unique = new HashSet<>();
        int sum = 0;

        for (int num : nums) {
           
            if (num >= 0 && unique.add(num)) {
                sum += num;
            }
        }

        return sum;
    }
}
