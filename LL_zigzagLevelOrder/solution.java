package LL_zigzagLevelOrder;

import java.util.*;

public class solution {
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		TreeNode nodeA = new TreeNode(2);
		TreeNode nodeB = new TreeNode(3);
		TreeNode nodeC = new TreeNode(4);
		TreeNode nodeD = new TreeNode(5);
		TreeNode nodeE = new TreeNode(6);
		TreeNode nodeF = new TreeNode(7);
		/*root.right = nodeB;
		root.left = nodeA;
		nodeA.right = nodeD;
		nodeA.left = nodeC;
		nodeB.right = nodeF;
		nodeB.left = nodeE;*/
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		result = zigzagLevelOrder(root);
		System.out.println(result);
	}
    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return result;

    	Stack<TreeNode> treeStack = new Stack<TreeNode>();
    	boolean backward = false;
    	treeStack.push(root);
    	
    	while(!treeStack.isEmpty()){
    		Stack<TreeNode> treenextStack = new Stack<TreeNode>();
    		ArrayList<Integer> tmp = new ArrayList<Integer>();
    		while(!treeStack.isEmpty()){
    			TreeNode currentNode = treeStack.pop();
    			tmp.add(currentNode.val);
    			if(!backward){
    				if(currentNode.left!=null){
    					treenextStack.push(currentNode.left);
    				}
    				if(currentNode.right!=null){
    					treenextStack.push(currentNode.right);
    				}
    			}
    			else{
    				if(currentNode.right!=null){
    					treenextStack.push(currentNode.right);
    				}
    				if(currentNode.left!=null){
    					treenextStack.push(currentNode.left);
    				}
    			}
    		}
    		result.add(tmp);
    		treeStack = treenextStack;
    		backward = !backward;
    	}
    	return result;
    }
}
