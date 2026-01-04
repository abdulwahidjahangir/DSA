package TwoPointersAndSlidingWindow;

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevLeft = dummy;
        ListNode curr = head;

        for (int i = 1; i < left; i++) {
            prevLeft = curr;
            curr = curr.next;
        }

        ListNode prev = null;
        for (int i = 0; i <= right - left; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        prevLeft.next.next = curr;
        prevLeft.next = prev;

        return dummy.next;
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
