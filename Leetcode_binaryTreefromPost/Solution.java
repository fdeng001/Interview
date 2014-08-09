package Leetcode_binaryTreefromPost;

public class Solution {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		int inStart = 0;
        int inEnd = inorder.length-1;
        int postStart =0;
        int postEnd = postorder.length-1;
 
        return buildInorderPostorder(inorder, postorder, inStart, inEnd, postStart, postEnd);
    }
	public TreeNode buildInorderPostorder(int in[], int post[], 
			int instart,int inend, int poststart,int postend){
		if(instart > inend || poststart > postend){
			return null;
		}
		int rootValue = post[postend];
		TreeNode  root = new TreeNode(rootValue);
		
		int pos = 0;
		for(int i = instart; i <= inend; ++i){
			if(in[i] == rootValue){
				pos = i;
				break;
			}
		}
		root.left = buildInorderPostorder(in,post,instart, pos-1,poststart,poststart+pos-(instart+1));
		root.right = buildInorderPostorder(in,post,pos+1,inend,poststart+pos-instart,postend-1);
		
		return root;
	 
	}
	public TreeNode buildInorderPreorder(int in[], int pre[], 
			int instart,int inend, int prestart,int preend){
		if(instart > inend || prestart > preend){
			return null;
		}
		int rootValue = pre[prestart];
		TreeNode  root = new TreeNode(rootValue);
		
		int pos = 0;
		for(int i = instart; i<=inend; i++){
			if(in[i] == rootValue){
				pos = i;
				break;
			}
		}
		int len = pos-instart; 
		
		root.left = buildInorderPreorder(in,pre,instart, pos-1,prestart+1,prestart+len);
		root.right = buildInorderPreorder(in,pre, pos+1,inend,prestart+len+1,preend);
		
		return root;
	 
	}
	
}
