/**
 * The BinaryTree class in Java defines methods for building, traversing, and calculating properties of
 * a binary tree, including pre-order, in-order, post-order, and level-order traversal, as well as
 * counting nodes, summing node values, and determining tree height.
 */

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
// The code snippet provided defines several methods for traversing a binary tree:
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
    //TC= O(n)
// The provided code snippet contains three methods for calculating properties of a binary tree:
    public static int countNumNodes(Node root)
    {
        if(root==null)
            return 0;
        int leftnodes = countNumNodes(root.left);
        int rightnodes =  countNumNodes(root.right);

        return leftnodes+rightnodes+1;
    }
    //TC= O(n)
    public static int sumOfNodes(Node root)
    {
         if(root==null)
            return 0;
        int leftsum = sumOfNodes(root.left);
        int rightsum = sumOfNodes(root.right);

        return leftsum+rightsum+root.data;
    }
    //TC= O(n)
    public static int treeHight(Node root)
    {
        if(root==null)
            return 0;
        int leftHeight = treeHight(root.left);
        int rightHeight = treeHight(root.right);

        return Math.max(leftHeight, leftHeight) +1;
    }
    public static void main(String[] args) 
    {
        
        int nodes[]={1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        
        Binarytree tree = new Binarytree();
        Node root= tree.builtTree(nodes);
        
        System.out.print("Number of Nodes: "+countNumNodes(root));
        System.out.print("\nSum of Node data: "+sumOfNodes(root));
        System.err.print("\nTree height: "+treeHight(root));
        System.out.print("\nRoot data: "+root.data);
        
        System.out.print("\nPre-Order: ");
        preOrder(root);
        
        System.out.print("\nIn-Order: ");
        inOrder(root);
        
        System.out.print("\nPost-Order: ");
        postOrder(root);
       
        System.out.println("\nLevel-Order: ");
        levelOrder(root);

    }
    
}
