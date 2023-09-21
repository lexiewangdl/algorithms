package september23;

public class ReverseList {

    // Iterative Solution
    public ListNode iterativeReverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // Recursive Solution
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // Recursive calls
        ListNode reverseHead = reverseList(head.next);

        // Post-order processing
        head.next.next = head;
        head.next = null;

        return reverseHead;
    }

}
