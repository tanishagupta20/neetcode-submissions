class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1, max = Integer.MIN_VALUE;
        for(int i = 0; i < piles.length; i++){
            max = Math.max(max, piles[i]);
        }

        while(min < max){
            int mid = min + (max - min) / 2;
            int hrs = 0;
            for(int pile : piles){
                hrs += Math.ceil((double) pile / mid);
            }
            if(hrs <= h){
                max = mid;
            }
            else min = mid + 1;
        }

        return min;
    }
}