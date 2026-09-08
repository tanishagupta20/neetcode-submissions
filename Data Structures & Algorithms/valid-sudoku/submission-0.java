class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> hs = new HashSet<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] != '.'){
                    if(!hs.add(board[i][j] + "row" + i) || !hs.add(board[i][j] + "col" + j) || !hs.add(board[i][j] + "block" + (i / 3) + "," + (j / 3))) return false;
                }
            }
        }
        return true;
    }
}