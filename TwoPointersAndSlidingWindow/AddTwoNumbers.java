package TwoPointersAndSlidingWindow;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode head = new ListNode(-1);
        ListNode tail = head;

        int carry = 0;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;

            int rem = sum % 10;
            carry = sum / 10;

            tail.next = new ListNode(rem);
            tail = tail.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;

            int rem = sum % 10;
            carry = sum / 10;

            tail.next = new ListNode(rem);
            tail = tail.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;

            int rem = sum % 10;
            carry = sum / 10;

            tail.next = new ListNode(rem);
            tail = tail.next;
            l2 = l2.next;
        }

        while (carry > 0) {
            int sum = carry;

            int rem = sum % 10;
            carry = sum / 10;

            tail.next = new ListNode(rem);
            tail = tail.next;
        }

        return head.next;
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
