package dp;

public class LCS {
    public static void main(String args[]) {

        LCS lcs = new LCS();
        String s1 = "abcdaf";
        String s2 = "acbcf";
        System.out.print(lcs.findLcs(s1, s2));

    }

    private int findLcs(String s1, String s2) {
        int table[][] = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <=s2.length(); j++) {
                if (i == 0 || j == 0) {
                    table[i][j] = 0;
                }
                else {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        table[i][j] = 1 + table[i - 1][j - 1];
                    }
                    else {
                        table[i][j] = Math.max(table[i][j - 1], table[i - 1][j]);
                    }
                }
            }
        }
        return table[s1.length()][s2.length()];

    }
}
