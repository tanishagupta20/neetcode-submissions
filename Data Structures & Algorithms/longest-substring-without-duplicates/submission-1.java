class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = 0, start = 0, end = 0;
        HashSet<Character> hs = new HashSet<>();

        while(end < s.length()){
            if(!hs.contains(s.charAt(end))){
                hs.add(s.charAt(end));
                len = Math.max(len, end - start + 1);
                end++;
            }
            else{
                hs.remove(s.charAt(start));
                start++;
            }
        }

        return len;
    }
}