
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    static class Node
    {
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }    
    static class Binarytree
    {
        static int index=-1;
        public Node builtTree(int nodes[])
        {
            index++;
            if(nodes[index]==-1||index>=nodes.length)
                return null;
            Node newNode = new Node(nodes[index]);
            newNode.left = builtTree(nodes);
            newNode.right = builtTree(nodes);
        
            return newNode;
        }
    }
    public static void preOrder(Node root)
    {
        if(root==null)
            return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void inOrder(Node root)
    {
        if(root==null)
            return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static void postOrder(Node root)
    {
        if(root==null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }
    
    //BFS
    public static void levelOrder(Node root)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty())
        {
            Node current = q.remove();
            if(current==null){
                System.out.println("");
                if(q.isEmpty())
                    break;
                else
                    q.add(null);
            }
            else
            {
                System.out.print(current.data+" ");
                if(current.left!=null)
                    q.add(current.left);
                if(current.right!=null)
                    q.add(current.right);
            }
        }
    }
    public static void main(String[] args) 
    {
        
        int nodes[]={1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        
        Binarytree tree = new Binarytree();
        Node root= tree.builtTree(nodes);
       
        System.out.println(root.data);
        
        System.out.print("Pre-Order: ");
        preOrder(root);
        
        System.out.print("\nIn-Order: ");
        inOrder(root);
        
        System.out.print("\nPost-Order: ");
        postOrder(root);
       
        System.out.println("\nLevel-Order: ");
        levelOrder(root);
     
    }
    
}
