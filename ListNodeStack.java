public class ListNodeStack {
    private LinkedList list;
    private LinkedList.ListNode head;

    class EmptyStackException extends RuntimeException{
        @Override
        public String getMessage() {
            return "스택이 비어있습니다.";
        }
    }

    public ListNodeStack() {
        this.list = new LinkedList();
        this.head = null;
    }

    void push(int data) {
        LinkedList.ListNode node = new LinkedList.ListNode(data);
        head = list.add(head, node, size() + 1);
    }

    void pop() {
        if (size() == 0) {
            throw new EmptyStackException();
        }
        head = list.remove(head, size());
    }

    int size() {
        int i = 0;
        LinkedList.ListNode ptr = head;

        while (ptr != null) {
            i++;
            ptr = ptr.next;
        }

        return i;
    }

}
