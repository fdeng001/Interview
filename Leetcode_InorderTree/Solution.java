package Leetcode_InorderTree;

import java.util.ArrayList;
import java.util.Stack;

import Leetcode_binaryTreefromPost.TreeNode;

public class Solution {

	TreeNode first;
	TreeNode second;
	TreeNode pre;

	public void inOrder(TreeNode root){
		if (root==null){return;}
		else{
			inOrder(root.left);
			if (pre == null){pre = root;}
			else {
				if (pre.val > root.val){
					if (first==null) {first = pre;}
					second = root;
				}
				pre = root;
			}
			inOrder(root.right);

		}
	}
	public void recoverTree(TreeNode root) {
		pre = null;
		first = null;
		second= null;
		inOrder(root);
		int val;
		val = first.val;
		first.val=second.val;
		second.val=val;
		return;
	}
	
}
