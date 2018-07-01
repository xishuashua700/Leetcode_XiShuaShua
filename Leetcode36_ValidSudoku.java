  /* For cube, we'd like the index to be 0, 1, 2. We notice that index [0, 8] can generate index/3 and index%3 in range [0, 1, 2]
   
   
           i: 0 1 2 3 4 5 6 7 8
3 * (i / 3):  0 0 0 3 3 3 6 6 6 
3 * (i % 3):  0 3 6 0 3 6 0 3 6
           j: 0 1 2 3 4 5 6 7 8
     j / 3:   0 0 0 1 1 1 2 2 2
     j % 3:   0 1 2 0 1 2 0 1 2

i = 0, j = [0, 8]
rowIndex: 0   colIndex: 0
rowIndex: 0   colIndex: 1
rowIndex: 0   colIndex: 2
rowIndex: 1   colIndex: 0
rowIndex: 1   colIndex: 1
rowIndex: 1   colIndex: 2
rowIndex: 2   colIndex: 0
rowIndex: 2   colIndex: 1
rowIndex: 2   colIndex: 2

i = 1, j = [0, 8]
rowIndex: 0   colIndex: 3
rowIndex: 0   colIndex: 4
rowIndex: 0   colIndex: 5
rowIndex: 1   colIndex: 3
rowIndex: 1   colIndex: 4
rowIndex: 1   colIndex: 5
rowIndex: 2   colIndex: 3
rowIndex: 2   colIndex: 4
rowIndex: 2   colIndex: 5
    */


class Solution {
    
    // Edward Shi
    public boolean isValidSudoku(char[][] board) {
        
        if(board == null || board.length != 9 || board[0].length != 9) return false;
        
        for (int i = 0; i < board.length; i++) {
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> cube = new HashSet<>();
            for(int j = 0; j < board[0].length; j++){
                System.out.println("i: " + i + "  j: " + j);
                if(board[i][j] != '.' && !row.add(board[i][j])) return false;
                if(board[j][i] != '.' && !col.add(board[j][i])) return false;
                
                int rowIndex = 3 * (i / 3) + j / 3;
                int colIndex = 3 * (i % 3) + j % 3;
                if (board[rowIndex][colIndex] != '.' && !cube.add(board[rowIndex][colIndex])) return false;
                //System.out.println("rowIndex: " + rowIndex + "   colIndex: " + colIndex);
            }
        }
        
        return true;
    }
}
