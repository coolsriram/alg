package interview.crack.dynamic;

import java.util.Stack;

/**
 * Created by selvarajs on 2/25/16.
 */
public class RobotGrid2 {
    public static void main(String[] args) {
        int arr[][] = {
                {0, 0, 1, 0},
                {1, 0, 0, 1},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
        };

        Stack<Point> s = new Stack<>();
        boolean isPath = findPath(arr, 0, 0, new Stack<Point>());

        if (isPath){
            System.out.println("Found path");
            System.out.println(s);
        } else {
            System.out.println("Path not found");
        }
    }

    public static boolean findPath(int arr[][], int r, int c, Stack<Point> s){
        int maxR = arr.length;
        int maxC = arr[0].length;

        if (r == maxR || c == maxC){
            return false;
        }

        if (r == maxR - 1 && c == maxC - 1){
            s.push(new Point(r, c));
            return true;
        }

        if (arr[r][c] == 1){
            return false;
        }

        if (findPath(arr, r, c + 1, s)){
            s.push(new Point(r, c + 1));
            return true;
        } else if (findPath(arr, r + 1, c, s)){
            s.push(new Point(r + 1, c));
            return true;
        }

        return false;
    }

    static class Point{
        int r, c;

        Point(int r, int c){
            this.r = r;
            this.c = c;
        }

        public String toString(){
            return "(" + r + "," + c + ") ";
        }
    }
}
