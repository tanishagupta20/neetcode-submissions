class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        ArrayList<Integer> bucket[] = new ArrayList[nums.length + 1];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        for(int num : hm.keySet()){
            int freq = hm.get(num);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(num);
        }

        int[] res = new int[k];
        int idx = 0;

        for(int i = bucket.length - 1; i >= 0; i--){
            if(bucket[i] != null){
                for(int num : bucket[i]){
                    res[idx] = num;
                    idx++;
                    if(idx == k) return res;
                }
            }
        }
        return res;
    }
}