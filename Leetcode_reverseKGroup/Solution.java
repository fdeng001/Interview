package Leetcode_reverseKGroup;

import java.util.ArrayList;

import LL_zigzagLevelOrder.TreeNode;
import Leetcode_partitionList.ListNode;
/**
 * For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
 */
public class Solution {
	public static void main(String[] args){
		ListNode root = new ListNode(1);
		ListNode nodeA = new ListNode(2);
		ListNode nodeB = new ListNode(3);
		ListNode nodeC = new ListNode(4);
		ListNode nodeD = new ListNode(5);
		ListNode nodeE = new ListNode(6);
		ListNode nodeF = new ListNode(7);
		root.next = nodeA;
		nodeA.next = nodeB;
		nodeB.next = nodeC;
		nodeC.next = nodeD;
		nodeD.next = nodeE;
		nodeE.next = nodeF;
		ListNode result = reverseKGroup(root,2);
		print(result);
	}
	public static ListNode reverseKGroup(ListNode head, int k) {
	    if(head == null)
	    {
	        return null;
	    }
	    ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    int count = 0;
	    ListNode pre = dummy;
	    ListNode cur = head;
	    while(cur != null)
	    {

	        print(dummy.next);
	        count ++;
	        ListNode next = cur.next;
	        if(count == k)
	        {
	            pre = reverse(pre, next);
	            count = 0;   
	        }
	        cur = next;
	    }
	    return dummy.next;
	}
	 private static ListNode reverse(ListNode pre, ListNode next){
	        ListNode last = pre.next;//where first will be doomed "last"
	        ListNode cur = last.next;
	        while(cur != next){
	            last.next = cur.next;
	            cur.next = pre.next;
	            pre.next = cur;
	            cur = last.next;
	        }
	        return last;
	    }
	public static void print(ListNode root){
		while(root!=null){
			System.out.print(root.val+" ");
			root = root.next;
		}
		System.out.println(" ");
	}
}
