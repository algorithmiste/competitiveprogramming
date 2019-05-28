/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {return head;}

        ListNode prev = null, cur = head, suivant = cur.next;
        if (suivant != null) {
            ListNode temp = suivant.next;
            prev = suivant; head = prev;
            prev.next = cur;
            suivant = temp;
            cur.next = suivant;
        } else {return head;}
        if (suivant != null) {
            prev = prev.next;
            cur = cur.next;
            suivant = suivant.next;
        }
        while (prev != null && cur != null && suivant != null) {
            boolean finished = false;
            ListNode tempCur = cur, suivantNext = suivant.next;
            cur = suivant;
            prev.next = cur;
            suivant = tempCur;
            cur.next = suivant;
            suivant.next = suivantNext;

            for (int i = 0; i < 2; ++i) {
                if (suivant.next == null) {
                    finished = true; break;
                } else {
                    suivant = suivant.next;
                }
            }
            if (!finished) {
                prev = prev.next.next;
                cur = cur.next.next;

            } else {
                return head;
            }
        }
        return head;
    }
}
