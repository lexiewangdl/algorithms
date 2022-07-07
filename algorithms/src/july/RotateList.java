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
		
		// �����������n
		int n = 1; 
		ListNode iter = head;
		while (iter.next != null) {
			iter = iter.next;
			n++;
		}
		
		// ��������<=1��kΪn�ı���ʱ�����账��
		int shift = n - k % n; // �������ƶ��Ĵ���k >= nʱ�����ǽ���Ҫ�����ƶ�k mod n�μ���
		if (shift == n)
			return head;

		// �ҵ�������ĩβ�ڵ㣬������ͷ�ڵ��������õ��պ�Ϊ��������
		iter.next = head;
		while (shift-- > 0) {
			iter = iter.next;
		}
		ListNode res = iter.next;
		iter.next = null;
		
		return res;
	}

}
