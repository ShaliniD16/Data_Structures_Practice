class SinglyLinkedList1{
    
    static class Node{

        int data; 
        Node next;
        Node(int data){
            this.data=data;
        }
    }
    //head 
    private Node head=null;
    //insertAtBeg()
    public void insertAtBeg(int data){
        Node newNode=new Node(data);
        newNode.next=head;
        head=newNode;
    }
    //insertAtEnd()
    public void  insertAtEnd(int data){
        Node newNode=new Node(data);
        Node temp=head;
        while(temp.next!=null)
            temp=temp.next;
        temp.next=newNode;
    }
    //deleteAtBeg()
    public void deleteAtBeg(){
        head = head.next;

    }
    //deleteAtEnd
    public void deleteAtEnd(){
        Node temp = head;
        while(temp.next.next!=null){
            temp = temp.next;
        }
        temp.next = null;
    }
    //insertAtMiddle
    public void insertAtMiddle(int n, int data){
        Node newNode = new Node(data);
        Node temp = head;
        for(int i = 0;i<n-1 && temp.next!=null;i++){
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;

    }
    //deleteAtMiddle
    public void deleteAtMiddle(int n){
        Node temp = head;
        Node prv = null;
        for(int i = 0;i<n-1 && temp.next!=null;i++){
            prv = temp;
            temp = temp.next;
        }
        prv.next = temp.next;
    }
    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data +"->");
            temp=temp.next;
        }System.out.print("null");
    }
    public void findMiddle(){
        Node slow = head;
        Node fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle element: "+slow.data);
    }
}


public class SinglyLinkedList{
    public static void main(String[] args){
        SinglyLinkedList1 sl=new SinglyLinkedList1();
        sl.insertAtBeg(5); 
        sl.insertAtBeg(6); 
        sl.insertAtBeg(7); 
        sl.insertAtBeg(8); 
        sl.display();
        sl.insertAtEnd(9); 
        System.out.println();
        sl.display();

        sl.deleteAtBeg();
        System.out.println();

        sl.display();
        System.out.println();
        sl.deleteAtEnd();
        sl.display();

        System.out.println();
        sl.insertAtMiddle(2,10);
        sl.display();

        
        System.out.println();
        sl.deleteAtMiddle(2);
        sl.display();

        System.out.println();
        sl.findMiddle();
    }
}
