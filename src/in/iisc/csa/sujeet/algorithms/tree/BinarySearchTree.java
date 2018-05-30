package in.iisc.csa.sujeet.algorithms.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
	Node root;

	static class Node {
		int value;
		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
			left = right = null;
		}

	}

	public BinarySearchTree() {
		root = null;
	}

	Node insertUtil(Node root, int value) {
		if (root == null)
			return new Node(value);
		if (value <= root.value)
			root.left = insertUtil(root.left, value);
		else
			root.right = insertUtil(root.right, value);
		return root;
	}

	void insert(int value) {
		root = insertUtil(root, value);
	}

	/*
	 * public void insert(int value) { if (root == null) root = new Node(value);
	 * else { Node tmp = root; while (true) { while (tmp.left != null && value <
	 * tmp.value) tmp = tmp.left;
	 * 
	 * if (value < tmp.value && tmp.left == null) { tmp.left = new Node(value);
	 * return; }
	 * 
	 * while (tmp.right != null && value > tmp.value) tmp = tmp.right;
	 * 
	 * if (tmp.value > value) { tmp.right = new Node(value); return; } } }
	 * 
	 * }
	 */
	void inorderUtil(Node root) {
		if (root == null)
			return;
		inorderUtil(root.left);
		System.out.println(root.value);
		inorderUtil(root.right);
	}

	public Node lca(Node root, int value1, int value2) {
		if (root == null)
			return null;

		if (root.value == value1 || root.value == value2)
			return root;

		Node leftLCA = lca(root.left, value1, value2);
		Node rightLCA = lca(root.right, value1, value2);

		if (leftLCA != null && rightLCA != null)
			return root;
		else if (leftLCA != null)
			return leftLCA;
		else
			return rightLCA;
	}

	public int distanceBetweenTwoNodes(Node root, int value1, int value2, int d) {
		if (root == null)
			return -1;

		if ( d!=0 && (root.value == value1||root.value == value2))
			return d;

		int left = distanceBetweenTwoNodes(root.left, value1, value2, d + 1);
		int right = distanceBetweenTwoNodes(root.right, value1, value2, d + 1);

		if (left != -1 && right != -1) {
			return left + right - 2 * d;
		} else if (left != -1)
			return left;
		else
			return right;
	}

	public void inorder() {
		inorderUtil(root);
	}

	public void levelOrder() {

		if (root == null)
			return;
		Queue<Node> queue = new LinkedList<Node>();
		Queue<Node> queueNextLevel = new LinkedList<Node>();
		queueNextLevel.add(root);

		while (!queueNextLevel.isEmpty()) {

			while (!queueNextLevel.isEmpty()) {
				queue.add(queueNextLevel.poll());
			}

			while (!queue.isEmpty()) {
				Node tmp = queue.poll();
				if (tmp.left != null)
					queueNextLevel.add(tmp.left);
				if (tmp.right != null)
					queueNextLevel.add(tmp.right);
				System.out.print(tmp.value + " ");
			}
			System.out.println("\n");

		}

	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(50);
		tree.insert(56);
		tree.insert(40);
		tree.insert(96);
		tree.insert(70);
		tree.insert(36);
		tree.insert(60);
		tree.insert(87);
		// tree.inorder();
		tree.levelOrder();
		Node lca = tree.lca(tree.root, 50, 36);
		System.out.println("LCA: " + lca.value);
		System.out.println("Distance between 90 and 70: " + tree.distanceBetweenTwoNodes(tree.root, 96, 70, 0));
	}

}
