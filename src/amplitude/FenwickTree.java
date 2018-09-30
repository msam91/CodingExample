package amplitude;

public class FenwickTree {

	public static void main(String args[]) {
		FenwickTree f = new FenwickTree();
		int input[] = { 1, 2, 3, 4, 5, 6, 7 };
		int BIT[] = f.createTree(input);
		System.out.print(f.getSum(BIT, 3));
	}

	private int[] createTree(int[] input) {
		int BIT[] = new int[input.length + 1];

		for (int i = 1; i <= input.length; i++) {
			updateBIT(BIT, input[i - 1], i);
		}
		return BIT;
	}

	private void updateBIT(int[] bIT, int val, int index) {
		// TODO Auto-generated method stub
		while (index < bIT.length) {
			bIT[index]+= val;
			index = getNext(index);
		}

	}

	private int getSum(int bIt[], int index) {
		index = index + 1;
		int sum = 0;

		while (index > 0) {
			sum += bIt[index];
			index = getParent(index);
		}
		return sum;
	}

	private int getNext(int index) {
		index += (index & -index);
		return index;
	}

	private int getParent(int index) {
		index -= (index & -index);
		return index;
	}
}
