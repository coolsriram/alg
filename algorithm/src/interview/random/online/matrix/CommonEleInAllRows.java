package interview.random.online.matrix;

/**
 * Created by selvarajs on 1/19/16.
 */
public class CommonEleInAllRows {
    public static void main(String[] args) {
        int arr[][]={
                {1, 2, 3, 4, 6},
                {2, 4, 5, 6, 10},
                {3, 5, 6, 9, 11},
                {1, 3, 6, 7, 9}
        };

        findCommonElementInAllRows(arr);
    }

    public static void findCommonElementInAllRows(int arr[][]){
        int rMax = arr.length;
        int cMax = arr[0].length;
        boolean isMatchFound = false;
        int[] cIndex = new int[rMax];


        for (int c = 0; c < cMax; c++){
            int eleToChk = arr[0][c];
            isMatchFound = true;
            int curCol = -1;
            cIndex[0] = c;

            for (int r = 1; r < rMax; r++){
                curCol = cIndex[r];

                while (curCol < cMax){
                    if (arr[r][curCol] >= eleToChk){
                        break;
                    }

                    curCol++;
                }

                if (curCol == cMax || arr[r][curCol] != eleToChk){
                    isMatchFound = false;
                }
                cIndex[r] = curCol;
            }

            if (isMatchFound){
                System.out.println("Match Found: " + arr[0][c]);
                break;
            }
        }

        if (!isMatchFound){
            System.out.println("No common element found.");
        } else {
            for (int c: cIndex){
                System.out.print(" " + (c + 1));
            }
        }

    }
}
