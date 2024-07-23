package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class Valid_Sudoku {
    public static void main(String[] args) {
    }
    public boolean isValidSudoku(char[][] board) {
        // Set to keep track of seen numbers in rows, columns, and 3x3 sub-boxes
        Set<String> seen = new HashSet<>();
        
        // Iterate through each cell in the 9x9 board
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char number = board[i][j];
                
                // If the cell is not empty
                if(number != '.'){
                    // Check if the number is already seen in the current row, column, or 3x3 block
                    if(!seen.add(number + " found in row " + i) ||
                        !seen.add(number + " found in column " + j) ||
                        !seen.add(number + " found in block " + i/3 + "-" + j/3)){
                        // If it is, the board is not valid
                        return false;
                    }
                }
            }
        }
        
        // If no duplicates are found, the board is valid
        return true;
    }
}

/*
Time Complexity (TC): O(1)
The board is always 9x9, so we always process 81 cells. Thus, the time complexity is constant, O(1).

Space Complexity (SC): O(1)
The space used for the HashSet is also constant because there are only a limited number of possible entries (27 rows + 27 columns + 27 blocks = 81 entries). Thus, the space complexity is O(1).
*/

