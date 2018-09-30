package String;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {

    public static void main(String args[]) {
        String s1 = "egg";
        String s2 = "baa";
        IsomorphicString is = new IsomorphicString();
        System.out.print(is.isIsomorphic(s1.toCharArray(), s2.toCharArray()));
    }

    private boolean isIsomorphic(char[] charArray1, char[] charArray2) {

        if (charArray1.length != charArray2.length)
            return false;

        Map<Character, Character> mapping = new HashMap<Character, Character>();

        for (int i = 0; i < charArray1.length; i++) {

            Character c1 = charArray1[i];
            Character c2 = charArray2[i];
            if (mapping.containsKey(c1)) {
                if (!mapping.get(c1).equals(c2)) {
                    return false;
                }
            }
            else {
                if (mapping.containsValue(c2)) {
                    return false;
                }
                mapping.put(c1, c2);
            }

        }
        return true;

    }
}
