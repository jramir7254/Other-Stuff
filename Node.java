public class Node {
    private int value;
    private Node next;

    public Node() {
        this.value = 0;
        this.next = null;
    }

    public Node(int value) {
        this.value = value;
        next = null;
    }

    public void addNodeAfter(Node nodeAfter) {
        Node temp = this.next;
        this.next = nodeAfter;
        nodeAfter.next = temp;
    }

    public void setValue(int newValue) {
        this.value = newValue;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getValue() {
        return this.value;
    }

    public Node getNext() {
        return this.next;
    }

    public String toString() {
        return "Value: " + value;    
    }
}
