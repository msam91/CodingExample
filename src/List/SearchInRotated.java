package List;

public class SearchInRotated {

    public static void main(String args[]) {

        int a[] = { 1, 2, 3, 4, 5, 6, 7 };

        /*
         * 1,2,3,4,5,6, ---4,5,6,1,2,3 ----1,1,1,1,2,3,
         */

        System.out.println(search(a, 0, a.length - 1, 34));
    }

    private static int search(int[] a, int l, int h, int target) {
        int mid = (l + h) / 2;

        if (a[mid] == target) {
            return mid;
        }
        if (h < l) {
            return -1;
        }

        if (a[l] < a[mid]) {
            if (target >= a[l] && target <= a[mid]) {
                return search(a, l, mid - 1, target);
            }
            else {
                return search(a, mid + 1, h, target);
            }
        }
        else if (a[l] > a[mid]) {
            if (target >= a[mid] && target <= a[h]) {
                return search(a, mid + 1, h, target);
            }
            else {
                return search(a, l, mid - 1, target);
            }
        }
        else if (a[l] == a[mid]) {

            if (a[mid] != a[h]) {
                return search(a, mid + 1, h, target);
            }
            else {
                int result = search(a, l, mid - 1, target);

                if (result == -1) {
                    return search(a, mid + 1, h, target);
                }
                else {
                    return result;
                }
            }

        }
        return -1;
    }
}
