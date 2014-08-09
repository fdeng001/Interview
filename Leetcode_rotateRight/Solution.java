package Leetcode_rotateRight;

import Leetcode_partitionList.ListNode;

public class Solution {
	public static void main(String[] args){
		ListNode root = new ListNode(1);
		ListNode nodeA = new ListNode(2);
	/*	ListNode nodeB = new ListNode(3);
		ListNode nodeC = new ListNode(4);
		ListNode nodeD = new ListNode(5);
		ListNode nodeE = new ListNode(6);
		ListNode nodeF = new ListNode(7);*/
		root.next = nodeA;
	/*	nodeA.next = nodeB;
		nodeB.next = nodeC;
		nodeC.next = nodeD;
		nodeD.next = nodeE;
		nodeE.next = nodeF;*/
		ListNode result = rotateRight(root,3);
		print(result);
	}
	public static ListNode rotateRight(ListNode head, int n) {
		 // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null) return null;
        ListNode n1 = head,n2=head;
        while(n>0){
            n2=n2.next;
            n--;
            if(n2==null){
                n2=head;
            }
        }
        
        if(n1==n2) return n1;
        
        while(n2.next!=null){
            n1=n1.next;
            n2=n2.next;
        }
        
        ListNode temp = n1.next;
        n2.next=head;
        n1.next=null;
        return temp;
	}
	public static void print(ListNode root){
		while(root!=null){
			System.out.print(root.val+" ");
			root = root.next;
		}
		System.out.println(" ");
	}
}
