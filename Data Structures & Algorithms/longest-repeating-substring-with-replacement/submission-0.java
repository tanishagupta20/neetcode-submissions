class Solution {
    public int characterReplacement(String s, int k) {
        int len = 0, left = 0, right = 0, maxLen = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        while(right < s.length()){
            hm.put(s.charAt(right), hm.getOrDefault(s.charAt(right), 0) + 1);
            len = Math.max(len, hm.get(s.charAt(right)));
            int window = right - left + 1;
            if(window - len <= k) maxLen = Math.max(maxLen, window);
            else{
                hm.put(s.charAt(left), hm.get(s.charAt(left)) - 1);
                left++;
            }
            right++;
        }
        return maxLen;
    }
}