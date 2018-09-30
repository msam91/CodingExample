package List;

public class RotateArray {

    public static void main(String args[]) {
        String s = "1234568";
        RotateArray ra = new RotateArray();
        ra.rotateArray(s.toCharArray(), 3);

    }

    public void rotateArray(char[] s, int order) {

        if (order > s.length) {
            order = order % s.length;
        }
        
        int start = s.length-order;

        
        reverse(s, 0, start - 1);
        
        System.out.println("After first rotation");
        for (int j = 0; j < s.length; j++) {
            System.out.print(s[j]);
        }
        System.out.println();
        
        System.out.println("After second rotation");
        reverse(s, start, s.length - 1);
        for (int j = 0; j < s.length; j++) {
            System.out.print(s[j]);
        }
        System.out.println();
        System.out.println("After final rotation");
        reverse(s, 0, s.length - 1);
        for (int j = 0; j < s.length; j++) {
            System.out.print(s[j]);
        }
    }

    public void reverse(char[] s, int i, int j) {
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
