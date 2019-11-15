class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] xmax = new int[grid.length];
        int[] ymax = new int[grid[0].length];
        int answer = 0;

        for(int i = 0; i < grid.length; i++){
            int max = 0;
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] > max){
                    max = grid[i][j];
                }
            }
            xmax[i] = max;
        }

        for(int i = 0; i < grid[0].length; i++){
            int max = 0;
            for(int j = 0; j < grid.length ; j++){
                if(grid[j][i] > max){
                    max = grid[j][i];
                }
            }
            ymax[i] = max;
        }

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                int max = xmax[i]>ymax[j] ? ymax[j] : xmax[i];
                answer += max - grid[i][j];
            }
        }

        return answer;
    }
}

public class lc807{
    public static void main(String[] args){
        int[][] grid = {{3, 0, 8, 4}, 
                        {2, 4, 5, 7},
                        {9, 2, 6, 3},
                        {0, 3, 1, 0}} ;
                        
        Solution solution = new Solution();
        int answer = solution.maxIncreaseKeepingSkyline(grid);
        System.out.printf("答案：%3d%n", answer);
    }
}