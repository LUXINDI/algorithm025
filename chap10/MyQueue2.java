package chap10;

public class MyQueue2 {
  /*
   * @param item: An integer
   * @return: nothing
   */
  int MAXSIZE = 10000;
  int[] num = new int[MAXSIZE];
  int head, tail;
  public MyQueue2() {
    head = 0;
    tail = 0;
  }
  public void enqueue(int item) {
    // write your code here
    if (tail == MAXSIZE) return;
    num[tail++] = item;
  }

  /*
   * @return: An integer
   */
  public int dequeue() {
    // write your code here
    if (head == tail) return -1;
    return num[head++];
  }
}


