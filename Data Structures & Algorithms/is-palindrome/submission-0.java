class Solution {
    public boolean isPalindrome(String s) {
        if(s == " ") return true;

        String woSpaces = "";

        for(int i = 0; i < s.length(); i++){
            if((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')) woSpaces += Character.toLowerCase(s.charAt(i));
        }

        int i = 0, j = woSpaces.length() - 1;
        while(i <= j){
            if(woSpaces.charAt(i) == woSpaces.charAt(j)){
                i++;
                j--;
            }
            else return false;
        }

        return true;
    }
}