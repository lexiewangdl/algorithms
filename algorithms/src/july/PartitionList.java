package july;


public class PartitionList {
	
	// 86. Partition List
	// Given the head of a linked list and a value x, partition it such that all nodes
	// less than x come before nodes greater than or equal to x.
	// Preserve the original relative order of the nodes in each of the two partitions.
	
	public class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
    public ListNode partition(ListNode head, int x) {
    	
    	ListNode smaller = new ListNode(0);
    	ListNode smallerHead = smaller;

    	ListNode larger = new ListNode(0);
    	ListNode largerHead = larger;
    	
    	ListNode cur = head;
    	
    	while (cur != null) {
    		if (cur.val < x) {
    			smaller.next = cur;
    			smaller = smaller.next;
    		} else {
    			larger.next = cur;
    			larger = larger.next;
    		} 
    		
    		cur = cur.next;
    	}
    	
    	smaller.next = largerHead.next;
    	larger.next = null;
        
    	return smallerHead.next;
    }

}
