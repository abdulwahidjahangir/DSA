package TwoPointersAndSlidingWindow;

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newHead = new ListNode(-200);
        ListNode tail = newHead;

        while (head != null) {
            int val = head.val;
            int count = 0;
            while (head != null && head.val == val) {
                head = head.next;
                count++;
            }

            if (count == 1) {
                tail.next = new ListNode(val);
                tail = tail.next;
            }
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