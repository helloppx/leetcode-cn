class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        
        // map.get(x) - map.get(y)是小根堆
        // map.get(y) - map.get(x)是大根堆
        // 当k小, nums长的时候，小根堆维护起来可能会快一点
        PriorityQueue<Integer> q = new PriorityQueue<Integer>((x, y ) -> map.get(x) - map.get(y) );
        
        for(Integer x : map.keySet()){
            q.add(x);
            if(q.size() > k){
                q.poll();
            }
        }
        List<Integer> res = new ArrayList<>();
        while(q.size() != 0){
            res.add(q.poll());
        }
        Collections.reverse(res);
        return res;
    }
}
