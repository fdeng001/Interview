package Leetcode_mergeKLists;

import java.util.*;

import Leetcode_partitionList.ListNode;

public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {        
    	if(lists.size()<1)
    		return null;
    	PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.size(),
    			new Comparator<ListNode>(){public int compare(ListNode a, ListNode b){return a.val>b.val?1:(a.val==b.val?0:-1);}});
    	
    	for(ListNode list:lists){
    		if(list != null)
    			q.add(list);
    	}
    	ListNode head = new ListNode(0);    	
    	ListNode prev = head;
    	while(q.size()!=0){
    		ListNode temp = q.poll();
    		prev.next =temp;
    		if(temp.next!=null)
    			q.add(temp.next);
    		prev = prev.next;
    	}
    	return head.next;
    }
    
    /**
     * O(n*lgk). space worse:extra O(n)
     * in place merge
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode head = null;
        int len = lists.size();
        if(len == 0)
            return null;
        else if(len == 1){
            return lists.get(0);
        }
        head = merge2List(lists.get(0), lists.get(1));
        for(int i = 2; i < len; i++){
            head = merge2List(lists.get(i), head);
        }
        return head;
        
    }
    
    public ListNode merge2List(ListNode node1, ListNode node2){
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode tmp = head;
        while(node1 != null && node2 != null){
            if(node1.val <= node2.val){
                ListNode node = new ListNode(node1.val);
                tmp.next = node;
                tmp = tmp.next;
                node1 = node1.next;
            } else {
                ListNode node = new ListNode(node2.val);
                tmp.next = node;
                tmp = tmp.next;
                node2 = node2.next;
            }
        }
        
        if(node1 != null){
            tmp.next = node1;
        }
        
        if(node2 != null){
            tmp.next = node2;
        }
        head = head.next;
        return head;
        
    }
}
