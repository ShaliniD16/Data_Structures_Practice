import java.util.Scanner;

public class DeleteEveryKthNode {
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
        System.out.print("Enter the k value: ");
        int k = scn.nextInt();
        deleteEveryKthNode(k,head);
        display(head);


    }
    public static void deleteEveryKthNode(int k, Node head){
        int i = 1;
        Node curr = head;
        Node prv = null;
        while(curr!=null){
            if(i%k==0){
                prv.next = curr.next;

            }
            prv = curr;
            curr = curr.next;

            i++;

        }
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
