package Leetcode_sortList;

import Leetcode_partitionList.ListNode;

public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
        	return head;
        ListNode counter = head;
        int len = 0;
        while(counter!=null){
        	len++;
        	counter=counter.next;
        }
        ListNode[] headArray = {head};
        return mergeSort(headArray,len);
    }

	private ListNode mergeSort(ListNode[] headArray, int len) {
		if(len==1){
			ListNode tmp = headArray[0];
			headArray[0] = headArray[0].next;
			tmp.next = null;
			return tmp;
		}

		ListNode left = mergeSort(headArray,len/2);
		ListNode right = mergeSort(headArray,len-len/2);
		return merge(left,right);
	}

	private ListNode merge(ListNode left, ListNode right) {
		if(left == null)
			return right;
		if(right == null)
			return left;
		ListNode preHead = new ListNode(-1);
		ListNode end = preHead;
		while(left!=null&&right!=null){
			if(left.val<right.val){
				end.next = left;
				left = left.next;
			}
			else{
				end.next = right;
				right = right.next;
			}
		}
		if(left!=null)
			end.next=left;
		if(right!=null)
			end.next=right;
		return preHead;
	}
}
