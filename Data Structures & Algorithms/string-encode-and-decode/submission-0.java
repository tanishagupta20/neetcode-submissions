class Solution {

    public String encode(List<String> strs) {
        String s = "";
        for(int i = 0; i < strs.size(); i++){
            int size = strs.get(i).length();
            s += size + "#" + strs.get(i);
        }
        return s;
    }

    public List<String> decode(String str) {
         List<String> result = new ArrayList<>();
         int i = 0;
        while(i < str.length()){
            String num = "";
            while(str.charAt(i) != '#'){
                num += str.charAt(i);
                i++;
            }
            int freq = Integer.parseInt(num);
            result.add(str.substring(i + 1, freq + i + 1));
            i = freq + i + 1;
        }
        return result;
    }
}
