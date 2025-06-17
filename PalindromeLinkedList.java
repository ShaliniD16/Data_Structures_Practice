/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prv = null;
        if(head==null || head.next==null) return true;
        while(fast!=null && fast.next!=null){
            prv = slow;
            slow = slow.next;
            fast = fast.next.next;
            
        }
        ListNode reversed = reverse(slow);
        prv.next = null;
        ListNode curr = head;
        while(curr!=null){
            if(curr.val!=reversed.val) return false;
            curr = curr.next;
            reversed = reversed.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prv = null;
        ListNode next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prv;
            prv = curr;
            curr = next;
        }
        return prv;
    }
}
