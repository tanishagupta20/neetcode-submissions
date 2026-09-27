class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
      int[] res = new int[nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        int l = 0, r = 0, idx = 0;

        while(r < nums.length){
            while(!q.isEmpty() && nums[q.peekLast()] < nums[r]){
                q.pollLast();
            }
            q.offerLast(r);
            if(q.peekFirst() < l){
                q.pollFirst();
            }
            if(r - l + 1 == k){
                res[idx] = nums[q.peekFirst()];
                idx++;
                l++;
            }
            r++;
        }

        return res;  
    }
}
