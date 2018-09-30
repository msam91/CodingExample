package microsoft;

public class AddNumberLinkedList {

	public static void main(String args[]) {

		Node n1 = new Node(5);
		Node n2 = new Node(4);
		Node n3 = new Node(7);

		n1.next = n2;
		n2.next = n3;

		Node number1 = n1;

		Node n11 = new Node(6);
		Node n12 = new Node(8);
		Node n13 = new Node(4);

		n11.next = n12;
		n12.next = n13;

		Node number2 = n11;

		number1 = reverse(number1);
		number2 = reverse(number2);
		Node result = reverse(add(number1, number2, 0));

		while (result != null) {
			System.out.print(result.data);
			result = result.next;
		}

	}

	private static Node reverse(Node head) {
		Node prev = null;
		Node current = head;
		while (current.next != null) {
			head = current.next;
			current.next = prev;
			prev = current;
			current = head;
		}
		current.next = prev;

		return head;
	}

	private static Node add(Node n1, Node n2, int carry) {

		if (n1 == null & n2 == null && carry == 0) {
			return null;
		}
		int value = 0;
		value += carry;
		if (n1 != null) {
			value += n1.data;
		}
		if (n2 != null) {
			value += n2.data;
		}
		int result = value % 10;
		int newCarry = value / 10;

		Node newResult = new Node(result);
		newResult.next = add(n1 != null ? n1.next : null, n2 != null ? n2.next : null, newCarry);

		return newResult;

	}
}

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
	}
}
