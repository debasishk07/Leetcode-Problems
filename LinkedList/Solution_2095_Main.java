public class Solution_2095_Main {
    public static void main(String[] args) {
        Solution_2095 solution = new Solution_2095();

        ListNode head1 = ListNode.fromArray(1, 2, 3, 4, 5);
        System.out.println("Input: 1 -> 2 -> 3 -> 4 -> 5");
        System.out.println("Output: " + solution.removeMiddle(head1));
        System.out.println("Expected: 1 -> 2 -> 4 -> 5");
        System.out.println();

        ListNode head2 = ListNode.fromArray(1, 2, 3, 4);
        System.out.println("Input: 1 -> 2 -> 3 -> 4");
        System.out.println("Output: " + solution.removeMiddle(head2));
        System.out.println("Expected: 1 -> 2 -> 4");
    }
}
