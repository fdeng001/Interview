package Leetcode_cloneGraph;
import java.util.*;
public class Solution {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {  
        if(node == null){  
            return null;  
        }  
          
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode retClone = new UndirectedGraphNode(node.label);
        HashMap<UndirectedGraphNode, UndirectedGraphNode> ht= new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        ht.put(node, retClone);
        queue.add(node);
        
        while(!queue.isEmpty()){
        	UndirectedGraphNode cur = queue.remove();
        	UndirectedGraphNode curClone = ht.get(cur);
        	ArrayList<UndirectedGraphNode> neighbors = cur.neighbors;
        	for(int i = 0;i<neighbors.size();i++){
        		UndirectedGraphNode neighbor = neighbors.get(i);
        		if(ht.containsKey(neighbor)){
        			UndirectedGraphNode neighborClone = ht.get(neighbor);
        			curClone.neighbors.add(neighborClone);
        		}
        		else{
        			UndirectedGraphNode neighborClone = new UndirectedGraphNode(neighbor.label);
        			curClone.neighbors.add(neighborClone);
        			ht.put(neighbor, neighborClone);
        			queue.add(neighbor);
        			
        		}
        	}
        }
        return retClone; 
    }  
}
