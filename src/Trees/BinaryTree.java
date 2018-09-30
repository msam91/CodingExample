package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class tNode {
	int data;
	tNode left, right;

	tNode(int item) {
		data = item;
		left = right = null;
	}

	@Override
	public String toString() {
		return "tNode [data=" + data + "]";
	}

}

class BinaryTree {
	private static int preIndex = 0;

	public static void main(String args[]) {
		/*
		 * 
		 */
		tNode root = new tNode(1);
		root.left = new tNode(2);
		root.right = new tNode(3);
		root.left.left = new tNode(4);
		root.left.right = new tNode(5);

		preOrder(root);
		System.out.println();
		inOrder(root);
		System.out.println();
		postOrder(root);
		System.out.println();
		bfs(root);
		System.out.println();
		dfs(root);
		System.out.println();
		System.out.println(size(root));
		System.out.println(maxDepth(root));
		System.out.println(hasPathSum(root, 8));
		int paths[] = new int[100];
		printPaths(root, paths, 1);
		mirror(root);
		printPaths(root, paths, 1);
		System.out.println(lca(root, 5, 4).data);
		int inOrder[] = { 4, 2, 5, 1, 3 };
		int preOrder[] = { 1, 2, 4, 5, 3 };
		tNode n = formTree(inOrder, preOrder, 0, inOrder.length - 1);
		printPaths(n, paths, 1);

		List<LinkedList<tNode>> lists = new ArrayList<LinkedList<tNode>>();
		createLevelLinkedList(root, lists, 0);
		for (int i = 0; i < lists.size(); i++) {
			for (tNode t : lists.get(i)) {
				System.out.print(t.data + "->");
			}
			System.out.println();
		}

		tNode root1 = new tNode(4);
		root.left = new tNode(2);
		root.right = new tNode(3);
		root.left.right = new tNode(5);
		System.out.print(isBST(root1, Integer.MIN_VALUE, Integer.MAX_VALUE));

	}

	private static void createLevelLinkedList(tNode node, List<LinkedList<tNode>> lists, int level) {
		if (node == null) {
			return;
		}
		LinkedList<tNode> nodeList = null;
		if (lists.size() == level) {
			nodeList = new LinkedList<tNode>();
			lists.add(nodeList);
		} else {
			nodeList = lists.get(level);
		}
		nodeList.add(node);
		createLevelLinkedList(node.left, lists, level + 1);
		createLevelLinkedList(node.right, lists, level + 1);

	}

	public static void preOrder(tNode root) {
		if (root == null)
			return;
		System.out.print(root.data + "->");
		preOrder(root.left);
		preOrder(root.right);
	}

	public static void inOrder(tNode root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data + "->");
		inOrder(root.right);

	}

	public static void postOrder(tNode root) {
		if (root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + "->");
	}

	public static void bfs(tNode root) {
		if (root == null) {
			System.out.print("empty tree");
			return;
		}
		LinkedList<tNode> queue = new LinkedList<tNode>();
		queue.add(root);

		while (!queue.isEmpty()) {
			tNode n = queue.pop();
			System.out.print(n.data + "->");
			if (n.left != null) {
				queue.add(n.left);
			}
			if (n.right != null) {
				queue.add(n.right);
			}
		}
	}

	public static void dfs(tNode root) {
		if (root == null) {
			System.out.print("empty tree");
			return;
		}
		Stack<tNode> stack = new Stack<tNode>();
		stack.push(root);

		while (!stack.isEmpty()) {
			tNode n = stack.pop();
			System.out.print(n.data + "->");
			if (n.right != null) {
				stack.push(n.right);
			}
			if (n.left != null) {
				stack.push(n.left);
			}
		}
	}

	public static int size(tNode root) {
		if (root == null)
			return 0;

		return 1 + size(root.left) + size(root.right);
	}

	public static int maxDepth(tNode root) {
		if (root == null)
			return 0;

		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	public static boolean hasPathSum(tNode root, int sum) {
		if (root == null) {
			return (sum == 0);
		} else {
			return hasPathSum(root.left, sum - root.data) || hasPathSum(root.right, sum - root.data);
		}
	}

	public static void printPaths(tNode root, int paths[], int level) {
		if (root == null)
			return;

		paths[level] = root.data;
		level++;
		if (root.left == null && root.right == null) {
			for (int i = 1; i < level; i++) {
				System.out.print(paths[i] + "->");
			}
			System.out.println();
		} else {
			printPaths(root.left, paths, level);
			printPaths(root.right, paths, level);
		}
	}

	public static void mirror(tNode root) {

		if (root.left == null && root.right == null)
			return;

		mirror(root.left);
		mirror(root.right);

		tNode temp = root.left;
		root.left = root.right;
		root.right = temp;
	}

	public static tNode lca(tNode root, int n1, int n2) {

		if (root == null)
			return null;

		if (root.data == n1 || root.data == n2)
			return root;

		tNode leftNode = lca(root.left, n1, n2);
		tNode rightNode = lca(root.right, n1, n2);

		if (leftNode == null && rightNode == null)
			return null;

		if (leftNode != null && rightNode != null)
			return root;

		return leftNode != null ? leftNode : rightNode;

	}

	public String addStrings(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--) {
			int n1 = i < 0 ? 0 : num1.charAt(i) - '0';
			int n2 = j < 0 ? 0 : num2.charAt(j) - '0';
			sb.append((n1 + n2 + carry) % 10);
			carry = ((n1 + n2 + carry) / 10);
		}

		return sb.reverse().toString();

	}

	private static tNode formTree(int in[], int pre[], int inStart, int inEnd) {

		if (inStart > inEnd)
			return null;

		tNode t = new tNode(pre[preIndex]);
		preIndex++;

		if (inStart == inEnd)
			return t;

		int inIndex = search(in, t.data);
		t.left = formTree(in, pre, inStart, inIndex - 1);
		t.right = formTree(in, pre, inIndex + 1, inEnd);
		return t;

	}

	private static int search(int in[], int data) {
		int inIndex = 0;
		for (int i = 0; i < in.length; i++) {
			if (in[i] == data) {
				inIndex = i;
				break;
			}
		}

		return inIndex;
	}

	private static int diameter(tNode root) {

		if (root == null)
			return 0;

		int lheight = maxDepth(root.left);
		int rheight = maxDepth(root.right);

		return Math.max(1 + lheight + rheight, Math.max(diameter(root.left), diameter(root.right)));
	}

	private static boolean isBST(tNode root, int min, int max) {

		if (root == null) {
			return true;
		}
		if (root.data <= min || root.data > max) {
			return false;
		}
		return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);

	}

	private int isBalanced(tNode root) {

		if (root == null) {
			return 0;
		}

		int lTree = isBalanced(root.left);

		if (lTree == -1) {
			return -1;
		}

		int rTree = isBalanced(root.right);

		if (rTree == -1) {
			return -1;
		}

		if (Math.abs(rTree - lTree) > 1) {
			return -1;
		}

		return 1 + Math.max(lTree, rTree);

	}

	int max = Integer.MIN_VALUE;

	public int getMaxPathSum(tNode root) {
		getMaxPathSum(root);
		return max;
	}

	public int getMaxPathSumHelper(tNode n) {

		if (n == null) {
			return 0;
		}

		int leftTreeSum = getMaxPathSum(n.left);
		int rightTreeSum = getMaxPathSum(n.right);

		int currentMax = Math.max(n.data, Math.max(n.data + leftTreeSum, n.data + rightTreeSum));

		// setting global varible
		max = Math.max(max, Math.max(currentMax, n.data + leftTreeSum + rightTreeSum));

		return currentMax;

	}

	int counter = 0;

}
