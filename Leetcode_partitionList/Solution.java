package Leetcode_partitionList;
/*
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
*/
public class Solution {
	 public ListNode partition(ListNode head, int x) {
		 ListNode leftNode = new ListNode(0);
		 ListNode rightNode = new ListNode(0);
		 ListNode leftHead = leftNode;
		 ListNode rightHead = rightNode;
		 if(head == null) return null;
		 
		 while(head != null){
			 if(head.val<x){
				 leftNode.next = head;
				 leftNode = leftNode.next;
			 }
			 else{
				 rightNode.next = head;
				 rightNode = rightNode.next;
			 }
			 head = head.next;
			 leftNode.next = rightNode.next = null;
		 }
		 leftNode.next = rightHead.next;
		 return leftHead.next;
	 }
}
