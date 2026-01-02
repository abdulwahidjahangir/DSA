package TwoPointersAndSlidingWindow;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }

        int nodeToRemove = count - n;

        if (nodeToRemove == 0) {
            return head.next;
        }

        temp = head;
        while (temp != null && nodeToRemove > 1) {
            temp = temp.next;
            nodeToRemove--;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }

        return head;
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
