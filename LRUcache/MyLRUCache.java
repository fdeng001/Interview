package LRUcache;

import java.util.*;

public class MyLRUCache implements MyCache
{
    private int cacheSize;
    private Hashtable<Object, Entry> nodes;
    private int currentSize;
    private Entry first;
    private Entry last;
    
    public MyLRUCache(int i){
    	currentSize = 0;
    	cacheSize = 1;
    	nodes = new Hashtable<Object,Entry>(i);
    }
    
    public synchronized void addElement(Object key, Object value){
    	Entry node = nodes.get(key);
    	if(node == null){
    		if(currentSize >= cacheSize){
    			nodes.remove(last.key);
    			removeLast();
    		}else{
    			currentSize++;
    			node = new Entry();
    		}
    	}
    	node.value = value;
    	moveToHead(node);
    	nodes.put(key,node);
    }
    
    public synchronized void moveToHead(Entry node){
    	if(node == first){
    		return;
    	}
    	if(node.prev != null){
    		node.prev.next = node.next;
    	}
    	if(node.next != null){
    		node.next.prev = node.prev;
    	}
    	if(last == node){
    		last = node.prev;
    	}
    	if(first != node){
    		node.next = first;
    		first.prev = node;
    	}
    	first = node;
    	node.prev = null;
    	if(last == null){
    		last = first;
    	}
    }
    public synchronized void removeLast(){
    	if(last != null){
    		if(last.prev != null){
    			last.prev.next = null;
    		}
    		else{
    			first = null;
    		}
    		last = last.prev;
    	}
    }
    public synchronized Entry getElement(Object key){
    	Entry node = nodes.get(key);
    	if(node!=null){
    		moveToHead(node);
    		return node;
    	}
    	else{
    		return null;
    	}
    }
    public boolean isExist(Object key){
    	Entry node = nodes.get(key);
    	if(node != null){
    		return true;
    	}
    	return false;
    }
    public int size(){
    	return currentSize;
    }
    public void clear(){
    	first = null;
    	last = null;
    	currentSize = 0;
    }

	@Override
	public int capacity() {
		// TODO Auto-generated method stub
		return 0;
	}
}