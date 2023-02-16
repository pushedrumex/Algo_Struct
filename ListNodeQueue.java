public class ListNodeQueue {
    private LinkedList list;
    private LinkedList.ListNode head;

    class EmptyQueueException extends RuntimeException{
        @Override
        public String getMessage() {
            return "큐가 비어있습니다.";
        }
    }

    public ListNodeQueue() {
        this.list = new LinkedList();
        this.head = null;
    }

    void enqueue(int data) {
        LinkedList.ListNode node = new LinkedList.ListNode(data);
        head = list.add(head, node, size() + 1);
    }

    void dequeue() {
        if (size() == 0) {
            throw new EmptyQueueException();
        }
        head = list.remove(head, 1);
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
