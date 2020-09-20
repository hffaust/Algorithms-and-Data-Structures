//public class NumberOfIslands {
//}

/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1




Example 2:

Input:
11000
11000
00100
00011

Output: 3


 */

class NumberOfIslands {

    private void checkNeighbors(char[][] grid, int row_length, int column_length, int row, int column){
        if(row < 0 || column < 0 || row >= row_length || column >= column_length || grid[row][column] == '0'){
            return;
        }
        grid[row][column] = '0';
        checkNeighbors(grid, row_length, column_length, row - 1, column); //down
        checkNeighbors(grid, row_length, column_length, row + 1, column); //up
        checkNeighbors(grid, row_length, column_length, row, column - 1); //left
        checkNeighbors(grid, row_length, column_length, row, column + 1); //right
    }


    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int row_length = grid.length;
        int column_length = grid[0].length;
        int island_count = 0;
        for(int r = 0; r < row_length; ++r){
            for(int c = 0; c < column_length; ++c){
                if(grid[r][c] == '1'){
                    ++island_count;
                    checkNeighbors(grid, row_length, column_length, r, c);
                }
            }

        }
        return island_count;
    }
}


/*
// Alternate Solution


class Solution {
  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int nr = grid.length;
    int nc = grid[0].length;
    int num_islands = 0;

    for (int r = 0; r < nr; ++r) {
      for (int c = 0; c < nc; ++c) {
        if (grid[r][c] == '1') {
          ++num_islands;
          grid[r][c] = '0'; // mark as visited
          Queue<Integer> neighbors = new LinkedList<>();
          neighbors.add(r * nc + c);
          while (!neighbors.isEmpty()) {
            int id = neighbors.remove();
            int row = id / nc;
            int col = id % nc;
            if (row - 1 >= 0 && grid[row-1][col] == '1') {
              neighbors.add((row-1) * nc + col);
              grid[row-1][col] = '0';
            }
            if (row + 1 < nr && grid[row+1][col] == '1') {
              neighbors.add((row+1) * nc + col);
              grid[row+1][col] = '0';
            }
            if (col - 1 >= 0 && grid[row][col-1] == '1') {
              neighbors.add(row * nc + col-1);
              grid[row][col-1] = '0';
            }
            if (col + 1 < nc && grid[row][col+1] == '1') {
              neighbors.add(row * nc + col+1);
              grid[row][col+1] = '0';
            }
          }
        }
      }
    }

    return num_islands;
  }
}
 */