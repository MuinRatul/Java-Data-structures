/**
 * The given Java class implements a generic Stack data structure with methods for push, pop, peek, and
 * additional functionality to push an element to the bottom of the stack and reverse the stack.
 */

package ds_practice.java;
class Stack<T>
{
    Node head;
    class Node{
        T data;
        Node next;
        Node(T data)
        {
            this.data=data;
            next=null;
        }
    }
    public boolean isEmpty()
    {
        return head==null;
    }
    public void push(T data)
    {
        Node newNode = new Node(data);
        if(isEmpty()){
            head= newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }
    public T pop()
    {
        if(isEmpty())
            return null;
        T top= head.data;
        head= head.next;
        return top;
    }
    public T peek()
    {
        if(isEmpty())
            return null;
        T top=head.data;
        return top;
    }
    
    //problem Solving
/**
 * The function `PushAtBottom` recursively pushes an element to the bottom of a stack.
 * 
 * @param s The parameter `s` is a `Stack` of type `T`, which is the stack where the `data` element
 * needs to be pushed at the bottom.
 * @param data The `data` parameter is the element that you want to push to the bottom of the stack
 * `s`.
 */
    public void PushAtBottom(Stack<T> s , T data)
    {
        if(s.isEmpty())
        {
            s.push(data);
            return;
        }
        T top=s.pop();
        PushAtBottom(s,data);
        s.push(top);
    }
 /**
  * The function `reverseStack` recursively reverses the elements of a given stack.
  * 
  * @param s The parameter `s` in the `reverseStack` method is a `Stack` object that holds elements of
  * type `T`. The method recursively reverses the order of elements in the stack.
  */
    public void reverseStack(Stack<T> s)
    {
        if(s.isEmpty()){
            return;
        }
        T top= s.pop();
        reverseStack(s);
        s.PushAtBottom(s, top);     
    }
}

public class Stack_practice {
    
     public static <T> void printStack(Stack<T> s)
     {
        if (s.isEmpty()) 
        {
            System.out.println("Stack is empty");
            return;
        }
        Stack<T> temp = new Stack<>();
        while (!s.isEmpty()) 
        {
            T value = s.pop();
            System.out.print(value + " ");
            temp.push(value);
        }
        System.out.println();
        while (!temp.isEmpty()) 
        {
            s.push(temp.pop());
        }
    }
    public static void main(String[] args)
    {
        System.out.println("Integer Stack");
        
        // Integer Stack
        Stack<Integer> s1 = new Stack<>();
        
        System.out.print("After pushing: ");
        s1.push(1);
        s1.push(2);
        s1.push(3);
        printStack(s1);
        
        System.out.print("After pushing at bottom: ");
        s1.PushAtBottom(s1, 0);
        printStack(s1);
        
        System.out.print("After reversing: ");
        s1.reverseStack(s1);
        printStack(s1);
        
        System.out.println("\nString Stack");
         // String Stack
        Stack<String> s2 = new Stack<>();
        
        System.out.print("After pushing: ");
        s2.push("World");
        s2.push("Hello");
        printStack(s2);
        
        System.out.print("After pushing at bottom: ");
        s2.PushAtBottom(s2, "!");
        printStack(s2);
        
        System.out.print("After reversing: ");
        s2.reverseStack(s2);
        printStack(s2);  
    }
}
