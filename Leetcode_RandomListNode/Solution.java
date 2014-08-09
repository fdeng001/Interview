package Leetcode_RandomListNode;

public class Solution {
	public static void main(String[] args) {
		RandomListNode head = new RandomListNode(1);
		RandomListNode n2 = new RandomListNode(2);
		RandomListNode n3 = new RandomListNode(3);
		RandomListNode n4 = new RandomListNode(4);
		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		head.random = n3;
		n2.random = n4;
		RandomListNode ret = copyRandomList(head);
		while(ret != null){
			System.out.println(ret.label);
			ret = ret.next;
		}
	}

	public static RandomListNode copyRandomList(RandomListNode head) {
		if(head == null){
			return null;
		}

		RandomListNode cur = head;
		RandomListNode copyHead = null;
		RandomListNode copyCur = null;

		// 形成图1
		while(cur != null){
			copyCur = new RandomListNode(cur.label);
			if(copyHead == null){
				copyHead = copyCur;
			}
			copyCur.next = cur.next;
			cur.next = copyCur;
			cur = cur.next.next;
		}

		// 形成图2
		// 注意此处必须要分成两个while loop而不能合并。
		// 如果合并，则在两对random指针互相形成环时会出错！
		cur = head;
		while(cur != null){
			cur.next.random = cur.random!=null ? cur.random.next : null;		// 设置copy节点的random指针
			cur = cur.next.next;
		}

		cur = head;
		while(cur != null){
			copyCur = cur.next;
			cur.next = cur.next.next;			// 恢复cur节点的next指针
			copyCur.next = cur.next!=null ? cur.next.next : null;		// 设置copy节点的next指针
			cur = cur.next;
		}

		return copyHead;
	}


}
