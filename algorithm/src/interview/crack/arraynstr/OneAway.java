package interview.crack.arraynstr;

/**
 * Created by selvarajs on 12/27/15.
 */
public class OneAway {

    public static void main (String[] args) {
        System.out.println("OneAway");

        isOneAway("Pale", "Ple");
        isOneAway("Pales", "Pale");
        isOneAway("Pale", "bale");
        isOneAway("Pale", "bake");

    }

    public static boolean isOneAway(String s1, String s2){
        boolean isOneAway = false;

        System.out.print(s1 + "," + s2);

        //chk for valid s1, s2 & diff length > 1, return false

        int diff = Math.abs(s1.length() - s2.length());

        if (diff == 0) {
            isOneAway = checkForReplace (s1, s2);
        } else {
            isOneAway = checkForRemoval (s1, s2);
        }

        System.out.println(" is " + isOneAway);
        return isOneAway;
    }

    private static boolean checkForReplace(String s1, String s2){
        int s1Inx = 0, s2Inx = 0;
        boolean isReplaceFound = false;

        while (s1Inx < s1.length() && s2Inx < s2.length()){
            if (s1.charAt(s1Inx) != s2.charAt(s2Inx)){
                if (isReplaceFound){
                    return false;
                }

                isReplaceFound = true;
                s1Inx++; s2Inx++;
            } else {
                s1Inx++; s2Inx++;
            }

        }

        return true;
    }

    private static boolean checkForRemoval(String s1, String s2){
        int s1Inx = 0, s2Inx = 0;
        boolean isRemovalFound = false;

        while (s1Inx < s1.length() && s2Inx < s2.length()){
            if (s1.charAt(s1Inx) != s2.charAt(s2Inx)){
                if (isRemovalFound){
                    return false;
                }

                isRemovalFound = true;
                if (s1.length() > s2.length()){
                    s1Inx++;
                } else {
                    s2Inx++;
                }
            } else {
                s1Inx++; s2Inx++;
            }
        }

        return true;
    }
}
