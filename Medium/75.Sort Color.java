class Solution {
    public void sortColors(int[] nums) {
        int start=0;
        int middle =0;
        int end= nums.length-1;

        while(middle <= end){
            if(nums[middle]==0){
                int temp1 = nums[start];
                nums[start]=nums[middle];
                nums[middle]= temp1;
            start++;
            middle++;    
            }
            else if(nums[middle]==1){
            middle++;
            }
            else{
            int temp2 = nums[end];
            nums[end] = nums[middle];
            nums[middle] = temp2;

            end--;
            }
        }
        
    }
}
