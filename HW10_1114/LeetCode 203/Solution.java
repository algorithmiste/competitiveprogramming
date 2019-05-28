/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode cur = head;
        while (cur != null && cur.val == val) {
            head = cur.next;
            cur = head;
        }
        while(cur != null && cur.next != null) {
            ListNode suivant = cur.next;
            if (suivant.val == val) {
                cur.next = cur.next.next;
            }
            else {
                cur = cur.next;
            }
        }
        return head;

    }
}
