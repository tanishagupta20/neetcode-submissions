class Solution {
    public int[] productExceptSelf(int[] nums) {
        int res[] = new int[nums.length];
        int[] preSum = new int[nums.length];
        int[] suffSum = new int[nums.length];
        preSum[0] = 1;
        suffSum[nums.length - 1] = 1;

        for(int i = 1; i < nums.length; i++){
            preSum[i] = preSum[i - 1] * nums[i - 1];
        }

        for(int i = nums.length - 2; i >= 0; i--){
            suffSum[i] = suffSum[i + 1] * nums[i + 1];
        }

        for(int i = 0; i < nums.length; i++){
            res[i] = preSum[i] * suffSum[i];
        }

        return res;
    }
}