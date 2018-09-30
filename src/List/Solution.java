package List;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {

	public static void main(String args[]) {

		ListNode n1 = new ListNode();
		ListNode n2 = new ListNode();
		ListNode n3 = new ListNode();
		n1.val = 3;
		n2.val = 5;
		n3.val = 6;

		n1.next = n2;
		n2.next = n3;

		ListNode n4 = new ListNode();
		ListNode n5 = new ListNode();
		n4.val = 4;
		n5.val = 8;

		n4.next = n5;

		ListNode[] lists = { n1, n4 };

		Solution s = new Solution();
		s.mergeKLists(lists);

	}

	public ListNode mergeKLists(ListNode[] lists) {

		return partition(lists, 0, lists.length - 1);

	}

	public ListNode partition(ListNode[] lists, int s, int e) {

		if (s == e)
			return lists[s];

		if (s < e) {
			int mid = (s + e) / 2;
			ListNode list1 = partition(lists, s, mid);
			ListNode list2 = partition(lists, mid + 1, e);
			return merge(list1, list2);
		} else {
			return null;
		}

	}

	public ListNode merge(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		if (l1.val < l2.val) {
			l1.next = merge(l1.next, l2);
			return l1;
		} else {
			l2.next = merge(l1, l2.next);
			return l2;
		}

	}

	static class ListNode {
		ListNode next;
		int val;
	}
}
