package july;

public class RotateList {

	public class ListNode {
		int val;
	    ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }

	public ListNode rotateRight(ListNode head, int k) {
		
		if (k == 0 || head == null || head.next == null)
			return head;
		
		// 计算出链表长度n
		int n = 1; 
		ListNode iter = head;
		while (iter.next != null) {
			iter = iter.next;
			n++;
		}
		
		// 当链表长度<=1或k为n的倍数时，无需处理
		int shift = n - k % n; // 当向右移动的次数k >= n时，我们进需要向右移动k mod n次即可
		if (shift == n)
			return head;

		// 找到链表最末尾节点，将其与头节点相连，得到闭合为环的链表
		iter.next = head;
		while (shift-- > 0) {
			iter = iter.next;
		}
		ListNode res = iter.next;
		iter.next = null;
		
		return res;
	}

}
