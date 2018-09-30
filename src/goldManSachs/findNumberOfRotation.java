package goldManSachs;

public class findNumberOfRotation {
    public static void main(String[] args)
    {
        int arr[] = { 15, 18, 2, 3, 6, 12 };
        int n = arr.length;

        System.out.println(countRotations(arr, n));
        System.out.println(countRotationBinarySearch(arr, 0, arr.length-1));
    }

    static int countRotations(int arr[], int n)
    {
        // We basically find index of minimum
        // element
        int min = arr[0], min_index = -1;
        for (int i = 0; i < n; i++)
        {
            if (min > arr[i])
            {
                min = arr[i];
                min_index = i;
            }
        }
        return min_index;
    }

    static int countRotationBinarySearch(int a[], int low, int high) {
        if (high < low) {
            return -1;
        }

        if (high == low) {
            return low;
        }
        int mid = (high + low) / 2;

        if (mid < high && a[mid + 1] < a[mid]) {
            return mid + 1;
        }
        if (mid > low && a[mid] < a[mid - 1]) {
            return mid;
        }
        if (a[high] > a[mid]) {
            return countRotationBinarySearch(a, low, mid - 1);
        }
        return countRotationBinarySearch(a, mid + 1, high);

    }
}
