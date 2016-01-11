package interview.crack.dynamic;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by selvarajs on 12/29/15.
 */
public class RobotGrid {
    public static void main(String[] args) {
        System.out.println("Robot Grid");

        int grid[][] = new int[][]{
                {1,2,3,4},
                {5,-1,7,8},
                {9,10,11,12}
        };

        List<Point> path = new ArrayList<>();
        System.out.println("Has path: " + getPath(grid, grid.length - 1, grid[0].length - 1, path));

        System.out.println(path);
    }

    public static boolean getPath(int[][] grid, int row, int col, List<Point> path) {

        if (row < 0 || col < 0){
            return false;
        } else if (grid[row][col] == -1){
            return false;
        }

        boolean isOrigin = (row == 0 && col == 0);

        if (isOrigin || getPath(grid, row - 1, col, path) || getPath(grid, row, col - 1, path)){
            Point p = new Point(row+1, col+1);
            path.add(p);
            return true;
        }

        return false;
    }
}
