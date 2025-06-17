/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLen = getLength(headA);
        int bLen = getLength(headB);
        if(aLen>bLen){
            for(int i = 0;i<aLen-bLen;i++){
                headA = headA.next;
            }
        }else{
            for(int i = 0;i<bLen-aLen;i++){
                headB = headB.next;
            }
        }
        while(headA!=null && headB!=null && headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }
        if(headA==null || headB==null) return null;
        return headA;
    }
    public int getLength(ListNode head){
        int len = 0;
        while(head!=null){
            head = head.next;
            len++;
        }
        return len;
    }
}
