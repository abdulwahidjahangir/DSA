package TwoPointersAndSlidingWindow;

public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode evenHead = new ListNode(-1);
        ListNode oddHead = new ListNode(-1);
        ListNode evenTail = evenHead;
        ListNode oddTail = oddHead;

        int i = 0;

        while (head != null) {
            if (i % 2 == 0) {
                evenTail.next = head;
                head = head.next;
                evenTail = evenTail.next;
                evenTail.next = null;
            } else {
                oddTail.next = head;
                head = head.next;
                oddTail = oddTail.next;
                oddTail.next = null;
            }
            i++;
        }

        oddHead = oddHead.next;
        evenTail.next = oddHead;

        return evenHead.next;
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
