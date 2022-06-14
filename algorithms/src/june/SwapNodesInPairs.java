package june;

public class SwapNodesInPairs {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
    public ListNode swapPairs(ListNode head) {
        
    	if (head == null || head.next == null)
    		return head;

    	// The tail
    	ListNode tail = head.next.next;
    	// The second element becomes first element
    	ListNode newHead = head.next;
    	// Append tail after second element (original head)
    	head.next = tail;
    	// The first element becomes the second
    	newHead.next = head;
    	
    	head = newHead; // Update head
    	
    	head.next.next = swapPairs(head.next.next);
    	
    	return head;
    }
}
