package LinkList;

public class KthLastRecursive {

    private static int count = 0;
    private static Node head =null;

    public static void main(String args[]) {

        Node n1 = new Node(5);
        Node n2 = new Node(6);
        Node n3 = new Node(7);
        Node n4 = new Node(8);
        n4.next = null;
        n3.next = n4;
        n2.next = n3;
        n1.next = n2;
        Node head1 = n1;
        Node n = kthLastRecursive(head1, 2);
        System.out.println(n.data);
        revRecursive(head1);      
        LinkedList.print(head);
        moveLastToFirst(head);
        System.out.println();
        LinkedList.print(head);
        
    
    }

    private static Node kthLastRecursive(Node current, int k) {
        Node kthNode;
        if (current == null) {
            return null;
        }
       kthNode =kthLastRecursive(current.next, k);
        count++;
        if (k == count) {
           kthNode=current;
        }
        return kthNode;
    }
    
    private static Node revRecursive(Node current) {
        Node nextNode; 
        if (current.next==null) {
            head= current;
            return current;
        }
        nextNode = revRecursive(current.next);       
        nextNode.next=current;
        current.next=null;
        
     return current;
    }
    
    private static Node moveLastToFirst(Node current) {
        Node nextNode; 
        if (current.next==null) {
            current.next=head;
            head= current;
            return current;
        }
        else{
        nextNode = moveLastToFirst(current.next);       
         if(head==nextNode){
             current.next=null;
         }
        }
        
     return current;
    }
}
