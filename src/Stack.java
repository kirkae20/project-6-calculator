public class Stack <T> {
    private Node top;
    private class Node {
        T data;
        Node next;
        public Node(){
            data = null;
            next = null;
        }
        public Node(T t, Node n) {
            data = t;
            next = n;
        }
    }
    Stack(){
        top = null;
    }
    public void push(T x) {
        Node temp = new Node();

        if(temp == null) {
            System.out.print("Heap Overflow");
            return;
        }
        temp.data = x;
        temp.next = top;
        top = temp;
    }
    public T pop(){
        if(isEmpty()){
            return null;
        }
        else {
            Node temp = top;
            top = top.next;
            return temp.data;
        }
    }
    public boolean isEmpty() {
        return (top == null);
    }
    public T peek(){
        if(isEmpty()){
            return null;
        }
        else{
            return top.data;
        }
    }
}
