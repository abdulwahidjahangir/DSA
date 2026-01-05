package TwoPointersAndSlidingWindow;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeLists(ListNode[] lists, int st, int end) {
        if (st > end) {
            return null;
        }

        if (st == end) {
            return lists[st];
        }

        int mid = st + ((end - st) / 2);

        ListNode left = mergeLists(lists, st, mid);
        ListNode right = mergeLists(lists, mid + 1, end);

        ListNode ans = merge(left, right);

        return ans;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }

        ListNode newHead = new ListNode(-1);
        ListNode tail = newHead;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
            tail.next = null;
        }

        if (head1 != null) {
            tail.next = head1;
        }

        if (head2 != null) {
            tail.next = head2;
        }

        return newHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}