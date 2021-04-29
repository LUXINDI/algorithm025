package chap10;

public class Main {

}


interface IntStack {
  void push(int val);
  int pop();
  int peek();
  boolean isEmpty();
  void clear();
}

//实现一个接口
// option + enter
class IntStackArrayListImpl implements IntStack {

  @Override
  public void push(int val) {

  }

  @Override
  public int pop() {
    return 0;
  }

  @Override
  public int peek() {
    return 0;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public void clear() {

  }
}
