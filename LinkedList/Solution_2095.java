import java.util.*;

public class Solution_2095 {
    public ListNode removeMiddle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    static ListNode fromArray(int... vals) {
        if (vals == null || vals.length == 0) return null;
        ListNode head = new ListNode(vals[0]);
        ListNode current = head;
        for (int i = 1; i < vals.length; i++) {
            current.next = new ListNode(vals[i]);
            current = current.next;
        }
        return head;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode node = this;
        while (node != null) {
            sb.append(node.val);
            if (node.next != null) sb.append(" -> ");
            node = node.next;
        }
        return sb.toString();
    }
}

/*
Middle node
The middle node is defined as the item located at the exact halfway point of a list.

If the list contains an even number of items, the middle node is explicitly the second of the two center items.


Similar to related problems:

Middle of the Linked List
Maximum Twin Sum of a Linked List
We can use Floyd 
′
 s Tortoise and Hare algorithm to delete the middle node of a linked list

To delete the node in-place, we must access the node before the middle (predecessor node):

So we initialize our slow pointer at the head, the while fast pointer is already two steps ahead.
jgfh.gif

The slow pointer advances one node at a time, while the fast pointer advances two nodes at a time.

When the fast pointer reaches the end, the slow pointer will be exactly at the predecessor of the middle node:
We only need one iteration to locate this predecessor and reassign its pointer to complete the deletion.

Time Complexity: O(n)
Space Complexity: O(1)
 */