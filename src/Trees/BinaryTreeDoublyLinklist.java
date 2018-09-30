package Trees;

public class BinaryTreeDoublyLinklist {

    public static tNode head =null;
    public static tNode prev =null;
    public static void main(String args[]){
        tNode root = new tNode(1);
        root.left = new tNode(2);
        root.right = new tNode(3);
        
        BinaryTreeDoublyLinklist b = new BinaryTreeDoublyLinklist();
        tNode prev =null;
        b.binaryTreeToDoublyLinklist(root);
        tNode current= head;
        while(current !=null){
            System.out.print(current.data+" ");
            current=current.right;
        }
    }

    private void binaryTreeToDoublyLinklist(tNode root) {
      
        if(root ==null){
            return;
        }
       binaryTreeToDoublyLinklist(root.left);
        if(head==null){
            head=root;
            prev =head;
        }else{
            root.left=prev;
            prev.right=root;
            prev=root;
        }
        binaryTreeToDoublyLinklist(root.right);
    }
    
    
}



