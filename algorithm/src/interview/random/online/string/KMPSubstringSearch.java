package interview.random.online.string;

/**
 * Created by selvarajs on 3/7/16.
 */
public class KMPSubstringSearch {
    // Tusar Roy's implementation
    public static void main(String[] args) {
        String s = "abcdabca";
        //s = "aabaabaaa";
        //s = "acacabacacabacacac";
        int[] cmp = buildComparator(s);
        printArray(cmp);

        String src = "aabcdabca";

        System.out.println(isPatternMatch(src, s));
    }

    public static int[] buildComparator(String pattern){
        int[] cmp = new int[pattern.length()];

        int j = 0;
        cmp[j] = 0;

        for (int i = 1; i < pattern.length(); i++){
            if (pattern.charAt(i) == pattern.charAt(j)){
                cmp[i] = j + 1;
                j++;
            } else {
                while (j > 0){
                    j = cmp[j - 1];

                    if (pattern.charAt(i) == pattern.charAt(j)) {
                        cmp[i] = j + 1;
                        j++;
                        break;
                    }
                }

                //either j == 0 or we found a match
                if (j == 0) {
                    cmp[i] = 0;
                }
            }
        }

        return cmp;
    }

    public static boolean isPatternMatch(String src, String pat){
        int pInx[] = buildComparator(pat);

        int m = src.length();
        int n = pat.length();

        int j = 0, i = 0;

        while (i < m && j < n){
            if (src.charAt(i) == pat.charAt(j)){
                j++;
            } else {
                while (j > 0){
                    j = pInx[j - 1];

                    if (src.charAt(i) == pat.charAt(j)){
                        j++;
                        break;
                    }
                }
            }

            i++;
        }

        return (j == n) ? true: false;
    }

    private static void printArray(int[] arr){
        System.out.println();
        for (int n: arr){
            System.out.print(n + "\t");
        }

        System.out.println();
    }
}
