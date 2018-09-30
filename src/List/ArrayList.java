package List;

public class ArrayList {

    public static void main(String args[]) {

        System.out.println(isUnique("aba"));
        System.out.println(isUnique("abc"));
        System.out.println(isPerm("ggod", "doog"));
        System.out.println(isPerm("good", "dogo"));
        System.out.println(replaceSpace("ma nas"));
        System.out.println(compressString("aabbcdd"));
        int a[][] = { { 1, 2, 3, 4, 5, 6 },
                { 7, 8, 9, 10, 11, 12 },
                { 13, 14, 15, 16, 17, 18 } };
        int b[][] = { { 1, 0, 3 }, { 7, 8, 9 }, { 4, 5, 6 } };
        System.out.println("---------------------");
        spiralMatrix(a);
        System.out.println();
        System.out.println("---------------------");
        rotateImage(b);
        System.out.println("---------------------");
        makeRowColumnZero(b);
        spiralMatrixWithN(4);

    }

    // Implement an algo to determine string has unique char
    public static boolean isUnique(String str) {
        int temp[] = new int[256];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (temp[ch] != 0) {
                return false;
            }
            temp[ch]++;
        }

        return true;

    }

    // given two string one perm of other
    public static boolean isPerm(String str1, String str2) {
        int temp[] = new int[256];
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            temp[str1.charAt(i)]++;
        }

        for (int i = 0; i < str2.length(); i++) {
            if (--temp[str2.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

    // replace spaces with %20
    public static String replaceSpace(String str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            String space = str.charAt(i) + "";
            if (space.equals(" ")) {
                sb.append("%");
                sb.append("2");
                sb.append("0");
            }
            else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    // basic compression replace char with count
    public static String compressString(String str) {
        char startChar = str.charAt(0);
        int startCount = 1;
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < str.length(); i++) {
            if (startChar == str.charAt(i)) {
                startCount++;
            }
            else {
                sb.append(startChar);
                sb.append(startCount);
                startCount = 1;
                startChar = str.charAt(i);
            }
        }

        sb.append(startChar);
        sb.append(startCount);
        return sb.toString();
    }

    public static void spiralMatrix(int a[][]) {
        int startRow = 0;
        int endRow = a.length;
        int startColumn = 0;
        int endColumn = a[0].length;
        while (startRow < endRow && startColumn < endColumn) {
            for (int i = startColumn; i < endColumn; i++) {
                System.out.print(a[startRow][i]);
            }
            startRow++;

            for (int i = startRow; i < endRow; i++) {
                System.out.print(a[i][endColumn - 1]);
            }
            endColumn--;

            if (startRow < endRow) {
                for (int i = endColumn - 1; i >= startColumn; --i)
                {
                    System.out.print(a[endRow - 1][i]);
                }
                endRow--;
            }
            if (startColumn < endColumn) {
                for (int i = endRow - 1; i >= startRow; --i)
                {
                    System.out.print(a[i][startColumn]);
                }
                startColumn++;
            }
        }
    }
    
    public static void spiralMatrixWithN(int n) {
        int startRow = 0;
        int endRow = n;
        int startColumn = 0;
        int endColumn = n;
        int a[][] = new int[n][n];
        int num =0;
        while (startRow < endRow && startColumn < endColumn) {
            for (int i = startColumn; i < endColumn; i++) {
                a[startRow][i] = ++num;
            }
            startRow++;

            for (int i = startRow; i < endRow; i++) {
                a[i][endColumn - 1]=++num;;
            }
            endColumn--;

            if (startRow < endRow) {
                for (int i = endColumn - 1; i >= startColumn; --i)
                {
                   a[endRow - 1][i]=++num;
                }
                endRow--;
            }
            if (startColumn < endColumn) {
                for (int i = endRow - 1; i >= startRow; --i)
                {
                    a[i][startColumn]=++num;
                }
                startColumn++;
            }
        }
        printMatrix(a);
    }

    public static void rotateImage(int a[][]) {
        for (int layer = 0; layer < a.length / 2; layer++) {
            int first = layer;
            int last = a.length - 1 - layer;
            for (int i = 0; i < last; i++) {
                int offset = i - first;
                int temp = a[first][i];
                a[first][i] = a[last - offset][first];
                a[last - offset][first] = a[last][last - offset];
                a[last][last - offset] = a[i][last];
                a[i][last] = temp;

            }
            printMatrix(a);
        }

    }
    
    private static int findSum(int num){
        int sum = 0;
        for (int j = 0; j < num; j++){
         if(num % j == 0){
             sum = sum + j;
             }
        }
        return sum;
    }

    public static void makeRowColumnZero(int a[][]) {
        boolean row[] = new boolean[a.length];
        boolean column[] = new boolean[a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        for (int i = 0; i < row.length; i++) {
            if (row[i])
                make(i, "row", a);
        }

        for (int i = 0; i < column.length; i++) {
            if (column[i])
                make(i, "column", a);
        }
        printMatrix(a);
    }

    public static void make(int index, String value, int a[][]) {
        if (value.equals("row")) {
            for (int i = 0; i < a[index].length; i++) {
                a[index][i] = 0;
            }
        }
        if (value.equals("column"))
            for (int i = 0; i < a.length; i++) {
                a[i][index] = 0;
            }
    }

    public static void printMatrix(int a[][]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }
}
