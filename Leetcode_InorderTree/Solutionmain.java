package Leetcode_InorderTree;

import java.util.ArrayList;

import Leetcode_binaryTreefromPost.TreeNode;

public class Solutionmain {
	public static void main(String[] args){
		TreeNode root = new TreeNode(4);
		TreeNode nodeA = new TreeNode(2);
		TreeNode nodeB = new TreeNode(6);
		TreeNode nodeC = new TreeNode(1);
		TreeNode nodeD = new TreeNode(3);
		TreeNode nodeE = new TreeNode(5);
		TreeNode nodeF = new TreeNode(7);
		root.right = nodeB;
		root.left = nodeA;
		nodeA.right = nodeD;
		nodeA.left = nodeC;
		nodeB.right = nodeF;
		nodeB.left = nodeE;
		ArrayList<Integer> result = new ArrayList<Integer>();
		result = inorderTraversal(root);
		System.out.println(result);
	}
	public static ArrayList<Integer> inorderTraversal(TreeNode root){
		ArrayList<Integer> result = new ArrayList<Integer>();
		TreeNode current = null;
		TreeNode pre = null;
		if(root == null){
			return result;
		}
		current = root;
		while(current!= null){
			if(current.left == null){
				result.add(current.val);
				current = current.right;
			}
			else{
				 /* Find the inorder predecessor of current */
				pre = current.left;
				while(pre.right != null && pre.right != current){
					pre = pre.right;
				}
				
				 /* Make current as right child of its inorder predecessor */
				if(pre.right == null){
					pre.right = current;
					current = current.left;
				}
				 /* Revert the changes made in if part to restore the original
                tree i.e., fix the right child of predecssor */  
				else{
					pre.right = null;
					result.add(current.val);
					current = current.right;
				} /* End of if condition pre->right == NULL */
			} /* End of if condition current->left == NULL*/
		}/* End of while */
		return result;
	}
	public static void recoverTree(TreeNode root){
		ArrayList<Integer> result = new ArrayList<Integer>();
		TreeNode current = null;
		TreeNode pre = null;
		TreeNode f1 = null;
		TreeNode f2 = null;
		TreeNode parent = null;
		if(root == null){
			return;
		}
		boolean found = false;
		current = root;
		while(current!= null){
			if(current.left == null){
				if(parent != null && parent.val > current.val)
                {
                       if(!found)
                       {
                             f1 = parent;
                             found = true;
                       }
                       f2 = current;
                }
                parent = current;
				current = current.right;
			}
			else{
				 /* Find the inorder predecessor of current */
				pre = current.left;
				while(pre.right != null && pre.right != current){
					pre = pre.right;
				}
				
				 /* Make current as right child of its inorder predecessor */
				if(pre.right == null){
					pre.right = current;
					current = current.left;
				}
				 /* Revert the changes made in if part to restore the original
                tree i.e., fix the right child of predecssor */  
				else{
					pre.right = null;
					if(parent.val > current.val)
                    {
                          if(!found)
                          {
                                 f1 = parent;       
                                 found = true;
                          }
                          f2 = current;
                    }
                    parent = current;
					current = current.right;
				} /* End of if condition pre->right == NULL */
			} /* End of if condition current->left == NULL*/
		}/* End of while */
		 if(f1 !=null && f2!= null)
             swap(f1, f2);
	}
	private static void swap(TreeNode f1, TreeNode f2) {
		int tmp = f1.val;
		f1.val = f2.val;
		f2.val = tmp;
	}
}
