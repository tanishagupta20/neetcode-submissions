class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> arr = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];
        for(int i = 0; i < strs.length; i++){
            if(visited[i]) continue;
            List<String> l = new ArrayList<>();
            l.add(strs[i]);
            visited[i] = true;
            char[] baseArr = strs[i].toCharArray();
            Arrays.sort(baseArr);
            String baseSorted = new String(baseArr);
            for(int j = i + 1; j < strs.length; j++){
                if(visited[j]) continue;
                char[] charArr = strs[j].toCharArray();
                Arrays.sort(charArr);
                String sorted = new String(charArr);
                if(sorted.equals(baseSorted)){
                    l.add(strs[j]);
                    visited[j] = true;
                }
            }
            arr.add(l);
        }
        return arr;
    }
}
