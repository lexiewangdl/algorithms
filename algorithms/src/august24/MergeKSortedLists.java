package august24;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    class ListNodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode a, ListNode b) {
            if (a.val < b.val) {
                return -1;
            } else if (a.val == b.val) {
                return 0;
            }
            return 1;
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode();
        ListNode resultPointer = result;
        if (lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>(new ListNodeComparator());
        for (ListNode n : lists) {
            if (n != null) { pq.add(n); }
        }

        while (!pq.isEmpty()) {
            ListNode curr = pq.remove();
            resultPointer.next = curr;
            resultPointer = resultPointer.next;
            if (curr.next != null) {
                pq.add(curr.next);
            }
        }

        return result.next;
    }
}
