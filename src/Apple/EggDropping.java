package Apple;

public class EggDropping {

    public static void main(String args[]) {
        int eggs = 2;
        int floors = 6;

        EggDropping eg = new EggDropping();
        System.out.println(eg.drop(eggs, floors));
        System.out.print(eg.dropRecursive(eggs, floors));
    }

    private int dropRecursive(int eggs, int floors) {
        // TODO Auto-generated method stub
        if (eggs == 1)
            return floors;

        if (floors == 0)
            return 0;

        int min = 1000;
        for (int i = 1; i <= floors; i++) {
            int val = 1 + Math.max(dropRecursive(eggs - 1, i - 1), dropRecursive(eggs, floors - i));
            if (val < min) {
                min = val;
            }
        }
        return min;
    }

    private int drop(int eggs, int floors) {

        int table[][] = new int[eggs + 1][floors + 1];
        int c = 0;

        for (int i = 1; i <= floors; i++) {
            table[1][i] = i;
        }
        for (int e = 2; e <= eggs; e++) {

            for (int f = 1; f <= floors; f++) {
                table[e][f] = Integer.MAX_VALUE;
                for (int k = 1; k <= f; k++) {
                    c = 1 + Math.max(table[e - 1][k - 1], table[e][f - k]);
                    if (c < table[e][f]) {
                        table[e][f] = c;
                    }
                }
            }
        }
        return table[eggs][floors];

    }
}
