package may;

// 21. Merge Two Sorted Lists
public class MergeTwoSortedLists {

	 // Definition for singly-linked list.
	 public class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	 
	 public static ListNode smaller(ListNode a, ListNode b) {
		 return (a.val < b.val) ? a : b;
	 }
	 
	 public static ListNode bigger(ListNode a, ListNode b) {
		 return (b.val < a.val) ? a : b;
	 }
	 
	 public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

		 ListNode result = new ListNode(0);
		 
		 ListNode a = list1, b = list2, c = result;
		 
		 while (a != null && b != null) {
			 if (a.val < b.val) {
				 c.next = a;
				 a = a.next;
			 } else {
				 c.next = b;
				 b = b.next;
			 }
			 c = c.next;
		 }
		 
		 if (a != null)
			 c.next = a;
		 if (b != null)
			 c.next = b;

		 return result.next;
	 }


}
