/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Add Two Numbers.
 * Memory Usage: 45.4 MB, less than 72.73% of Java online submissions for Add Two Numbers.
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode(99); //dummy node
        recursiveAdder(l1, l2, false, answer);
        return answer.next;
    }

    /** helper function.
     * @param carry whether the current digit is greater than 10 and need to be carried
     * @param ans a pointer to the nodes of linked list we are return as our answer
     * @param l1 node 1
     * @param l2 node 2*/
    private void recursiveAdder(ListNode l1, ListNode l2, boolean carry, ListNode ans) {
        if (l1 == null && l2 == null) {
            if (carry) {
                ans.next = new ListNode(1);
            } else {
                return ;
            }
        } else if (l1 == null) {
            if (!carry) {
                ans.next = l2;
            } else {
                int sum = l2.val + 1;
                ans.next = new ListNode(sum % 10);
                recursiveAdder(l1, l2.next, (sum >= 10), ans.next);
            }
        } else if (l2 == null) {
            if (!carry) {
                ans.next = l1;
            } else {
                int sum = l1.val + 1;
                ans.next = new ListNode(sum % 10);
                recursiveAdder(l1.next, l2, (sum >= 10), ans.next);
            }
        } else {
            int sum = l1.val + l2.val;
            if (carry) {
                sum += 1;
            }
            ListNode result = new ListNode((sum % 10));
            ans.next = result;
            recursiveAdder(l1.next, l2.next, (sum >= 10), result);

        }
    }
}