package chap10;


//用链表实现Queue

class Node {
  public int val;
  public Node next;
  public Node(int _val) {
    val = _val;
    next = null;
  }
  public Node(int _val, Node _next) {
    val = _val;
    next = _next;
  }
}
public class MyQueue {
  /*
   * @param item: An integer
   * @return: nothing
   */
  public Node head, tail;
  public MyQueue() {
    head = null;
    tail = null;
  }
  public void enqueue(int item) {
    // write your code here
    if (head == null) {
      tail = new Node(item);
      head = tail;
    } else {
      tail.next = new Node(item);
      tail = tail.next;
    }
  }

  /*
   * @return: An integer
   */
  public int dequeue() {
    // write your code here
    if (head != null) {
      int item = head.val;
      head = head.next;
      return item;
    }
    return -1;
  }
}
