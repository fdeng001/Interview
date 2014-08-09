package Leetcode_maxPathSum;

import Leetcode_binaryTreefromPost.TreeNode;

public class Solution {
    public int maxPathSum(TreeNode root) {
    	int[] max = {Integer.MIN_VALUE}; 
        rec(root,max);
        return max[0];
    }
    public int rec(TreeNode root,int[] max){
    	if(root == null){
        	return 0;
        }
		
        int leftSubtreeMaxSum = rec(root.left, max);		// ������������
        int rightSubtreeMaxSum = rec(root.right, max);		// ������������
        int arch = leftSubtreeMaxSum + root.val + rightSubtreeMaxSum;		// ������������root��������������
        
        // ��ʾͨ��root�ڵ����ߵ�root��parent�����ͣ����ֵ��Ϊ���ض��󷵸����ø�����
        // ֻ��3�����: 1 ����������root�ٵ�parent
        // 2 ����������root�ٵ�parent
        // 3 ֱ�Ӵ�root��parent
        // ע��arch����·�ǲ������ߵ�parent����Ϊ����·�Ѿ�����root�ˣ������ۻ����ظ��ߣ������ǲ������
        int maxPathAcrossRootToParent = Math.max(root.val, Math.max(leftSubtreeMaxSum, rightSubtreeMaxSum)+root.val);
        
        // max[0] ���������еݹ�����е����ֵ����ʱҲҪ����arch�������
        max[0] = Math.max(max[0], Math.max(arch, maxPathAcrossRootToParent));
        
        return maxPathAcrossRootToParent;
    	
    }
}
