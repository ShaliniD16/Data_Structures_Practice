import java.util.*;
public class ReverseLinkedList {
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
        head = reverseLinkedList(head);
        System.out.println("Reversed linked list: ");
        display(head);


    }

    private static Node reverseLinkedList(Node head) {
        Node curr = head;
        Node prv = null;
        Node next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prv;
            prv = curr;
            curr = next;
        }
        return prv;
    }

    public static Node addAtEnd(int data, Node head){
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
    public static void display(Node head){
        Node temp = head;
        while(temp.next!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
}
