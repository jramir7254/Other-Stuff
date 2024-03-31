public class LinkedList {
    private Node head;
    private Node last;
    private int size;


    /*---------------- Constructors ----------------*/

    public LinkedList() {                
        this.head  = this.last  = null;  
    }


    public LinkedList(Node newNode) {
        this.head = newNode;
        this.last = this.head;
    }

    /*---------------- Constructors ----------------*/
    
    

    /*----------------- Get Method -----------------*/

    public Node get(int index) {
        if(index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }
        return get(index, head);
    }


    private Node get(int index, Node getNode) {
        for(int i = 0; i < index; i++) {
            getNode = getNode.getNext();
        }
        return getNode;
    }

    /*----------------- Get Method -----------------*/



    /*----------------- Add Methods ----------------*/

    //Adds node at end of list
    public void add(Node newNode) {
        if(head == null) 
            head = newNode;
        else 
            last.setNext(newNode);
        
        last = newNode;
        size++;
    }


    //Adds node at specified index of list
    public void add(int index, Node newNode) {
        if(index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }

        if(index == 0) {
            newNode.setNext(head);
            head = newNode;
        }
        else {
            Node addAfter = get(index - 1);
            addAfter.addNodeAfter(newNode);
        }
        size++;
    }

    /*----------------- Add Methods ----------------*/


    
    /*----------------- Set Method -----------------*/

    public void set(int index, Node newNode) {
        if(index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }

        remove(index);
        size++;
        add(index, newNode);
        size--;
    }

    /*----------------- Set Method -----------------*/

    

    /*--------------- Remove Methods ---------------*/

    //Removes node at end of list
    public Node remove() {
        Node lastRemoved;

        if(isEmpty()) {
            throw new IndexOutOfBoundsException("Index " + 0 + " out of bounds for length " + size);
        }

        if(head.getNext() == null) {
            lastRemoved = head;
            head = null;
        }
        else {
            Node beforeLast = get(size - 2);
            lastRemoved = beforeLast.getNext();
            beforeLast.setNext(null);
            last = beforeLast;
        }
        size--;
        return lastRemoved;
    }


    //Removes node at specified index of list
    public Node remove(int index) {
        Node removed;

        if(index < 0 || index > size - 1 || isEmpty()) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }

        if(index == 0) {
            removed = head;
            head = head.getNext();
        }
        else {
            Node before = get(index - 1);
            removed = before.getNext();
            before.setNext(removed.getNext());
        }
        size--;
        return removed;
    }

    /*--------------- Remove Methods ---------------*/



    /*----------------- Get Methods ----------------*/

    public boolean isEmpty() { return head == null; }

    public int size() { return this.size; }

    public boolean contains(int containsValue) { return contains(containsValue, head); }


    private boolean contains(int containsValue, Node traverse) {
        while(traverse != null) {
            if(traverse.getValue() == containsValue)
                return true;
            traverse = traverse.getNext();
        }
        return false;
    }


    public Node getMin() {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException("Index " + 0 + " out of bounds for length " + size);
        }
        return getMin(head);
    }


    private Node getMin(Node traverse) {
        Node minNode = traverse;
        while(traverse != null) {
            minNode = traverse.getValue() < minNode.getValue() ? traverse : minNode;
            traverse = traverse.getNext();
        }
        return minNode;  
    }


    public Node getMax() {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException("Index " + 0 + " out of bounds for length " + size);
        }
        return getMax(head);
    }


    private Node getMax(Node traverse) {
        Node maxNode = traverse;
        while(traverse != null) {
            maxNode = traverse.getValue() > maxNode.getValue() ? traverse : maxNode;
            traverse = traverse.getNext();
        }
        return maxNode;  
    }

    /*----------------- Get Methods ----------------*/



    /*---------------- Print Methods ---------------*/

    public void printEvens() { printEvens(head); }


    private void printEvens(Node traverse) {
        while(traverse != null) {
            if(traverse.getValue() % 2 == 0)
                System.out.print(traverse.getValue() + " ");
            traverse = traverse.getNext();
        }
        System.out.println();
    }


    public void printOdds() { printOdds(head); }


    private void printOdds(Node traverse) {
        while(traverse != null) {
            if(traverse.getValue() % 2 != 0)
                System.out.print(traverse.getValue() + " ");
            traverse = traverse.getNext();
        }
        System.out.println();
    }


    public void printList() { 
        printList(head); 
    }


    private void printList(Node traverse) {
        while(traverse != null) {
           System.out.print(traverse + " ");
           traverse = traverse.getNext(); 
        }
        System.out.println();
    }


    public void printReverse() { 
        printReverse(head); 
        System.out.println();
    }


    private void printReverse(Node traverse) {
        if(traverse.getNext() != null) {
            printReverse(traverse.getNext());
        }
        System.out.print(traverse + " ");
    }

    /*---------------- Print Methods ---------------*/
}
