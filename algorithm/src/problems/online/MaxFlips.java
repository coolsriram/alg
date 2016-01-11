package problems.online;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by selvarajs on 1/6/16.
 */
public class MaxFlips {

    //
    public static void main(String[] args) {

        int[] inputArr = {0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0};

        findMaxOne(inputArr, 1);

    }

    public static void findMaxOne (int[] inputArr, int maxFlip) {

        //Chk inputArr for null & maxFlip > 0

        List<Integer> zArrayList = new ArrayList<>();

        for (int inx = 0; inx < inputArr.length; inx++) {
            if (inputArr[inx] == 0){
                zArrayList.add(inx);
            }
        }

        if (maxFlip > zArrayList.size()) {
            // Print full zArrayLen
            System.out.print(zArrayList + "\t");
            return ;
        }



        // TODO: chk how to convert ArrayList to simple primite int array
        Integer[] zArray = new Integer[zArrayList.size()];
        zArrayList.toArray(zArray);

        int zArrayLen = zArray.length;


        int zSt = 0;
        int zEnd = (maxFlip - 1);

        int maxOnes = -1;
        int maxOneZSt = -1;
        int maxOneZEnd = -1;
        int oneSt = -1, oneEnd = -1;

        while (zEnd < zArrayLen) {

            // If zero start indx is 0, then consider from beg of one as 0
            if (zSt == 0) {
                oneSt = 0;
            } else if (zArray[zSt-1] == zArray[zSt]-1) { // Consequtive 0s
                oneSt = zArray[zSt];
            } else {
                oneSt = zArray[zSt - 1] + 1;
            }

            if (zEnd == zArrayLen - 1) { // last in index, then consider it till main array end
                oneEnd = inputArr.length - 1;
            } else {
                oneEnd = zArray[zEnd + 1];
            }

            if (maxOnes < (oneEnd - oneSt)) { // Found potential lengthy
                maxOnes = oneEnd - oneSt;
                maxOneZSt = zSt;
                maxOneZEnd = zEnd;
            }

            zSt++;
            zEnd++;

        }

        for (int zInx = maxOneZSt; zInx <= maxOneZEnd; zInx++) {
            System.out.println(zArray[zInx]);
        }

    }
}

