package august24;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode l = new ListNode(), r = new ListNode();
        ListNode lcurr = l, rcurr = r;

        while (head != null) {
            if (head.val < x) {
                lcurr.next = head;
                lcurr = lcurr.next;
            } else {
                rcurr.next = head;
                rcurr = rcurr.next;
            }
            head = head.next;
        }

        lcurr.next = r.next;
        rcurr.next = null;

        return l.next;
    }

    public static void main(String[] args) {
        PartitionList pl = new PartitionList();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(2);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(2);

        pl.partition(l1, 3);
    }

}
