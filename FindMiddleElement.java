import java.util.*;
public class FindMiddleElement {
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }
    public static void main(String[] args){
        Node head = null;
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = scn.nextInt();
        System.out.println("Enter the elements: ");
        for(int i = 0;i<n;i++){
            head = addAtEnd(scn.nextInt(),head);
        }
        System.out.println("The middle element is "+findMiddle(head));
    }
    public static Node addAtEnd(int data,Node head){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            return head;
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;
        return head;

    }
    public static int findMiddle(Node head){
        Node slow = head;
        Node fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
}
