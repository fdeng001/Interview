package Leetcode_binaryTreefromPost;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int x) { val = x; }
	public void setLeft(TreeNode n) {
		this.left = n;		
	}
	public void setRight(TreeNode n) {
		this.right = n;
	}
	public boolean isLeaf() {
		return (this.left == null && this.right == null);
	}
}
