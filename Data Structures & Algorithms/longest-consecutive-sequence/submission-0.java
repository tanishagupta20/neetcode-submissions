class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            hs.add(nums[i]);
        }

        int count = 0, len = 0, start = 0;
        
        for(int num : hs){
            if(!hs.contains(num - 1)){
                start = num;
                len = 1;
                while(hs.contains(start + 1)){
                    start++;
                    len++;
                }
                count = Math.max(count, len);
            }
        }

        return count;
    }
}