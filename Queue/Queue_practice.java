/**
 * The provided Java class implements a generic Queue data structure with enqueue, dequeue, peek, and
 * printQueue operations for both Integer and String types.
 */

package ds_practice.java;

class Queue<T>
{
    Node head=null;
    Node tail=null;
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
        return head==null && tail==null;
    } 
   // These methods are implementing the basic operations of a queue data structure:
    public void enQueue(T data)
    {
        Node newNode= new Node(data);
        if(tail==null)
        {
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }
    public T deQueue()
    {
        if(isEmpty())
        {
            System.out.println("Empty");
            return null;
        }
        T front= head.data;
        if(head==tail)
        {
            tail=null;
        }
        head=head.next;
        return front;
    }
    public T peek()
    {
        if(isEmpty())
        {
            System.out.println("Empty");
            return null;
        }
        return head.data;
    }
}
public class Queue_practice {
    public static <T> void printQueue(Queue<T> q)
    {
        if(q.isEmpty())
        {
            System.out.println("Queue is Empty");
            return;
        }
        Queue<T> temp =new Queue();
        while(!q.isEmpty())
        {
            T value = q.deQueue();
            System.out.print(value+" ");
            temp.enQueue(value);
        }
        System.out.println("");
        while(!temp.isEmpty())
            q.enQueue(temp.deQueue());
    }
    public static void main(String[] args) 
    {
        System.out.println("Integer Queue");
       
        Queue<Integer> q1 = new Queue<>();
        System.out.print("After enqueue: ");
        q1.enQueue(1);
        q1.enQueue(2);
        q1.enQueue(3);
        q1.enQueue(4);
        q1.enQueue(5);
        q1.enQueue(6);
        printQueue(q1);
        
        System.out.println("Peek: " + q1.peek());
        System.out.print("After dequeue: ");
        q1.deQueue();
        printQueue(q1);
        
        System.out.println("\nString Queue");
        
        Queue<String> q2 = new Queue<>();
        System.out.print("After enqueue: ");
        q2.enQueue("A");
        q2.enQueue("B");
        q2.enQueue("C");
        q2.enQueue("D");
        q2.enQueue("E");
        q2.enQueue("F");
        printQueue(q2);
        
        System.out.println("Peek: " + q2.peek());
        System.out.print("After dequeue: ");
        q2.deQueue();
        printQueue(q2);
    }
}
