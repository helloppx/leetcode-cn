class Solution {
    public int majorityElement(int[] nums) {
        int half = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer each : nums){
            Integer count = map.getOrDefault(each, 0);
            map.put(each, ++count);
            if(count > half) return each;
        }
        return 0;
    }
}
