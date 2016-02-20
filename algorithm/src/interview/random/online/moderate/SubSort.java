package interview.random.online.moderate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by selvarajs on 2/5/16.
 */
public class SubSort {

    // Wrong Implementation

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(7);
        list.add(10);
        list.add(11);
        list.add(7);
        list.add(12);
        list.add(6);
        list.add(7);
        list.add(16);
        list.add(17);
        list.add(18);

        subSort(list);
    }

    public static void subSort(List<Integer> list){
        if (list == null || list.size() < 0){
            System.out.println("Invalid input");
            return;
        }

        int l = 0, r = list.size() - 1, i = 1;

        l = findMaxOrdInx (list, true);
        r = findMaxOrdInx (list, false);

        System.out.println("l & r found");

        if (l > r){
            System.out.println("Input is sorted array.");
            return;
        }

        List<Integer> lList = list.subList(0, l);
        List<Integer> rList = list.subList(r, list.size());
        List<Integer> mList = list.subList(l + 1, r);

        Collections.sort(mList);

        System.out.println("Middle array got");

        int min = (mList.size() == 0)? rList.get(0): Math.min(rList.get(0), mList.get(0));

        l = lList.size() - 1;
        while (l > 0 && lList.get(l) <= min){
            l--;
        }

        min = (mList.size() == 0)? lList.get(lList.size() - 1) : Math.max(lList.get(lList.size() - 1),
                mList.get(mList.size() - 1));

        r = 0;

        while (r < rList.size() && rList.get(r) >= min){
            r++;
        }

        System.out.println((l+1) + "," + (r-1));
    }

    private static int findMaxOrdInx(List<Integer> list, boolean isAsc) {
        System.out.println("FindMin/Max: " + isAsc);
        int i = -1;

        if (isAsc){

            for (i = 1; i < list.size(); i++){
                if (list.get(i) < list.get(i - 1)){
                    i--;
                    break;
                }
            }

            /*while (i < list.size()){
                if (list.get(i) < list.get(i - 1)){
                    i++;
                    break;
                }

                i++;
            }*/
        } else {
            for (i = list.size() - 2; i >= 0; i--){
                if (list.get(i) > list.get(i - 1)){
                    i++;
                    break;
                }
            }

            /*while ( i > 0){
                if (list.get(i) > list.get(i + 1)){
                    i--;
                    break;
                }

                i--;
            }*/
        }

        System.out.println("FindMin/Max: " + i);
        return i;
    }
}
