/**
 * The `linklist` class in Java implements various linked list operations and includes methods for
 * checking palindrome, removing nth node from the end, finding the middle node, and detecting cycles
 * in the linked list.
 */

package ds_practice.java;
import java.util.Stack;

class linklist
{
    Node head;
    class Node
    {   
        String data;
        Node next;
        
        Node(String data)
        {
            this.data=data;
            this.next= null;
        }
    }
 // The code snippet provided contains several methods that operate on a linked list implemented in
 // Java
    public void addFirst(String data)
    {
        Node newNode = new Node(data);
        if(head==null)
        {
            head= newNode;
            return;
        }
        newNode.next= head;
        head = newNode;
    }
    public void addLast(String data)
    {
        Node newNode =  new Node(data);
        if(head==null)
        {
            head= newNode;
            return;
        }
        Node currentNode = head;
        while(currentNode.next!=null)
        {
            currentNode = currentNode.next;
        }
        currentNode.next= newNode;   
    }
    public void delFirst()
    {
        if(head==null)
        {
            System.out.println("empty");
            return;
        }
        head= head.next;
    }
    public void delLast()
    {
        if(head==null)
        {
            System.out.println("Empty");
            return;
        }
        else if(head.next==null)
        {
            head= null;
            return;
        }
        else
        {
            Node temp = head;
            while(temp.next.next!=null)
            {
                temp= temp.next;
            }
            temp.next=null;
        }
    }
    public void printList()
    {
        Node currNode = head;
        if(currNode==null)
        {
            System.out.println("Empty");
            return;
        }
        while(currNode!=null)
        {
            System.out.print(currNode.data+"->");
            currNode=currNode.next;
        }
        System.out.print("Null");
        System.out.println("");
    }
    public void reverseList()
    {
        if(head==null||head.next==null)
        {
            return;
        }
        Node prev = null;
        Node current= head;
        while(current!=null){
            Node next= current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        head.next=null;
        head=prev;
    }
    // The `removeNthFromEnd` method in the `linklist` class is a problem-solving method that
    // removes the nth node from the end of a linked list. Here's a breakdown of what the method
    // does:
    //problem solving//
    public Node removeNthFromEnd(Node head , int n)//remove nth node from the end//
    {
        if(head==null)
            return null;
            
        int size =0;
        Node curr = head;
        while(curr!=null)
        {
            curr=curr.next;
            size++;
        }
        if(n==size)
                return head.next;
        int index= size-n; // previous node of the nth node
        Node prevNode = head;
        int i=1;
        while(i!=index)
        {
            prevNode=prevNode.next;
            i++;
        }
        prevNode.next= prevNode.next.next;
            
            return head;
    }
    // The `findMid` method in the `linklist` class is implementing Floyd's algorithm, also known as
    // the hare and turtle algorithm, to find the middle node of a linked list.
    public Node findMid(Node head)
    {
        Node hare = head;
        Node turtle = head;
        while(hare.next!=null&&hare.next.next!=null)
        {
            turtle=turtle.next;
            hare= hare.next.next;
        }
            
        return turtle;
    }
        //problem solving
    /**
     * The function `isPalindrom` in Java checks if a linked list is a palindrome by using a stack to
     * compare elements in reverse order.
     * 
     * @param head The `head` parameter in the `isPalindrom` method represents the starting node of a
     * linked list. The method is checking whether the elements in the linked list form a palindrome,
     * meaning they read the same forwards and backwards. The method uses a stack to compare elements
     * in the linked list from
     * @return The method isPalindrom(Node head) returns a boolean value indicating whether the linked
     * list represented by the input head node is a palindrome or not. If the linked list is a
     * palindrome, the method returns true. If it is not a palindrome, the method returns false.
     */
    public boolean isPalindrom(Node head) 
    {
        if (head == null || head.next == null) 
        {
            return true;
        }
        Stack<String> stack = new Stack<>();
        Node curr = head;
        while (curr != null) 
        {
            stack.push(curr.data);
            curr = curr.next;
        }
    // Reset pointer to head
        curr = head;

    // Compare each element with the top of the stack
        while (curr != null) 
        {
            if (!curr.data.equals(stack.pop())) 
            {
                return false;
            }
            curr = curr.next;
        }

        return true;
    }
    //problem solving
  /**
   * The function checks if a linked list has a cycle by using the Floyd's Tortoise and Hare algorithm.
   * 
   * @param head The `head` parameter in the `hasCycle` method represents the starting node of a linked
   * list. The method is checking whether there is a cycle in the linked list by using the Floyd's
   * Cycle Detection Algorithm. The `turtle` and `hare` nodes are used to traverse the linked list at
   * @return The `hasCycle` method returns a boolean value - `true` if there is a cycle in the linked
   * list starting from the given `head` node, and `false` otherwise.
   */
    public boolean hasCycle(Node head)
    {
        if(head==null){
            return false;
        }
        Node turtle = head;
        Node hare = head;
        while(hare!=null && hare.next!=null)
        {
            hare = hare.next.next;
            turtle = turtle.next;
            if(hare==turtle)
            {
                return true;
            }
        }
        return false;
    }
}
    
public class LL 
{   
    public static void main(String[] args) 
    {
        System.out.println("Hello Java");
        linklist list = new linklist();
        
        // Test 1: Basic Operations
        System.out.println("1. Testing Basic Linked List Operations:");
        System.out.println("Initial list:");
        list.printList();
        
        // Add elements
        list.addFirst("C");
        list.addFirst("B");
        list.addFirst("A");
        list.addLast("D");
        list.addLast("E");
        
        System.out.println("After adding A, B, C, D, E:");
        list.printList();
        
        // Remove elements
        list.delFirst();
        System.out.println("After removing first element:");
        list.printList();
        
        list.delLast();
        System.out.println("After removing last element:");
        list.printList();
        
        // Test 2: Reverse List
        System.out.println("\n2. Testing Reverse Operation:");
        System.out.println("Original list:");
        list.printList();
        
        list.reverseList();
        System.out.println("After reversing:");
        list.printList();
        
        // Test 3: Palindrome Detection
        System.out.println("\n3. Testing Palindrome Detection:");
        
        // Create palindrome list
        linklist palindromeList = new linklist();
        palindromeList.addLast("M");
        palindromeList.addLast("A");
        palindromeList.addLast("D");
        palindromeList.addLast("A");
        palindromeList.addLast("M");
        
        System.out.print("List: ");
        palindromeList.printList();
        System.out.println("Is palindrome: " + palindromeList.isPalindrom(palindromeList.head));
        
        // Create non-palindrome list
        linklist nonPalindromeList = new linklist();
        nonPalindromeList.addLast("H");
        nonPalindromeList.addLast("E");
        nonPalindromeList.addLast("L");
        nonPalindromeList.addLast("L");
        nonPalindromeList.addLast("O");
        
        System.out.print("List: ");
        nonPalindromeList.printList();
        System.out.println("Is palindrome: " + nonPalindromeList.isPalindrom(nonPalindromeList.head));
        
        // Test 4: Remove Nth Node from End
        System.out.println("\n4. Testing Remove Nth Node from End:");
        linklist removeTestList = new linklist();
        removeTestList.addLast("1");
        removeTestList.addLast("2");
        removeTestList.addLast("3");
        removeTestList.addLast("4");
        removeTestList.addLast("5");
        
        System.out.println("Original list:");
        removeTestList.printList();
        
        removeTestList.removeNthFromEnd(removeTestList.head, 2);
        System.out.println("After removing 2nd node from end:");
        removeTestList.printList();
        
        // Test 5: Find Middle Node
        System.out.println("\n5. Testing Find Middle Node:");
        linklist middleTestList = new linklist();
        middleTestList.addLast("A");
        middleTestList.addLast("B");
        middleTestList.addLast("C");
        middleTestList.addLast("D");
        middleTestList.addLast("E");
        
        System.out.println("List with odd number of elements:");
        middleTestList.printList();
        linklist.Node middle = middleTestList.findMid(middleTestList.head);
        System.out.println("Middle node: " + middle.data);
        
        // Even number of elements
        linklist middleTestList2 = new linklist();
        middleTestList2.addLast("A");
        middleTestList2.addLast("B");
        middleTestList2.addLast("C");
        middleTestList2.addLast("D");
        
        System.out.println("List with even number of elements:");
        middleTestList2.printList();
        linklist.Node middle2 = middleTestList2.findMid(middleTestList2.head);
        System.out.println("Middle node: " + middle2.data);
        
        // Test 6: Cycle Detection (simulated)
        System.out.println("\n6. Testing Cycle Detection:");
        linklist cycleList = new linklist();
        cycleList.addLast("A");
        cycleList.addLast("B");
        cycleList.addLast("C");
        cycleList.addLast("D");
        
        System.out.println("List without cycle:");
        cycleList.printList();
        System.out.println("Has cycle: " + cycleList.hasCycle(cycleList.head));
        
        System.out.println("\n=== All Tests Completed ===");
    }  
}
