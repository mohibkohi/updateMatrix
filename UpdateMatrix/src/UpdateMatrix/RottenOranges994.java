package UpdateMatrix;
public class RottenOranges994 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] oranges = {{2,1,1},{1,1,0},{0,1,1}};
		int minutes = orangesRotting(oranges);
		System.out.println("Minutes = " + minutes);
	}
	
	public static int orangesRotting(int[][] grid) {

    	for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
               if(grid[row][col] == 2){
                   updateDFS(grid, row, col, 2);
               }
            }
        }
        int count = 2;

        for(int row = 0; row < grid.length; row++){
    		boolean update = false;
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 1){
                    return -1;
                }
                count = Math.max(count, grid[row][col]);
            }
        }
    	return count -2;
    	
    }

    private static void updateDFS(int[][] grid, int row, int col, int minutes){
        if(row < 0 || row >= grid.length 
            || col < 0 || col >= grid[0].length
            || grid[row][col] == 0
            || (grid[row][col] > 1 && grid[row][col] < minutes)
            ){
                return;
            }else {
                grid[row][col] = minutes;
                updateDFS(grid, row - 1, col, minutes + 1);
                updateDFS(grid, row + 1, col, minutes + 1);
                updateDFS(grid, row, col - 1, minutes + 1);
                updateDFS(grid, row, col + 1, minutes + 1);
            }
    }
	

}
