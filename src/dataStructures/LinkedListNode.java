package dataStructures;

public class LinkedListNode<T> {
    //THIS CODE IS GIVEN TO YOU, THERE ARE NO ISSUES WITHIN HERE. I PROMISE. --MARIAM :}
    private T value;
    private LinkedListNode<T> next;

    public LinkedListNode(T val, LinkedListNode<T> next) {
        this.value = val;
        this.next = next;
    }

    public T getValue() {
        return this.value;
    }

    public void setNext(LinkedListNode<T> node) {
        this.next = node;
    }

    public LinkedListNode<T> getNext() {
        return this.next;
    }

    public void append(T value) {
        if (this.next == null) {
            this.next = new LinkedListNode<>(value, null);
        } else {
            this.next.append(value);
        }
    }

}
