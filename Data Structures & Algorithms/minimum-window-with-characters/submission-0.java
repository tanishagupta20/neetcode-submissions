class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        int l = 0, r = 0, reqCount = t.length();

        int[] reqFreq = new int[128];
        for(int i = 0; i < t.length(); i++){
            reqFreq[t.charAt(i)]++;
        }

        int[] winFreq = new int[128];
        int bestL = 0, bestR = 0, minLen = Integer.MAX_VALUE, window = 0;
        while(r < s.length()){
            winFreq[s.charAt(r)]++;
            if(winFreq[s.charAt(r)] <= reqFreq[s.charAt(r)]) reqCount--;
            while(reqCount == 0){
                window = r - l + 1;
                if(window < minLen){
                    minLen = window;
                    bestL = l;
                    bestR = r;
                }
                if(winFreq[s.charAt(l)] <= reqFreq[s.charAt(l)]) reqCount++;
                winFreq[s.charAt(l)]--;
                l++;
            }
            r++;
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(bestL, bestR + 1);
    }
}