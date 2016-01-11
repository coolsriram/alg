package com.random.excersice;

/**
 * Created by selvarajs on 12/14/15.
 */
public class CollectionMain {

    public static void findBestDaysToTrade(int[] values) {

        // Check input for null & length > 1

        int highestDiff = 0;
        int dayToBuy = -1, dayToSell = -1;

        int curSmallInx = 0;
        int curSmallValue = values[0];

        for (int inx = 1; inx < values.length; inx++) {
            int curValue = values[inx];

            // If we find smaller index, record it & continue
            if (curValue < curSmallValue) {
                curSmallValue = curValue;
                curSmallInx = inx;
                continue;
            }

            // If we find a greater difference value, then record it
            if ((curValue-curSmallValue) > highestDiff) {
                highestDiff = curSmallValue = curValue;
                dayToBuy = curSmallInx;
                dayToSell = inx;
            }
        }

        System.out.println ("dayToBuy: " + (dayToBuy+1) + ", dayToSell: " + (dayToSell+1) + ", margin: " + highestDiff);
    }


    public static void main(String args[]){
        System.out.println("Starting, fingers crossed..");

        int[] input = new int[]{10,4,3,14,13,6,5,8};

        findBestDaysToTrade(input);
    }
}
