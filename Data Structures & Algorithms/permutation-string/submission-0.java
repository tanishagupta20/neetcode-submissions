class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] arr1 = new int[26];
        for(int i = 0; i < s1.length(); i++){
            arr1[s1.charAt(i) - 'a']++;
        }

        int[] arr2 = new int[26];
        int i = 0, j = 0;
        int window = s1.length();

        while(j < s2.length()){
            arr2[s2.charAt(j) - 'a']++;
            if(j - i + 1 == window){
                if(Arrays.equals(arr1, arr2)) return true;
                else{
                    arr2[s2.charAt(i) - 'a']--;
                    i++;
                }
            }
            j++;
        }
        return false;
    }
}