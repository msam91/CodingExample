package goldManSachs;

public class MissingCharPanagram {

    public static final int MAX_CHAR = 26;

    public static void main(String args[]) {

        System.out.print(getMissingChar("The quick brown fox jumps"));
    }

    private static String getMissingChar(String s1) {
        boolean[] charTrack = new boolean[MAX_CHAR];

        char a[] = s1.toCharArray();

        for (int i = 0; i < a.length; i++) {
            if (a[i] <= 'z' && a[i] >= 'a') {
                charTrack[a[i] - 'a'] = true;
            }
            else if (a[i] <= 'Z' && a[i] >= 'A') {
                charTrack[a[i] - 'A'] = true;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < charTrack.length; i++) {
            if (!charTrack[i]) {
                sb.append(Character.toChars(i + 'a'));
            }
        }

        return sb.toString();

    }
}
