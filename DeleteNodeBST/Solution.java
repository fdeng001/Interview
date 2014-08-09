package DeleteNodeBST;

import Leetcode_binaryTreefromPost.TreeNode;

public class Solution {
	 private TreeNode root = null;
	/**
     * attempts to delete a node from the tree
     * 
     * @param n node to delete
     * @return true if node is deleted, otherwise false
     */
    public boolean delete(TreeNode n)
    {
        //null guard
        if (n == null)
        {
            return false;
        }

        return delete( n.val );
    }

    /**
     * attempts to delete a node from the tree containing the value
     * 
     * @param val value of node to delete
     * @return true if node is deleted, otherwise false
     */
    public boolean delete(int val)
    {
        //the node to be deleted
    	TreeNode target = null;
        //to keep track of parent node
    	TreeNode parent = null;
        //variable node reference
    	TreeNode node = root;

        while (node != null)
        {
            if (val==node.val)  //eureka!
            {
                target = node;
                break;
            }
            else if (val>node.val)  //target greater, so go right
            {
                parent = node;
                node = node.right;
            }
            else    //target less, so go left
            {
                parent = node;
                node = node.left;
            }
        }

        if (target == null)
        {
            //target not found
            return false;
        }

        boolean isLeft = (target == parent.left);

        if (target == root) //the node that's baleeting is in fact the root node
        {
            //get last house on the left on the right!
            //it becomes the new root
            node = getLastHouseOnTheLeft( parent.right);
            if (node != null)
            {
                node.setLeft( parent.left);
                node.setRight( parent.right);
                root = node;
            }
        }
        else if ( target.isLeaf() )
        {
            if (isLeft)
            {
                parent.setLeft(null);
            }
            else
            {
                parent.setRight(null);
            }
        }
        else if (target.left != null && target.right != null) //two children, some shuffling
        {
            if (isLeft)
            {
                parent.setLeft( target.right );
                parent.left.setLeft( target.left );
            }
            else
            {
                parent.setRight( target.right );
                parent.right.setLeft( target.left );
            }
        }
        else    //one child is simpler
        {
            if (target.left == null)
            {
                if (isLeft)
                {
                    parent.setLeft( target.left );
                }
                else
                {
                    parent.setRight( target.left );
                }
            }
            else
            {
                if (isLeft)
                {
                    parent.setLeft( target.right );
                }
                else
                {
                    parent.setRight( target.right );
                }
            }
        }

        return true;    //baleeted
    }

	private TreeNode getLastHouseOnTheLeft(TreeNode n) {
		TreeNode candidate  = null;
		TreeNode parent = null;
		TreeNode node = n;
		while(node!=null){
			if(node.left!=null){
				candidate = node.left;
				parent = node;
			}
			node = node.left;
		}
		if(parent!=null)
			parent.setLeft(null);
		return candidate;
	}

}
