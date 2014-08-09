package Leetcode_LRUcache;

import java.util.HashMap;

public class LRUCache {
	HashMap<Integer, Node> map;  
    Node head, tail;  
    int size;  
    public LRUCache(int capacity) {
        map = new HashMap<Integer, Node>(capacity);
        size = capacity;
        head = new Node(-1,-1);
        tail = new Node(1,1);
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
        	Node p = map.get(key);
        	puttoHead(p);
        	return p.val;
        }
        else
        	return -1;
    }
    public void puttoHead(Node node){
    	if(node.next!=null && node.pre!= null){
    		node.pre.next = node.next;
    		node.next.pre = node.pre;
    	}
    	head.next.pre =node;
    	node.next = head.next;
    	head.next=node;
    	node.pre =head;   	
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
        	Node node = map.get(key);
        	node.val = value;
        	puttoHead(node);
        }
        else if(map.size()<size){
        	Node node = new Node(key,value);
        	puttoHead(node);
        	map.put(key, node);
        }
        else{
        	Node node = new Node(key,value);
        	puttoHead(node);
        	map.put(key, node);
        	int end = removeEnd();
        	map.remove(end);
        }
    }

	private int removeEnd() {
		Node node = tail.pre;
		tail.pre.pre.next = tail;
		tail.pre = node.pre;
		node.pre = null;
		node.next = null;
		return node.key;
		
	}
    
}
class Node{
	Node pre;
	Node next;
	int key;
	int val;
	Node(int key,int val){
		this.key=key;
		this.val=val;
	}
}
