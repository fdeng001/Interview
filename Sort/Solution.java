package Sort;

public class Solution {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);
 
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(5);
 
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
 
		n1 = mergeSortList(n1);
 
		printList(n1);
		
		int[] x = { 9, 2, 4, 7, 3, 7, 10 };
		printArray(x);
 
		int low = 0;
		int high = x.length - 1;
 
		quickSort(x, low, high);
		printArray(x);
		
		n1 = insertionSortList(n1);
		 
		printList(n1);
 
	}
 
	public static void printList(ListNode x) {
		if(x != null){
			System.out.print(x.val + " ");
			while (x.next != null) {
				System.out.print(x.next.val + " ");
				x = x.next;
			}
			System.out.println();
		}
 
	}
	
	public static void printArray(int[] x) {
		for (int a : x)
			System.out.print(a + " ");
		System.out.println();
	}
	
	public static ListNode mergeSortList(ListNode head) {
		if(head == null || head.next == null)
			return head;
		int count=0;
		ListNode p = head;
		while(p!=null){
			p = p.next;
			count++;
		}
		int mid = count/2;
		ListNode l = head, r = null;
		ListNode p2 = head;
		int countHalf = 0;
		while(p2!=null){
			countHalf++;
			ListNode tmp = p2.next;
			if(countHalf==mid){
				r = tmp;
				p2.next = null;
				break;
			}
			p2=tmp;
		}
		ListNode leftNode = mergeSortList(l);
		ListNode rightNode = mergeSortList(r);
		ListNode result = mergeSort(leftNode,rightNode);
		return result;
	}

	private static ListNode mergeSort(ListNode leftNode, ListNode rightNode) {
		ListNode p1 = leftNode;
		ListNode p2 = rightNode;
		
		ListNode prev = new ListNode(0);
		ListNode tmp = prev;
		while(p1!=null || p2!=null){
			if(p1 == null){
				tmp.next = new ListNode(p2.val);
				p2 = p2.next;
				tmp = tmp.next;			
			}
			else if(p2 == null){
				tmp.next = new ListNode(p1.val);
				p1 = p1.next;
				tmp = tmp.next;	
			}
			else{
				if(p1.val<p2.val){
					tmp.next = new ListNode(p1.val);
					p1 = p1.next;
					tmp = tmp.next;	
				}
				else if(p1.val == p2.val){
					tmp.next = new ListNode(p1.val);
					tmp.next.next = new ListNode(p2.val);
					tmp = tmp.next.next;	
					p1 = p1.next;
					p2 = p2.next;
				}
				else{
					tmp.next = new ListNode(p2.val);
					p2 = p2.next;
					tmp = tmp.next;
				}
			}
		}
		return prev.next;
		
	}
	
	public static void quickSort(int[] arr, int low, int high){
		if(arr == null || arr.length==0)
			return;
		if(low>high)
			return;
		int mid = low+(high-low)/2;
		int pivot = arr[mid];
		int i = low, j = high;
		while(i<=j){
			while(arr[i]<pivot)
				i++;
			while(arr[j]>pivot)
				j--;
			if(i<=j){
				int tmp = arr[j];
				arr[j] = arr[i];
				arr[i] = tmp;
				i++;
				j--;
			}
		}
		if(low<j)
			quickSort(arr,low,j);
		if(high>i)
			quickSort(arr,i,high);
		
	}
	
	public static ListNode insertionSortList(ListNode head){
		if (head == null || head.next == null)
			return head;
 
		ListNode newHead = new ListNode(head.val);
		ListNode pointer = head.next;
 
		// loop through each element in the list
		while (pointer != null) {
			// insert this element to the new list
 
			ListNode innerPointer = newHead;
			ListNode next = pointer.next;
 
			if (pointer.val <= newHead.val) {
				ListNode oldHead = newHead;
				newHead = pointer;
				newHead.next = oldHead;
			} else {
				while (innerPointer.next != null) {
 
					if (pointer.val > innerPointer.val && pointer.val <= innerPointer.next.val) {
						ListNode oldNext = innerPointer.next;
						innerPointer.next = pointer;
						pointer.next = oldNext;
					}
 
					innerPointer = innerPointer.next;
				}
 
				if (innerPointer.next == null && pointer.val > innerPointer.val) {
					innerPointer.next = pointer;
					pointer.next = null;
				}
			}
 
			// finally
			pointer = next;
		}
 
		return newHead;
	}
}
class ListNode {
	int val;
	ListNode next;
 
	ListNode(int x) {
		val = x;
		next = null;
	}
}