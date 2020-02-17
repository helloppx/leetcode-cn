class Solution {
    //找到第一个比左边元素小的就行
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0; 
         
        int i = 1;
        while(i < nums.length){
            if(nums[i]  < nums[i-1]) {
                return i - 1;
            }
            i++;
        }
        return i - 1;
    }
}
