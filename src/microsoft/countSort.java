package microsoft;

import java.util.HashMap;
import java.util.Map;

public class countSort {

	private static Map<String, Integer> map = new HashMap<>();

	public static void main(String args[]) {

		map.put("p1", 1);
		map.put("p2", 1);
		map.put("p3", 2);
		map.put("p4", 2);
		map.put("p5", 1);
		map.put("p6", 3);
		map.put("p7", 2);

		String[] products = { "p1", "p2", "p3", "p4", "p5", "p6", "p7" };

		String result[] = orderByPriority(products);
		orderByPriority2(products);

		for (String res : result) {
			System.out.print(res + " ");
		}
		System.out.println();
		for (String res : products) {
			System.out.print(res + " ");
		}

	}

	private static String[] orderByPriority(String[] products) {

		int count[] = new int[4];
		String result[] = new String[products.length];
		for (String p : products) {
			count[getPriority(p)]++;
		}

		for (int i = 2; i < count.length; i++) {
			count[i] = count[i - 1] + count[i];
		}

		for (int i = count.length - 1; i > 0; i--) {
			count[i] = count[i - 1];
		}

		for (String p : products) {
			int prio = getPriority(p);
			int index = count[prio];
			result[index] = p;
			count[prio]++;
		}

		/*
		 * //if not right shifted we group all by ascending order but sequence not
		 * maintain for (String p : products) { int prio = getPriority(p); int index =
		 * count[prio]; result[index-1] = p; count[prio]--; }
		 */
		return result;
	}

	public static void orderByPriority2(String[] array) {
		if (array == null || array.length <= 1)
			return;
		int p1Count = 0;
		int p2Count = 0;
		int p3Count = 0;

		while (p3Count < array.length) {
			// [0, p1) marks the range for prio. 1.
			// [p1, p2) marks the range for prio. 2.
			// [p2, p3) marks the range for prio 3.
			int prio = getPriority(array[p3Count]); // here one would call the function to get the prio
			if (prio == 1) {
				swap(array, p2Count, p3Count);			
				swap(array, p2Count, p1Count);
				p1Count++;
				p2Count++;

			} else if (prio == 2) {
				swap(array, p2Count, p3Count);
				p2Count++;
			}
			p3Count++;
		}
	}

	static private <T> void swap(T[] array, int i, int j) {
		T tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	private static Integer getPriority(String key) {
		return map.get(key);
	}

}
