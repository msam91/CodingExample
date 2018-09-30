package LinkList;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LinkedList {

	public static void main(String args[]) {

		Node head = null;
		head = add(head, 5);
		head = add(head, 6);
		head = add(head, 7);
		print(head);
		head = remove(head, 5);
		System.out.println();
		System.out.println("------------");
		print(head);
		head = add(head, 5);
		System.out.println();
		System.out.println("------------");
		print(head);
		head = remove(head, 7);
		System.out.println();
		System.out.println("------------");
		print(head);
		head = add(head, 7);
		System.out.println();
		System.out.println("------------");
		print(head);
		head = remove(head, 7);
		System.out.println();
		System.out.println("------------");
		print(head);
		head = add(head, 5);
		System.out.println();
		System.out.println("------------");
		print(head);
		deleteDups(head);
		System.out.println();
		System.out.println("------------");
		print(head);
		head = add(head, 5);
		System.out.println();
		System.out.println("------------");
		print(head);
		deleteDupesWithouBuff(head);
		System.out.println();
		System.out.println("------------");
		print(head);
		head = add(head, 11);
		System.out.println();
		System.out.println("------------");
		print(head);

		head = reverseLinklist(head);
		System.out.println();
		System.out.println("------------");
		print(head);

		System.out.println();
		System.out.println("------------");
		System.out.print(kthLastElem(head, 3).data);

	}

	public static Node add(Node head, int data) {
		if (head == null) {
			Node node = new Node(data);
			head = node;
		} else {
			Node n = head;
			while (n.next != null) {
				n = n.next;
			}
			Node node = new Node(data);
			n.next = node;
		}
		return head;
	}

	public static Node remove(Node head, int data) {
		Node n = head;
		if (n.data == data) {
			head = n.next;
		} else {
			while (n.next != null) {
				Node temp = n;
				n = n.next;
				if (n.data == data) {
					temp.next = n.next;
				}
			}
		}
		return head;
	}

	public static void print(Node head) {
		Node n = head;
		while (n.next != null) {
			System.out.print(n.data + "->");
			n = n.next;
		}
		;
		System.out.print(n.data);
	}

	// delete dupes with buffer
	private static Node deleteDups(Node head) {
		// TODO Auto-generated method stub
		Set<Integer> temp = new HashSet<Integer>();
		Node n = head;
		Node prev = head;
		while (n != null) {
			if (!temp.contains(n.data)) {
				temp.add(n.data);
				prev = n;
			} else {
				prev.next = n.next;
			}
			n = n.next;
		}
		return head;
	}

	// delete dupes without buffer
	private static Node deleteDupesWithouBuff(Node head) {
		Node current = head;
		while (current != null) {
			Node next = current.next;
			Node prev = current;
			while (next != null) {
				if (current.data != next.data) {
					prev = next;
				} else {
					prev.next = next.next;
				}
				next = next.next;
			}
			current = current.next;
		}
		return head;
	}

	// reverse linklist
	private static Node reverseLinklist(Node head) {
		Node current = head;
		Node prev = null;
		while (current.next != null) {
			head = current.next;
			current.next = prev;
			prev = current;
			current = head;
		}
		current.next = prev;
		return head;
	}

	// find kth last element in linkliste
	private static Node kthLastElem(Node head, int k) {
		Node p1 = head;
		Node p2 = head;
		for (int i = 0; i < k - 1; i++) {
			if (p1 == null)
				return null;
			p1 = p1.next;
		}
		if (p1 == null)
			return null;
		while (p1.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}

	// find kth last element in linkliste
	private static Node partitionAlongNumber(Node head, int number) {
		Node n = head;
		Node bs = null;
		Node as = null;
		Node be = null;
		Node ae = null;

		while (n != null) {
			Node newNode = new Node(n.data);
			if (n.data < number) {
				if (bs == null) {
					bs = newNode;
					be = bs;
				} else {
					be.next = newNode;
					be = newNode;
				}
			} else {
				if (as == null) {
					as = newNode;
					ae = as;
				} else {
					ae.next = newNode;
					ae = newNode;
				}

			}
			n = n.next;
		}
		if (bs == null) {
			return as;
		}

		be.next = as;
		return bs;

	}

	// add two numbers represented by linklist
	private static Node addList(Node n1, Node n2, int carry) {

		if (n1 == null && n2 == null && carry == 0) {
			return null;
		}
		int value = carry;

		if (n1 != null) {
			value += n1.data;
		}
		if (n2 != null) {
			value += n2.data;
		}

		Node result = new Node(value % 10);

		if (n1 != null || n2 != null)
			result.next = addList(n1 == null ? null : n1.next, n2 == null ? null : n2.next, value >= 10 ? 1 : 0);

		return result;

	}

	private static Node findLoop(Node head) {
		Node slow = head;
		Node fast = head;
		while (fast != null || fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				break;
			}
		}
		if (fast == null || fast.next == null) {
			return null;
		}
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;

		}
		return fast;
	}

	private static boolean isPallindrome(Node head) {
		Node slow = head;
		Node fast = head;
		Stack<Integer> s = new Stack<Integer>();
		while (fast != null && fast.next != null) {
			s.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast != null) {
			slow = slow.next;
		}
		while (slow != null) {
			if (slow.data != (s.pop().intValue())) {
				return false;
			}
		}
		return true;
	}

}
