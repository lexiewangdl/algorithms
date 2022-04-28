package april;

import java.util.Scanner;

class AddTwoNumbers {
	public class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	int carry = 0;
    	ListNode dummy = new ListNode(0); // Dummy head of the returning list
    	ListNode p = l1, q = l2, curr = dummy;
    	
    	while (p != null || q != null) { // While one of the linked lists haven't been looped through
    		int x, y;
    		x = (p == null) ? 0 : p.val; // If reached l1's end, add 0 instead
    		y = (q == null) ? 0 : q.val;
    		int sum = x + y + carry; // Current sum is sum of two numbers in each linked list plus carry from previous node
    		carry = sum / 10;
    		
    		curr.next = new ListNode(sum % 10); // Save the units digit in next node of returning list
    		curr = curr.next;
    		if (p != null) p = p.next;
    		if (q != null) q = q.next;
    	}
    	if (carry > 0) { // In case we have one extra carry at the end
    		curr.next = new ListNode(carry);
    	}
    	
    	return dummy.next;
    }
    
    
    public static void main(String[] args) {
    	AddTwoNumbers atn = new AddTwoNumbers();
    	Scanner scanner = new Scanner(System.in);
    	
    	int n = scanner.nextInt();
    	int m = scanner.nextInt();
    	
    	ListNode curr = atn.new ListNode();
    	for (int i=0; i < n; i++) {
    		if (i == 0) {
    			curr.val = scanner.nextInt();
    		} else {
    			ListNode newNode = atn.new ListNode(scanner.nextInt());
    			curr.next = newNode;
    			curr = curr.next;
    		}
    	}

    	ListNode curr2 = atn.new ListNode();
    	for (int i=0; i < n; i++) {
  
    		if (i == 0) {
    			curr2.val = scanner.nextInt();
    		} else {
    			ListNode newNode = atn.new ListNode(scanner.nextInt());
    			curr2.next = newNode;
    			curr2 = curr2.next;
    		}
    	}

    	ListNode result = atn.addTwoNumbers(curr, curr2);
    	
    	System.out.println(result.val);
    	while (result.next != null) {
    		System.out.println(result.next.val);
    	}
    	
    }
    
}