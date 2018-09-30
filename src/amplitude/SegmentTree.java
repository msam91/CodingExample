package amplitude;

public class SegmentTree {

	public static void main(String args[]) {

		int a[] = { 3, 0, -1, 5 };
		int sl = 0;

		if (a.length % 2 == 0) {
			sl = a.length * 2 - 1;
		} else {
			int temp = nextPowerOf2(a.length);
			sl = temp * 2 - 1;
		}

		int seg[] = new int[sl];

		SegmentTree t = new SegmentTree();
		t.constructTree(a, seg, 0, a.length - 1, 0);

	}

	private void constructTree(int[] a, int seg[], int low, int high, int pos) {
		if (low == high) {
			seg[pos] = a[low];
			return;
		}
		int mid = (low + high) / 2;
		constructTree(a, seg, low, mid, pos * 2 + 1);
		constructTree(a, seg, mid + 1, high, pos * 2 + 2);

		seg[pos] = Math.min(seg[pos * 2 + 1], seg[pos * 2 + 2]);

	}
	
    private int rangeMinimumQuery(int segmentTree[],int low,int high,int qlow,int qhigh,int pos){
        if(qlow <= low && qhigh >= high){
            return segmentTree[pos];
        }
        if(qlow > high || qhigh < low){
            return Integer.MAX_VALUE;
        }
        int mid = (low+high)/2;
        return Math.min(rangeMinimumQuery(segmentTree, low, mid, qlow, qhigh, 2 * pos + 1),
                rangeMinimumQuery(segmentTree, mid + 1, high, qlow, qhigh, 2 * pos + 2));
    }

	public static int nextPowerOf2(int num) {
		if (num == 0)
			return 1;
		return num << 1;

	}
}
